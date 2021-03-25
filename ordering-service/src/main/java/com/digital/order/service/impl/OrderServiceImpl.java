/**
 * 
 */
package com.digital.order.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.digital.order.dao.OrderDao;
import com.digital.order.dto.LoyaltyUpdateKafkaDto;
import com.digital.order.dto.OrderListDto;
import com.digital.order.dto.QuantityUpdateKafkaDto;
import com.digital.order.entity.OrderPlaced;
import com.digital.order.exception.ItemsExceededException;
import com.digital.order.exception.NoSufficientLoyaltyPointsToPurchaseException;
import com.digital.order.exception.OrderAppException;
import com.digital.order.exception.OrderAppProxyException;
import com.digital.order.exception.QuantityExceededPerOrder;
import com.digital.order.proxy.CustomerProxy;
import com.digital.order.proxy.InventoryProxy;
import com.digital.order.service.OrderService;

import feign.FeignException;

/**
 * @author M1056182
 *
 */
@Service
public class OrderServiceImpl implements OrderService {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	
	@Autowired
	private InventoryProxy inventoryProxy;
	
	@Autowired
	private CustomerProxy customerProxy;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	private static final String LOYALTY_UPDATE = "Loyalty_Update";
	
	private static final String QUANTITY_UPDATE = "Quantity_Update";
	
	@Value("${max.items}")
	private int maximumItemsPerOrder;
	
	@Value("${max.quantity}")
	private int maximumQuantityPerOrder;
	
	int totalQuantityOfProductsPurchased = 0;

	
	/**
	 * @param orderListDtos
	 * @param customerId
	 * @implNote process order by communicating other services
	 * @return Order Details
	 * 
	 * @exception ItemsExceededException
	 * @exception QuantityExceededPerOrder
	 * @exception OrderAppProxyException
	 * 
	 * 
	 *@{@link LinkController} CustomerService
	 *@{@link LinkController} InventoryService
	 * 
	 *
	 */
	@Override
	public OrderPlaced processOrder(List<OrderListDto> orderListDtos,int customerId) throws OrderAppException  {
		logger.info("--> process order method is called in service layer");
		OrderPlaced order = null;
		validateItemListSize(orderListDtos);
		validateQuantityPerItem(orderListDtos);
		try {
			logger.debug("-->Communicate with Inventory service to calculate total price of order list");
			double totalProductValue = inventoryProxy.validateInventory(orderListDtos).getBody();
			logger.debug("-->Communicate with customer service to validate available loyalty points to make a purchase");
			double availableLoyaltyPoints = customerProxy.validateLoyaltyPoint(customerId,totalProductValue).getBody();
			if(availableLoyaltyPoints<totalProductValue) {
				reduceProductsAgainstLoyaltyPoints(orderListDtos,availableLoyaltyPoints,totalProductValue);
			}
			else {
			order = new OrderPlaced();
			order.setCustomerId(customerId);
			order.setOrderDate(LocalDate.now());
			order.setOrderValue((int)totalProductValue);
			order.setTotalQuantityOfProducts(totalQuantityOfProductsPurchased);
			order = orderDao.processOrder(order);
			logger.info("-->Order successfully placed in database");
			logger.info("-->Sending loyalty points details to kafka topic to make an update in database");
			kafkaTemplate.send(LOYALTY_UPDATE,new LoyaltyUpdateKafkaDto(customerId, totalProductValue));
			logger.info("-->Sending Inventory details to kafka topic to make an update in database");
			kafkaTemplate.send(QUANTITY_UPDATE,new QuantityUpdateKafkaDto(orderListDtos));
			}
		}
		catch (FeignException e) {
			logger.error("-->Error Occured during communiction with other service.");
			throw new OrderAppProxyException(e.contentUTF8());
		}
		logger.info("-->Order Returned Successfully.!");
		return order;
	}
 


	private void validateQuantityPerItem(List<OrderListDto> orderListDtos) throws OrderAppException {
		Map<Integer, Integer> pdctQty = new HashMap<>();
		for (OrderListDto orderListDto : orderListDtos) {
			if(pdctQty.containsKey(orderListDto.getProductId())) {
				int val = pdctQty.get(orderListDto.getProductId());
				val+=orderListDto.getQuantity();
				pdctQty.put(orderListDto.getProductId(), val);
			}
			else {
				pdctQty.put(orderListDto.getProductId(), orderListDto.getQuantity());
			}
			if(orderListDto.getQuantity()>maximumQuantityPerOrder) {
				logger.error("-->Exception thrown when quantity exceeded the limit.");
				throw new QuantityExceededPerOrder(String.format("Customer can Purchase a max of %d quantity per Item", maximumQuantityPerOrder));
			}
			else {
				totalQuantityOfProductsPurchased+=orderListDto.getQuantity();
			}
		}
		for (Map.Entry<Integer, Integer> entry : pdctQty.entrySet()) {
		       if(entry.getValue() > 10) {
					logger.error("-->Exception thrown when quantity exceeded the limit.");
					throw new QuantityExceededPerOrder(String.format("Customer can Purchase a max of %d quantity per Item", maximumQuantityPerOrder));
		       }
		    }
	}



	private void validateItemListSize(List<OrderListDto> orderListDtos) throws OrderAppException {
		if(orderListDtos.size() > maximumItemsPerOrder) {
			logger.error("-->Exception thrown when items exceeded the limit.");
			throw new ItemsExceededException("Customer can Purchase a max of "+maximumItemsPerOrder+" Items per order");
		}
		
	}


	private void reduceProductsAgainstLoyaltyPoints(List<OrderListDto> orderListDtos, double availableLoyaltyPoints, double totalProductValue) throws OrderAppException {
		orderListDtos.sort(Comparator.comparing(OrderListDto::getProductPriceInPoints).reversed());
		List<String> resArr = new ArrayList<>();
		for (OrderListDto orderListDto : orderListDtos) {
			int count=0;
			if(orderListDto.getProductPriceInPoints()>availableLoyaltyPoints) {
				throw new NoSufficientLoyaltyPointsToPurchaseException("Doesnt have enough loyalty points to make any purchase.");
			}
			while(availableLoyaltyPoints<=totalProductValue) {
				if(orderListDto.getQuantity()==0) {
					break;
				}
				else {
				orderListDto.setQuantity(orderListDto.getQuantity()-1);
				count++;
				totalProductValue-=orderListDto.getProductPriceInPoints();
				}
			}
			if(count!=0)
				resArr.add("-> Product id - "+orderListDto.getProductId()+" have to reduced by "+count+" to make a purchase.  ");
		}
		String errMessageString = "";
		for (String value : resArr) {
			errMessageString+=value;
		}
		throw new QuantityExceededPerOrder(errMessageString);
		
	} 


}

/**
 * 
 */
package com.mindtree.inventory.service.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindtree.inventory.dao.InventoryDao;
import com.mindtree.inventory.dto.OrderListDto;
import com.mindtree.inventory.dto.QuantityUpdateKafkaDto;
import com.mindtree.inventory.entity.Inventory;
import com.mindtree.inventory.exception.InventoryAppException;
import com.mindtree.inventory.exception.KafkaConsumingException;
import com.mindtree.inventory.exception.ProductNotFoundException;
import com.mindtree.inventory.exception.ProductQuantityExceededException;
import com.mindtree.inventory.service.InventoryService;

/**
 * @author M1056182
 *
 */
@Service
public class InventoryServiceImpl implements InventoryService {
	
	private static final Logger logger = LoggerFactory.getLogger(InventoryServiceImpl.class);

	
	@Autowired
	private InventoryDao inventoryDao;
	
	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public double validateInventory(List<OrderListDto> orderList) throws InventoryAppException {
		logger.info("-->ValidateInventory method in service layer");
		double totalOrderValue = 0.0;
		logger.info("-->Looping the Input orderlist to calculate total price.");
		for (OrderListDto orderListDto : orderList) {
			Optional<Inventory> product = inventoryDao.findProductById(orderListDto.getProductId());
			product.orElseThrow(()-> new ProductNotFoundException(" Product with product id "+orderListDto.getProductId()+" was not found..!"));
			if (product.get().getProductQuantity() >= orderListDto.getQuantity()) {
				totalOrderValue+= (orderListDto.getQuantity() * product.get().getPriceInPoints());
			}
			else if(product.get().getProductQuantity() == 0) {
				throw new ProductQuantityExceededException("Product Out Of stock...!");
			}
			else if(orderListDto.getQuantity() > product.get().getProductQuantity()) {
				throw new ProductQuantityExceededException(orderListDto.getQuantity()+" Products are not available in stock make it "+product.get().getProductQuantity()+" or below..! for "+product.get().getProductName());
			}
		}
		logger.info("-->SuccessFully calculated total price and returned.");
		return totalOrderValue;
	}
	
	@KafkaListener(topics = "Quantity_Update", groupId = "group_id")
	public void quantityUpdateFromKafka(String byteData) throws InventoryAppException {
		logger.info("-->quantityUpdateFromKafka methos initiated from kafka topic");
		try {
			QuantityUpdateKafkaDto quantityUpdate = objectMapper.readValue(byteData, QuantityUpdateKafkaDto.class);
			logger.info("-->updateQuantity method initated to update the quantity");
			updateInventory(quantityUpdate);
		} catch (JsonProcessingException | ServiceException ex) {
			logger.error("-->Error occured while processing the kafka method for update quantity.");
			throw new KafkaConsumingException(" Kafka Consumer Exception... while updating Inventory..!");
		}
	}

	private void updateInventory(QuantityUpdateKafkaDto quantityUpdate){
		List<OrderListDto> orderList = quantityUpdate.getOrderList();
		for (OrderListDto orderListDto : orderList) {
			Optional<Inventory> product = inventoryDao.findProductById(orderListDto.getProductId());
			product.get().setProductQuantity(product.get().getProductQuantity() - orderListDto.getQuantity());
			inventoryDao.updateQuantity(product);
		}
		logger.info("-->Successfully Quantity updated in database.");
	}


}

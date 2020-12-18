/**
 * 
 */
package com.mindtree.customer.service.serviceimpl;

import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindtree.customer.dao.CustomerDao;
import com.mindtree.customer.dto.LoyaltyUpdateKafkaDto;
import com.mindtree.customer.entity.Customer;
import com.mindtree.customer.exception.CustomerAppException;
import com.mindtree.customer.exception.CustomerNotFoundException;
import com.mindtree.customer.exception.KafkaConsumingException;
import com.mindtree.customer.exception.LoyaltyPointExceededException;
import com.mindtree.customer.service.CustomerService;

/**
 * @author M1056182
 * <p>Business logic related to customer service written in serviceImpl class<p>
 * 
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);


	private ObjectMapper objectMapper = new ObjectMapper();

	
	/**
	 *@param customerId
	 *@param requiredLoyaltyPoint
	 *@throws LoyaltyPointExceededException
	 * <p> Fetched customer from DB and validate loyalty points against requiredLoyaltyPoints </p>
	 *
	 */
	@Override
	public double validateLoyaltyPoint(int customerId, double requiredLoyaltyPoint) throws CustomerAppException {
		logger.info("-->ValidateLoyalyPoint entered in service Layer");
		Optional<Customer> customer = customerDao.fetchCustomerById(customerId);
		logger.info("customer successfully fetched from database");
		customer.orElseThrow(()-> new CustomerNotFoundException("Customer Not Found In Records..!"));
		double availableLoyaltyPoint = customer.get().getLoyaltyPoint();
		logger.info("-->Calculated Customer available loyalty point");
		if(availableLoyaltyPoint == 0.0) {
			logger.info("-->Exception Thorwn as loyalty points is 0.0 cant make a purchase");
			throw new LoyaltyPointExceededException("Your Loyalty points is 0.0 Cant make a purchase..!");
		}
		logger.info("-->returns Successfully as Eligible to make a purchase");
		return availableLoyaltyPoint;
	}
	

	/**
	 * @param byteData
	 * @throws CustomerAppException
	 */
	@KafkaListener(topics = "Loyalty_Update", groupId = "group_id")
	public void updateLoyaltyPointFromKafka(String byteData) throws CustomerAppException {
		try {
			logger.info("-->updateLoyaltyPointFromKafka method initiated as kafka topic gets object");
			LoyaltyUpdateKafkaDto loyaltyUpdate = objectMapper.readValue(byteData, LoyaltyUpdateKafkaDto.class);
			logger.info("-->Update Customer Loyalty points method initiated..");
			updateCustomerLoyalty(loyaltyUpdate);
		} catch (JsonProcessingException | ServiceException ex) {
			logger.error("--> Error occured while processing the kafka");
			throw new KafkaConsumingException("Kafka Consumer Exception...!");
		}
	}


	/**
	 * @param loyaltyUpdate
	 * @throws CustomerAppException
	 */
	private void updateCustomerLoyalty(LoyaltyUpdateKafkaDto loyaltyUpdate){
		logger.info("-->Fetching customer from DB");
		Optional<Customer> customer = customerDao.fetchCustomerById(loyaltyUpdate.getCustomerId());
		logger.info("customer successfully fetched from database");
		double availableLoyaltyPoint = customer.get().getLoyaltyPoint();
		customer.get().setLoyaltyPoint(availableLoyaltyPoint - loyaltyUpdate.getTotalProductValue());
		customerDao.updateLoyalty(customer);
		logger.info("customer loyaltypoints successfully updated in database");
	}
}


/**
 * 
 */
package com.mindtree.customer.dao.daoimpl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.customer.dao.CustomerDao;
import com.mindtree.customer.entity.Customer;
import com.mindtree.customer.repository.CustomerRepository;

/**
 * @author M1056182
 *
 */
@Service
public class CustomerDaoImpl implements CustomerDao {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerDaoImpl.class);

	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public Optional<Customer> fetchCustomerById(int customerId) {
		logger.info("-->Fetching Customer based on customer ID");
		return customerRepo.findById(customerId);
		
	}

	@Override
	public void updateLoyalty(Optional<Customer> customer) {
		logger.info("-->Updating customer from database");
		 customerRepo.saveAndFlush(customer.get());
	}

}

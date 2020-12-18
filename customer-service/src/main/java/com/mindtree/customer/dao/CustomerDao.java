/**
 * 
 */
package com.mindtree.customer.dao;

import java.util.Optional;

import com.mindtree.customer.entity.Customer;

/**
 * @author M1056182
 *
 */

public interface CustomerDao {

	Optional<Customer> fetchCustomerById(int customerId);

	void updateLoyalty(Optional<Customer> customer);

}

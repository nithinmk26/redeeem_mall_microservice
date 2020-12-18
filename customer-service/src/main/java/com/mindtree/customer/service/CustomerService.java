/**
 * 
 */
package com.mindtree.customer.service;

import com.mindtree.customer.exception.CustomerAppException;

/**
 * @author M1056182
 *
 */
public interface CustomerService {

	double validateLoyaltyPoint(int customerId, double loyaltyPoint) throws CustomerAppException;

}

/**
 * 
 */
package com.digital.customer.service;

import com.digital.customer.exception.CustomerAppException;

/**
 * @author M1056182
 *
 */
public interface CustomerService {

	double validateLoyaltyPoint(int customerId, double loyaltyPoint) throws CustomerAppException;

}

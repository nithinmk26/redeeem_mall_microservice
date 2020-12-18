/**
 * 
 */
package com.mindtree.order.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mindtree.order.exception.CustomerAppException;

/**
 * @author M1056182
 *
 */
@FeignClient("customer-service")
public interface CustomerProxy {
	
	@GetMapping("/api/v1/customerservice/customer/{customerId}/{loyaltyPoint}")
	public ResponseEntity<Double> validateLoyaltyPoint(@PathVariable int customerId,@PathVariable double loyaltyPoint) throws CustomerAppException;

}

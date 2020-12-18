/**
 * 
 */
package com.mindtree.customer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.customer.CustomerServiceApplication;
import com.mindtree.customer.exception.CustomerAppException;
import com.mindtree.customer.service.CustomerService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author M1056182
 * @since 22/11/2020
 * 
 * <h1>Customer Service Application</h1>
 * <p>Customer Service contains Functionality for Validating customer loyalty points upon order request.</p>
 *
 */
@RestController
@RequestMapping("/api/v1/customerservice")
public class CustomerController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService customerService;
	
	/**
	 * @param customerId
	 * @param loyaltyPoint
	 * @return 200 OK on successfully validating customer loyalty points.
	 * @throws CustomerAppException
	 */
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully varified available Loyalty Points"),
			@ApiResponse(code = 404,message = "Failed to varify Loyalty points of customer."),
			@ApiResponse(code = 400,message = "Something Went Wrong"),@ApiResponse(code = 500,message = "Internal Server Error")})
	@GetMapping("/customer/{customerId}/{loyaltyPoint}")
	public ResponseEntity<Double> validateLoyaltyPoint(@PathVariable int customerId,@PathVariable double loyaltyPoint) throws CustomerAppException{
		logger.info("-->ValidateLoyalyPoint API hit successFull ");
		return new ResponseEntity<>(customerService.validateLoyaltyPoint(customerId,loyaltyPoint),HttpStatus.OK);
	}

}

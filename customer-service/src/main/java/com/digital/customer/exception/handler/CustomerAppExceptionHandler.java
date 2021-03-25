/**
 * 
 */
package com.digital.customer.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.digital.customer.controller.CustomerController;
import com.digital.customer.exception.CustomerAppException;

/**
 * @author M1056182
 *
 */
@RestControllerAdvice(assignableTypes = CustomerController.class)
public class CustomerAppExceptionHandler {

	@ExceptionHandler(CustomerAppException.class)
	public ResponseEntity<String> customerAppExceptionHandler(Exception e,Throwable t){
	return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
}
}

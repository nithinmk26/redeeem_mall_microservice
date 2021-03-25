/**
 * 
 */
package com.digital.order.exception.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.digital.order.controller.OrderController;
import com.digital.order.exception.OrderAppException;
import com.digital.order.exception.OrderAppProxyException;

/**
 * @author M1056182
 *
 */
@RestControllerAdvice(assignableTypes = OrderController.class)
public class OrderAppExceptionHandler{

	
	@ExceptionHandler(OrderAppProxyException.class)
	public ResponseEntity<Map<String, Object>> orderAppProxyExceptionHandle(Exception e, Throwable t){
		Map<String, Object> response = new HashMap<>();
		response.put("Error", true);
		response.put("Message", e.getMessage());
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(OrderAppException.class)
	public ResponseEntity<Map<String, Object>> orderAppExceptionHandle(Exception e, Throwable t){
		Map<String, Object> response = new HashMap<>();
		response.put("Error", true);
		response.put("Message", e.getMessage());
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	

}

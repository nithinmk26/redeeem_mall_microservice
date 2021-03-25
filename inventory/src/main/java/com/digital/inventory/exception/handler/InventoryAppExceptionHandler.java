/**
 * 
 */
package com.digital.inventory.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.digital.inventory.controller.InventoryController;
import com.digital.inventory.exception.InventoryAppException;

/**
 * @author M1056182
 *
 */
@RestControllerAdvice(assignableTypes = InventoryController.class)
public class InventoryAppExceptionHandler{
	
	@ExceptionHandler(InventoryAppException.class)
	public ResponseEntity<String> InventoryAppExceptionHandle(Exception e,Throwable t) {
		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	}

}

/**
 * 
 */
package com.mindtree.inventory.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.inventory.dto.OrderListDto;
import com.mindtree.inventory.exception.InventoryAppException;
import com.mindtree.inventory.service.InventoryService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author M1056182
 *
 */
@RestController
@RequestMapping("/api/v1/inventoryservice")
public class InventoryController {
	
	private static final Logger logger = LoggerFactory.getLogger(InventoryController.class);

	
	@Autowired
	private InventoryService inventoryService;
	
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Calculation Price for ItemList"),
			@ApiResponse(code = 404,message = "Failed to Calculate Price."),
			@ApiResponse(code = 400,message = "Something Went Wrong due to Bad Request"),@ApiResponse(code = 500,message = "Internal Server Error")})
	@PostMapping("/inventory")
	public ResponseEntity<Double> validateInventory(@RequestBody List<OrderListDto> orderList) throws InventoryAppException{
		logger.info("-->validateInventory method hit successfully done");
		return new ResponseEntity<>(inventoryService.validateInventory(orderList),HttpStatus.OK);
	}

}

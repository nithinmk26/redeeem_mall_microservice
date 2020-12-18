/**
 * 
 */
package com.mindtree.order.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mindtree.order.dto.OrderListDto;
import com.mindtree.order.exception.InventoryAppException;

/**
 * @author M1056182
 *
 */
@FeignClient(value = "inventory-service")
public interface InventoryProxy {

	@PostMapping("/api/v1/inventoryservice/inventory")
	public ResponseEntity<Double> validateInventory(@RequestBody List<OrderListDto> orderList) throws InventoryAppException;
}

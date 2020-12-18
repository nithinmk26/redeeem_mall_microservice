/**
 * 
 */
package com.mindtree.inventory.service;

import java.util.List;

import com.mindtree.inventory.dto.OrderListDto;
import com.mindtree.inventory.exception.InventoryAppException;

/**
 * @author M1056182
 *
 */
public interface InventoryService {

	double validateInventory(List<OrderListDto> orderList) throws InventoryAppException;

}

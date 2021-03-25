/**
 * 
 */
package com.digital.inventory.service;

import java.util.List;

import com.digital.inventory.dto.OrderListDto;
import com.digital.inventory.exception.InventoryAppException;

/**
 * @author M1056182
 *
 */
public interface InventoryService {

	double validateInventory(List<OrderListDto> orderList) throws InventoryAppException;

}

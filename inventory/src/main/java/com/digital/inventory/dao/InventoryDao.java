/**
 * 
 */
package com.digital.inventory.dao;

import java.util.Optional;

import com.digital.inventory.entity.Inventory;

/**
 * @author M1056182
 *
 */
public interface InventoryDao {

	Optional<Inventory> findProductById(int productId);

	void updateQuantity(Optional<Inventory> inventory);

}

/**
 * 
 */
package com.mindtree.inventory.dao.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.inventory.dao.InventoryDao;
import com.mindtree.inventory.entity.Inventory;
import com.mindtree.inventory.repository.InventoryRepository;
import com.mindtree.inventory.service.impl.InventoryServiceImpl;

/**
 * @author M1056182
 *
 */
@Service
public class InventoryDaoImpl implements InventoryDao{
	
	private static final Logger logger = LoggerFactory.getLogger(InventoryDaoImpl.class);


	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Override
	public Optional<Inventory> findProductById(int productId) {
		logger.info("-->Fetching the product by product id from DB.");
		return inventoryRepository.findById(productId);
	}

	@Override
	public void updateQuantity(Optional<Inventory> inventory) {
		logger.info("Successfully updated the quanatity of products.");
		inventoryRepository.saveAndFlush(inventory.get());
		
	}

}

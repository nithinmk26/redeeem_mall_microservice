/**
 * 
 */
package com.mindtree.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.inventory.entity.Inventory;

/**
 * @author M1056182
 *
 */
@Repository
public interface InventoryRepository  extends JpaRepository<Inventory, Integer>{

}

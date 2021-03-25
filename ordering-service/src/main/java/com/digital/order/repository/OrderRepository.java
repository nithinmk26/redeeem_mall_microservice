/**
 * 
 */
package com.digital.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital.order.entity.OrderPlaced;

/**
 * @author M1056182
 *
 */
@Repository
public interface OrderRepository extends JpaRepository<OrderPlaced, Integer> {

}

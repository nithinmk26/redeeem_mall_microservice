/**
 * 
 */
package com.mindtree.order.dao;

import com.mindtree.order.entity.OrderPlaced;

/**
 * @author M1056182
 *
 */
public interface OrderDao {

	OrderPlaced processOrder(OrderPlaced order);

}

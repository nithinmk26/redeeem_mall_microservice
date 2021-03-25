/**
 * 
 */
package com.digital.order.dao;

import com.digital.order.entity.OrderPlaced;

/**
 * @author M1056182
 *
 */
public interface OrderDao {

	OrderPlaced processOrder(OrderPlaced order);

}

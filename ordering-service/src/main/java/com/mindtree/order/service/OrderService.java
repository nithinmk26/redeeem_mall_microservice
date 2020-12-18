/**
 * 
 */
package com.mindtree.order.service;

import java.util.List;

import com.mindtree.order.dto.OrderListDto;
import com.mindtree.order.entity.OrderPlaced;
import com.mindtree.order.exception.OrderAppException;

/**
 * @author M1056182
 *
 */
public interface OrderService {

	OrderPlaced processOrder(List<OrderListDto> orderListDtos, int customerId) throws OrderAppException;

}

/**
 * 
 */
package com.digital.order.service;

import java.util.List;

import com.digital.order.dto.OrderListDto;
import com.digital.order.entity.OrderPlaced;
import com.digital.order.exception.OrderAppException;

/**
 * @author M1056182
 *
 */
public interface OrderService {

	OrderPlaced processOrder(List<OrderListDto> orderListDtos, int customerId) throws OrderAppException;

}

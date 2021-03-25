/**
 * 
 */
package com.digital.order.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.order.dao.OrderDao;
import com.digital.order.entity.OrderPlaced;
import com.digital.order.repository.OrderRepository;

/**
 * @author M1056182
 *
 */
@Service
public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	private OrderRepository orderRepo;

	@Override
	public OrderPlaced processOrder(OrderPlaced order) {
		return orderRepo.save(order);
	}

}

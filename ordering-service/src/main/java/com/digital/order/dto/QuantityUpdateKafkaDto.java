/**
 * 
 */
package com.digital.order.dto;

import java.util.List;

/**
 * @author M1056182
 *
 */
public class QuantityUpdateKafkaDto {

	private List<OrderListDto> orderList;

	/**
	 * @return the orderList
	 */
	public List<OrderListDto> getOrderList() {
		return orderList;
	}

	/**
	 * @param orderList the orderList to set
	 */
	public void setOrderList(List<OrderListDto> orderList) {
		this.orderList = orderList;
	}

	/**
	 * @param orderList
	 */
	public QuantityUpdateKafkaDto(List<OrderListDto> orderList) {
		super();
		this.orderList = orderList;
	}

	/**
	 * 
	 */
	public QuantityUpdateKafkaDto() {
		super();
	}
	
	
	
}

/**
 * 
 */
package com.mindtree.order.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author M1056182
 *
 */
@Entity
public class OrderPlaced {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	private int orderValue;
	
	private LocalDate orderDate;
	
	private int customerId;
	
	private int totalQuantityOfProducts;

	/**
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the orderValue
	 */
	public int getOrderValue() {
		return orderValue;
	}

	/**
	 * @param orderValue the orderValue to set
	 */
	public void setOrderValue(int orderValue) {
		this.orderValue = orderValue;
	}

	/**
	 * @return the orderDate
	 */
	public LocalDate getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the totalQuantityOfProducts
	 */
	public int getTotalQuantityOfProducts() {
		return totalQuantityOfProducts;
	}

	/**
	 * @param totalQuantityOfProducts the totalQuantityOfProducts to set
	 */
	public void setTotalQuantityOfProducts(int totalQuantityOfProducts) {
		this.totalQuantityOfProducts = totalQuantityOfProducts;
	}

	/**
	 * @param orderId
	 * @param orderValue
	 * @param orderDate
	 * @param customerId
	 * @param totalQuantityOfProducts
	 */
	public OrderPlaced(int orderId, int orderValue, LocalDate orderDate, int customerId, int totalQuantityOfProducts) {
		super();
		this.orderId = orderId;
		this.orderValue = orderValue;
		this.orderDate = orderDate;
		this.customerId = customerId;
		this.totalQuantityOfProducts = totalQuantityOfProducts;
	}

	/**
	 * 
	 */
	public OrderPlaced() {
		super();
	}
	
	

}

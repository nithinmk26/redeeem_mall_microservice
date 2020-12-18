/**
 * 
 */
package com.mindtree.customer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author M1056182
 *
 */
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	
	private String name;
	
	private String address;
	
	private double loyaltyPoint;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the loyaltyPoint
	 */
	public double getLoyaltyPoint() {
		return loyaltyPoint;
	}

	/**
	 * @param loyaltyPoint the loyaltyPoint to set
	 */
	public void setLoyaltyPoint(double loyaltyPoint) {
		this.loyaltyPoint = loyaltyPoint;
	}

	/**
	 * @param customerId
	 * @param name
	 * @param address
	 * @param loyaltyPoint
	 */
	public Customer(int customerId, String name, String address, double loyaltyPoint) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.address = address;
		this.loyaltyPoint = loyaltyPoint;
	}

	/**
	 * 
	 */
	public Customer() {
		super();
	}
	
	
	
}

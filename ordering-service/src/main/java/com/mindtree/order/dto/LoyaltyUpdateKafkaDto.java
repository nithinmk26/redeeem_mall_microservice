/**
 * 
 */
package com.mindtree.order.dto;

/**
 * @author M1056182
 *
 */
public class LoyaltyUpdateKafkaDto {
	
	private int customerId;
	
	private double totalProductValue;

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
	 * @return the totalProductValue
	 */
	public double getTotalProductValue() {
		return totalProductValue;
	}

	/**
	 * @param totalProductValue the totalProductValue to set
	 */
	public void setTotalProductValue(double totalProductValue) {
		this.totalProductValue = totalProductValue;
	}

	/**
	 * @param customerId
	 * @param totalProductValue
	 */
	public LoyaltyUpdateKafkaDto(int customerId, double totalProductValue) {
		super();
		this.customerId = customerId;
		this.totalProductValue = totalProductValue;
	}

	/**
	 * 
	 */
	public LoyaltyUpdateKafkaDto() {
		super();
	}	
	

}

/**
 * 
 */
package com.mindtree.inventory.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author M1056182
 *
 */
@Entity
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	
	private String productName;
	
	private int productQuantity;
	
	private double priceInPoints;
	
	private String description;

	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the productQuantity
	 */
	public int getProductQuantity() {
		return productQuantity;
	}

	/**
	 * @param productQuantity the productQuantity to set
	 */
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	/**
	 * @return the priceInPoints
	 */
	public double getPriceInPoints() {
		return priceInPoints;
	}

	/**
	 * @param priceInPoints the priceInPoints to set
	 */
	public void setPriceInPoints(double priceInPoints) {
		this.priceInPoints = priceInPoints;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param productId
	 * @param productName
	 * @param productQuantity
	 * @param priceInPoints
	 * @param description
	 */
	public Inventory(int productId, String productName, int productQuantity, double priceInPoints, String description) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.priceInPoints = priceInPoints;
		this.description = description;
	}

	/**
	 * 
	 */
	public Inventory() {
		super();
	}
	
	
	
	
	
}

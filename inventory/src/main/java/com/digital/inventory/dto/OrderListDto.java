/**
 * 
 */
package com.digital.inventory.dto;

/**
 * @author M1056182
 *
 */
public class OrderListDto {
	
private int productId;
	
	private int quantity;
	
	private int productPriceInPoints;

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
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the productPriceInPoints
	 */
	public int getProductPriceInPoints() {
		return productPriceInPoints;
	}

	/**
	 * @param productPriceInPoints the productPriceInPoints to set
	 */
	public void setProductPriceInPoints(int productPriceInPoints) {
		this.productPriceInPoints = productPriceInPoints;
	}

	/**
	 * @param productId
	 * @param quantity
	 * @param productPriceInPoints
	 */
	public OrderListDto(int productId, int quantity, int productPriceInPoints) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.productPriceInPoints = productPriceInPoints;
	}

	/**
	 * 
	 */
	public OrderListDto() {
		super();
	}

	
}

/**
 * 
 */
package com.digital.inventory.exception;

/**
 * @author M1056182
 *
 */
public class ProductQuantityExceededException extends InventoryAppException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8721914333336075721L;


	/**
	 * 
	 */
	public ProductQuantityExceededException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ProductQuantityExceededException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ProductQuantityExceededException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public ProductQuantityExceededException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ProductQuantityExceededException(Throwable cause) {
		super(cause);
	}
	
	

}

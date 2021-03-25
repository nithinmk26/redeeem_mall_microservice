/**
 * 
 */
package com.digital.inventory.exception;

/**
 * @author M1056182
 *
 */
public class InventoryAppException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7614297166965994300L;

	/**
	 * 
	 */
	public InventoryAppException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public InventoryAppException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InventoryAppException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public InventoryAppException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public InventoryAppException(Throwable cause) {
		super(cause);
	}
	
	

}

/**
 * 
 */
package com.digital.customer.exception;

/**
 * @author M1056182
 *
 */

public class CustomerAppException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public CustomerAppException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public CustomerAppException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public CustomerAppException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public CustomerAppException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public CustomerAppException(Throwable cause) {
		super(cause);
	}
	
	
	
	

}

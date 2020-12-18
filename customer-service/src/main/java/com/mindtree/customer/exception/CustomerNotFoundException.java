/**
 * 
 */
package com.mindtree.customer.exception;

/**
 * @author M1056182
 *
 */
public class CustomerNotFoundException extends CustomerAppException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7123505020541808681L;

	/**
	 * 
	 */
	public CustomerNotFoundException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public CustomerNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public CustomerNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public CustomerNotFoundException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public CustomerNotFoundException(Throwable cause) {
		super(cause);
	}

	
}

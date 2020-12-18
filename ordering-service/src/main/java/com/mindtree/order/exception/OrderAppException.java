/**
 * 
 */
package com.mindtree.order.exception;

/**
 * @author M1056182
 *
 */
public class OrderAppException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2244403313212848703L;

	/**
	 * 
	 */
	public OrderAppException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public OrderAppException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public OrderAppException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public OrderAppException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public OrderAppException(Throwable cause) {
		super(cause);
	}
	
	

}

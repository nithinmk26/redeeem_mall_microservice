/**
 * 
 */
package com.digital.order.exception;

/**
 * @author M1056182
 *
 */
public class ItemsExceededException extends OrderAppException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5146663823898507070L;

	/**
	 * 
	 */
	public ItemsExceededException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ItemsExceededException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ItemsExceededException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public ItemsExceededException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ItemsExceededException(Throwable cause) {
		super(cause);
	}
	
	

}

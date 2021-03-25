/**
 * 
 */
package com.digital.order.exception;

/**
 * @author M1056182
 *
 */
public class NoSufficientLoyaltyPointsToPurchaseException extends OrderAppException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5530323513829009215L;

	/**
	 * 
	 */
	public NoSufficientLoyaltyPointsToPurchaseException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public NoSufficientLoyaltyPointsToPurchaseException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NoSufficientLoyaltyPointsToPurchaseException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public NoSufficientLoyaltyPointsToPurchaseException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public NoSufficientLoyaltyPointsToPurchaseException(Throwable cause) {
		super(cause);
	}
	
	

}

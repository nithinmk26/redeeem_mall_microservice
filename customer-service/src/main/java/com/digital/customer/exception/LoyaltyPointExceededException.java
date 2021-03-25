/**
 * 
 */
package com.digital.customer.exception;

/**
 * @author M1056182
 *
 */
public class LoyaltyPointExceededException extends CustomerAppException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2162544987616050276L;

	/**
	 * 
	 */
	public LoyaltyPointExceededException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public LoyaltyPointExceededException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public LoyaltyPointExceededException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public LoyaltyPointExceededException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public LoyaltyPointExceededException(Throwable cause) {
		super(cause);
	}
	
	

}

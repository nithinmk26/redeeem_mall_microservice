/**
 * 
 */
package com.digital.order.exception;

import java.util.List;

/**
 * @author M1056182
 *
 */
public class QuantityExceededPerOrder extends OrderAppException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2248049695777810550L;

	/**
	 * 
	 */
	public QuantityExceededPerOrder() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public QuantityExceededPerOrder(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public QuantityExceededPerOrder(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public QuantityExceededPerOrder(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public QuantityExceededPerOrder(Throwable cause) {
		super(cause);
	}


	
}

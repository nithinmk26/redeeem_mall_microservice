/**
 * 
 */
package com.digital.order.exception;

/**
 * @author M1056182
 *
 */
public class OrderAppProxyException extends OrderAppException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2909534395056673720L;

	/**
	 * 
	 */
	public OrderAppProxyException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public OrderAppProxyException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public OrderAppProxyException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public OrderAppProxyException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public OrderAppProxyException(Throwable cause) {
		super(cause);
	}
	
	

}

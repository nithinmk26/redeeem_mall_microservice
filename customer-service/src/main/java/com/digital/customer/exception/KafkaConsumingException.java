/**
 * 
 */
package com.digital.customer.exception;

/**
 * @author M1056182
 *
 */
public class KafkaConsumingException extends CustomerAppException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3758436032852671822L;

	/**
	 * 
	 */
	public KafkaConsumingException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public KafkaConsumingException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public KafkaConsumingException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public KafkaConsumingException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public KafkaConsumingException(Throwable cause) {
		super(cause);
	}
	
	

}

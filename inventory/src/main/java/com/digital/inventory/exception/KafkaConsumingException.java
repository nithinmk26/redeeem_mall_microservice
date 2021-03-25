/**
 * 
 */
package com.digital.inventory.exception;

/**
 * @author M1056182
 *
 */
public class KafkaConsumingException extends InventoryAppException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1166708163906448180L;

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

package com.lucas.sandgrain.idgenerator.domain.model.time;

public class TimestampRetrievalException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TimestampRetrievalException(String msg) {
		super(msg);
	}
	
	public TimestampRetrievalException(String msg,Throwable t) {
		super(msg,t);
	}
	
}

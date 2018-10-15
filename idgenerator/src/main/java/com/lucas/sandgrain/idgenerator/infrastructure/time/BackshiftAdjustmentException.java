package com.lucas.sandgrain.idgenerator.infrastructure.time;

import com.lucas.sandgrain.idgenerator.domain.model.time.TimestampRetrievalException;

public class BackshiftAdjustmentException extends TimestampRetrievalException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BackshiftAdjustmentException(String msg) {
		super(msg);
	}
	
	public BackshiftAdjustmentException(String msg,Throwable t) {
		super(msg,t);
	}

}

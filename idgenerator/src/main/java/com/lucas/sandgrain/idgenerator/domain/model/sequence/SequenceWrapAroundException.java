package com.lucas.sandgrain.idgenerator.domain.model.sequence;

public class SequenceWrapAroundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SequenceWrapAroundException(String msg) {
		super(msg);
	}
	
	public SequenceWrapAroundException(String msg,Throwable t) {
		super(msg,t);
	}
	
}

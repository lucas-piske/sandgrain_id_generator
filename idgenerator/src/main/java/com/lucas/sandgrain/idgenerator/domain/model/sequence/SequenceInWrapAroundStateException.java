package com.lucas.sandgrain.idgenerator.domain.model.sequence;

public class SequenceInWrapAroundStateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SequenceInWrapAroundStateException(String msg) {
		super(msg);
	}
	
	public SequenceInWrapAroundStateException(String msg,Throwable t) {
		super(msg,t);
	}
	
}

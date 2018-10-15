package com.lucas.sandgrain.idgenerator.domain.model.instance;

public class NoInstanceNamespaceAvailableException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoInstanceNamespaceAvailableException(String msg) {
		super(msg);
	}
	
	public NoInstanceNamespaceAvailableException(String msg, Throwable t) {
		super(msg,t);
	}
	
}

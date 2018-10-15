package com.lucas.sandgrain.idgenerator.domain.model.instance;

import java.util.Set;

public final class SingleInstanceNamespaceAccessor implements InstanceNamespaceAccessor {

	private final InstanceNamespace singleInstance;
	
	public SingleInstanceNamespaceAccessor(InstanceNamespace singleInstance) {
		this.singleInstance = singleInstance;
	}
	
	public InstanceNamespace get() throws NoInstanceNamespaceAvailableException {
		return singleInstance;
	}

	public InstanceNamespace get(Set<InstanceNamespace> exceptFor) throws NoInstanceNamespaceAvailableException {
		if(!exceptFor.contains(singleInstance)) {
			return singleInstance;
		} else {
			throw new NoInstanceNamespaceAvailableException("No other instance is available");
		}
	}

}

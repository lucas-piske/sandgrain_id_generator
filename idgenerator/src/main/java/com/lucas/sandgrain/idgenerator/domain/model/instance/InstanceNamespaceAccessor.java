package com.lucas.sandgrain.idgenerator.domain.model.instance;

import java.util.Set;

public interface InstanceNamespaceAccessor {
	public InstanceNamespace get() throws NoInstanceNamespaceAvailableException;
	public InstanceNamespace get(Set<InstanceNamespace> exceptFor) throws NoInstanceNamespaceAvailableException;
}

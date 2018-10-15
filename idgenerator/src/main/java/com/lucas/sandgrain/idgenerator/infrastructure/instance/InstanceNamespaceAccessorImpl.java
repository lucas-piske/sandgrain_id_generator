package com.lucas.sandgrain.idgenerator.infrastructure.instance;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.lucas.sandgrain.idgenerator.domain.model.instance.InstanceNamespace;
import com.lucas.sandgrain.idgenerator.domain.model.instance.InstanceNamespaceAccessor;
import com.lucas.sandgrain.idgenerator.domain.model.instance.NoInstanceNamespaceAvailableException;
import com.lucas.sandgrain.namespacecontainer.api.namespace.InstanceNamespaceContainerService;

public final class InstanceNamespaceAccessorImpl implements InstanceNamespaceAccessor {

	private final Set<Integer> noNamespaceException = new HashSet<>();
	
	private final InstanceNamespaceContainerService containerService;
	
	public InstanceNamespaceAccessorImpl(
			InstanceNamespaceContainerService containerService) {
		this.containerService = containerService;
	}
	
	public InstanceNamespace get() throws NoInstanceNamespaceAvailableException {
		Optional<Integer> namespace = containerService
				.getNamespaceWithNewestPing(noNamespaceException);
		
		if(namespace.isPresent()) {
			return new InstanceNamespace(namespace.get());
		} else {
			throw new NoInstanceNamespaceAvailableException("No instance "
					+ "namespace is available for usage");
		}
	}

	public InstanceNamespace get(Set<InstanceNamespace> exceptFor) throws NoInstanceNamespaceAvailableException {
		Set<Integer> intExceptFor = 
				exceptFor
				.stream()
				.map(efn -> efn.getId())
				.collect(Collectors.toSet());
		
		Optional<Integer> namespace = containerService
				.getNamespaceWithNewestPing(intExceptFor);
		
		if(namespace.isPresent()) {
			return new InstanceNamespace(namespace.get());
		} else {
			throw new NoInstanceNamespaceAvailableException("No instance "
					+ "namespace is available for usage");
		}
	}

}

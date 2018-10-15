package com.lucas.sandgrain.idgenerator.domain.model.instance;

public class InstanceNamespace {

	private final int id;
	
	public InstanceNamespace(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	@Override
	public int hashCode() {
		return Long.hashCode(id);
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof InstanceNamespace) {
			return this.id == ((InstanceNamespace)o).id;
		}
		return false;
	}
	
}

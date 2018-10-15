package com.lucas.sandgrain.idgenerator.domain.model.instance;

public class DataCenterNamespace {
	
	private long id;
	
	public DataCenterNamespace(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
	
	@Override
	public int hashCode() {
		return Long.hashCode(id);
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof DataCenterNamespace) {
			return this.id == ((DataCenterNamespace)o).id;
		}
		return false;
	}
	
}

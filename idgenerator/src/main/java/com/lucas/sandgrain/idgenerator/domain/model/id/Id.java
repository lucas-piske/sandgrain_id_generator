package com.lucas.sandgrain.idgenerator.domain.model.id;

import com.lucas.sandgrain.idgenerator.domain.model.instance.DataCenterNamespace;
import com.lucas.sandgrain.idgenerator.domain.model.instance.InstanceNamespace;

public class Id {

	private final long id;
	
	public Id(long ts,DataCenterNamespace dc,InstanceNamespace inst,long currSeqValue) {
		long tmpId = ((~((long) 0)) >> 23) & ts;
		tmpId = (dc.getId() << 41) | tmpId;
		
		tmpId = (~((long) 0) >> 18) & tmpId;
		tmpId = (inst.getId() << 46) | tmpId;
		
		tmpId = (~((long) 0) >> 13) & tmpId;
		tmpId = (currSeqValue << 51) | tmpId;
		
		tmpId = (~((long) 0) >> 1) & tmpId;
		
		id = tmpId;
	}
	
	public long toLong() {
		return id;
	}
	
}

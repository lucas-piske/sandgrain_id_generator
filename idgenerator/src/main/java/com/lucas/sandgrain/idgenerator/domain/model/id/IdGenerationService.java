package com.lucas.sandgrain.idgenerator.domain.model.id;

import java.util.HashSet;
import java.util.Set;

import com.lucas.sandgrain.idgenerator.domain.model.instance.DataCenterNamespace;
import com.lucas.sandgrain.idgenerator.domain.model.instance.InstanceNamespace;
import com.lucas.sandgrain.idgenerator.domain.model.instance.InstanceNamespaceAccessor;
import com.lucas.sandgrain.idgenerator.domain.model.instance.NoInstanceNamespaceAvailableException;
import com.lucas.sandgrain.idgenerator.domain.model.sequence.Sequence;
import com.lucas.sandgrain.idgenerator.domain.model.sequence.SequenceAccessor;
import com.lucas.sandgrain.idgenerator.domain.model.sequence.SequenceWrapAroundException;
import com.lucas.sandgrain.idgenerator.domain.model.time.TimestampRetrievalException;
import com.lucas.sandgrain.idgenerator.domain.model.time.TimestampRetriever;

public final class IdGenerationService {

	private final SequenceAccessor sequenceAccessor;
	private final TimestampRetriever timestampRetriever;
	private final InstanceNamespaceAccessor instanceAccessor;
	private final DataCenterNamespace dataCenter;
	
	public IdGenerationService(
			SequenceAccessor sequenceAccessor,
			TimestampRetriever timestampRetriever,
			InstanceNamespaceAccessor instanceAccessor,
			DataCenterNamespace dataCenter) {
		this.sequenceAccessor = sequenceAccessor;
		this.timestampRetriever = timestampRetriever;
		this.instanceAccessor = instanceAccessor;
		this.dataCenter = dataCenter;
	}

	public Id generate() throws TimestampRetrievalException, NoInstanceNamespaceAvailableException {
		long currTimeInMillis = timestampRetriever.retrieve();
		
		Set<InstanceNamespace> wrappedAroundInstances = new HashSet<InstanceNamespace>();
		
		while(true) {
			InstanceNamespace instance = instanceAccessor.get(wrappedAroundInstances);
			
			Sequence seq = sequenceAccessor.get(currTimeInMillis, instance);
			try {
				long currSeqVal = seq.next();
				//return Long.toString(currTimeInMillis) + ":" + Long.toString(dataCenter.getId()) + ":" + Long.toString(instance.getId()) + ":" + Long.toString(currSeqVal);
				return new Id(currTimeInMillis,dataCenter,instance,currSeqVal);
			} catch (SequenceWrapAroundException e) {
				wrappedAroundInstances.add(instance);
			}
		}
	}
	
}

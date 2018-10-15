package com.lucas.sandgrain.idgenerator.domain.model.sequence;

import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.tuple.Pair;

import com.lucas.sandgrain.idgenerator.domain.model.instance.InstanceNamespace;

public class SequenceRegistry implements SequenceAccessor {

	private final SequenceFactory sequenceFactory;
	
	private final ConcurrentHashMap<InstanceNamespace,Pair<Long,Sequence>> seqMap =
			new ConcurrentHashMap<InstanceNamespace,Pair<Long,Sequence>>();
	
	public SequenceRegistry(
			SequenceFactory sequenceFactory) {
		this.sequenceFactory = sequenceFactory;
	}
	
	public synchronized Sequence get(long timeInMillis,InstanceNamespace instance) {
		Pair<Long,Sequence> seqEntry = seqMap.get(instance);
		if(seqEntry == null || (seqEntry != null && seqEntry.getLeft() != timeInMillis)) {
			seqMap.put(instance,Pair.of(
					timeInMillis,
					sequenceFactory.get()));
			return seqMap.get(instance).getRight();
		} else {
			return seqEntry.getRight();
		}
	}
	
}

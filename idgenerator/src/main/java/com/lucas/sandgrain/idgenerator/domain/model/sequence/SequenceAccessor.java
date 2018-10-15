package com.lucas.sandgrain.idgenerator.domain.model.sequence;

import com.lucas.sandgrain.idgenerator.domain.model.instance.InstanceNamespace;

public interface SequenceAccessor {
	public Sequence get(long timeInMillis,InstanceNamespace instance);
}

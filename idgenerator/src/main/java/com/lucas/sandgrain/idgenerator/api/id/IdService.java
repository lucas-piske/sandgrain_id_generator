package com.lucas.sandgrain.idgenerator.api.id;

import com.lucas.sandgrain.idgenerator.domain.model.instance.NoInstanceNamespaceAvailableException;
import com.lucas.sandgrain.idgenerator.domain.model.time.TimestampRetrievalException;

public interface IdService {
	public long generateId() throws TimestampRetrievalException, NoInstanceNamespaceAvailableException;
}

package com.lucas.sandgrain.idgenerator.api.id;

import com.lucas.sandgrain.idgenerator.domain.model.id.IdGenerationService;
import com.lucas.sandgrain.idgenerator.domain.model.instance.NoInstanceNamespaceAvailableException;
import com.lucas.sandgrain.idgenerator.domain.model.time.TimestampRetrievalException;

public final class IdServiceImpl implements IdService {

	private final IdGenerationService idGenerationService;
	
	public IdServiceImpl(IdGenerationService idGenerationService) {
		this.idGenerationService = idGenerationService;
	}
	
	public long generateId() throws TimestampRetrievalException, NoInstanceNamespaceAvailableException {
		return idGenerationService.generate().toLong();
	}

}

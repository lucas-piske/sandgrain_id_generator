package com.lucas.sandgrain.idgenerator.domain.model.time;

public interface TimestampRetriever {
	public long retrieve() throws TimestampRetrievalException;
}

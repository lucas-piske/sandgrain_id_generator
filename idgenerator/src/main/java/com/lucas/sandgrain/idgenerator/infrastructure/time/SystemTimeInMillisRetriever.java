package com.lucas.sandgrain.idgenerator.infrastructure.time;

public final class SystemTimeInMillisRetriever implements TimeInMillisRetriever {

	public long retrieve() {
		return System.currentTimeMillis();
	}

}

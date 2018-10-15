package com.lucas.sandgrain.idgenerator.infrastructure.time;

public interface BackShiftDealingStrategy {
	public long adjustCurrentTime(long currentTimeInMillis);
}

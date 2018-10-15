package com.lucas.sandgrain.idgenerator.infrastructure.time;

public final class BackShiftWaitStrategy implements BackShiftDealingStrategy {

	private long lastTimeInMillisRetrieved;
	
	public BackShiftWaitStrategy(
			TimeInMillisRetriever timeInMillisRetriever) {
		this.lastTimeInMillisRetrieved = timeInMillisRetriever.retrieve();
	}

	public long adjustCurrentTime(long currTimeInMillis) {
		long timeDelta = currTimeInMillis - lastTimeInMillisRetrieved;
		if(backShiftHappened(timeDelta)) {
			//SHOULD LOG THAT THE BACKSHIFT STRATEGY IS BEING APPLIED. 
			return lastTimeInMillisRetrieved;
		}
		return currTimeInMillis;
	}
	
	private boolean backShiftHappened(long timeDelta) {
		return timeDelta < 0;
	}

}

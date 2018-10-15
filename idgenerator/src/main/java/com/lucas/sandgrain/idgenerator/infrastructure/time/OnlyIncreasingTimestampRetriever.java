package com.lucas.sandgrain.idgenerator.infrastructure.time;

import com.lucas.sandgrain.idgenerator.domain.model.time.TimestampRetrievalException;
import com.lucas.sandgrain.idgenerator.domain.model.time.TimestampRetriever;

public final class OnlyIncreasingTimestampRetriever implements TimestampRetriever {

	private final TimeInMillisRetriever timeInMillisRetriever;
	private final BackShiftDealingStrategy backShiftDealingStrategy;
	
	public OnlyIncreasingTimestampRetriever(
			TimeInMillisRetriever timeInMillisRetriever,
			BackShiftDealingStrategy backShiftDealingStrategy) {
		this.timeInMillisRetriever =timeInMillisRetriever;
		this.backShiftDealingStrategy = backShiftDealingStrategy;
	}
	
	public long retrieve() throws TimestampRetrievalException {
		long currTimeInMillis = -1;
		try {
			currTimeInMillis = timeInMillisRetriever.retrieve();
		} catch (Exception e) {
			throw new TimestampRetrievalException("It was not possible to "
					+ "retrieve the current time in millis");
		}
		return backShiftDealingStrategy.adjustCurrentTime(currTimeInMillis);
	}

}

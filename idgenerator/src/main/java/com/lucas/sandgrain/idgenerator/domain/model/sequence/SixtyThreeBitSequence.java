package com.lucas.sandgrain.idgenerator.domain.model.sequence;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SixtyThreeBitSequence implements Sequence {
	
	private long currValue;
	private boolean isInWrappedAroundState;
	
	private final ReentrantReadWriteLock readWriteLock = 
			new ReentrantReadWriteLock();
	
	public SixtyThreeBitSequence() {
		this.currValue = 0;
		this.isInWrappedAroundState = false;
	}
	
	public long current() throws SequenceInWrapAroundStateException {
		readWriteLock.readLock().lock();
		try {
			if(isInWrappedAroundState) {
				throw new SequenceInWrapAroundStateException("The sequence has current wrapped around value");
			}
			return currValue;
		} finally {
			readWriteLock.readLock().unlock();
		}
	}
	
	public long next() throws SequenceWrapAroundException {
		readWriteLock.writeLock().lock();
		try {
			if(!isInWrappedAroundState) {
				long currValue = this.currValue++;
				if(currValue >= 0) {
					return currValue;
				} else {
					isInWrappedAroundState = true;
					throw new SequenceWrapAroundException("The sequence has current wrapped around value");
				}
			} else {
				throw new SequenceWrapAroundException("The sequence has current wrapped around value");
			}
		} finally {
			readWriteLock.writeLock().unlock();
		}	
	}
	
	public void restart() {
		readWriteLock.writeLock().lock();
		try {
			currValue = 0;
			isInWrappedAroundState = false;
		} finally {
			readWriteLock.writeLock().unlock();
		}
	}
	
}

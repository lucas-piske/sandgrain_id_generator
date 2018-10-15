package com.lucas.sandgrain.idgenerator.domain.model.sequence;

public interface Sequence {
	public long current() throws SequenceInWrapAroundStateException;
	public long next() throws SequenceWrapAroundException;
	public void restart();
}

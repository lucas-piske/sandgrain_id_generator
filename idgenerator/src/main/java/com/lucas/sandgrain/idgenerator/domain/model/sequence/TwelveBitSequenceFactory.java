package com.lucas.sandgrain.idgenerator.domain.model.sequence;

public final class TwelveBitSequenceFactory implements SequenceFactory {

	public Sequence get() {
		return new TwelveBitSequence();
	}

}

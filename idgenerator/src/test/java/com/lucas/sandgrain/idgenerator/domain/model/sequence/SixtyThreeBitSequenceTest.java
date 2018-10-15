package com.lucas.sandgrain.idgenerator.domain.model.sequence;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.lucas.sandgrain.idgenerator.domain.model.sequence.SequenceInWrapAroundStateException;
import com.lucas.sandgrain.idgenerator.domain.model.sequence.SequenceWrapAroundException;
import com.lucas.sandgrain.idgenerator.domain.model.sequence.SixtyThreeBitSequence;

public class SixtyThreeBitSequenceTest {

	@Test
	public void shouldStartWithValueZero() throws SequenceInWrapAroundStateException {
		SixtyThreeBitSequence seq = new SixtyThreeBitSequence();
		assertEquals(seq.current(),0);
	}
	
	@Test
	public void shouldGenerateIncreasingNumbersByOne() throws SequenceWrapAroundException {
		SixtyThreeBitSequence seq = new SixtyThreeBitSequence();
		assertEquals(seq.next(),0);
		assertEquals(seq.next(),1);
		assertEquals(seq.next(),2);
		assertEquals(seq.next(),3);
		assertEquals(seq.next(),4);
	}
	
	@Test
	public void shouldGoBackToZero_whenRestarted() throws SequenceWrapAroundException, SequenceInWrapAroundStateException {
		SixtyThreeBitSequence seq = new SixtyThreeBitSequence();
		seq.next();
		seq.restart();
		
		assertEquals(seq.current(),0);
	}
	
}

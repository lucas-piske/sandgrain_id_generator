package com.lucas.sandgrain.idgenerator.domain.model.sequence;

import java.util.concurrent.atomic.AtomicLong;

import org.junit.Test;

public class AtomicLongOverflowTest {

	@Test
	public void testOverflow() {
		AtomicLong al = new AtomicLong(Long.MAX_VALUE);
		long a = al.getAndIncrement();
		long b = al.getAndIncrement();
		System.out.println(a);
		System.out.println(b);
	}
	
}

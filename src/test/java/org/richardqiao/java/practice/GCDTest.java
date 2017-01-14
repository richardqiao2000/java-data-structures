package org.richardqiao.java.practice;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GCDTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGcd() {
		assertEquals(GCD.gcd(2, 4), 2);
		assertEquals(GCD.gcd(12, 18), 6);
	}

}

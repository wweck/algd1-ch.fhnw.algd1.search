/*
 * Created on 10.03.2022
 */
package ch.fhnw.algd1.search.sqrt;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Wolfgang Weck
 */
public class SqrtBisectionTest {
	private void checkWithTolerance(double value) {
		double expected = Math.sqrt(value);
		assertEquals(expected, SqrtBisection.squareRoot(value), expected / (1L << 52));
	}

	@Test
	public void test0() {
		assertEquals(0.0, SqrtBisection.squareRoot(0.0), 0);
	}

	@Test
	public void test1() {
		assertEquals(1.0, SqrtBisection.squareRoot(1.0), 0);
	}

	@Test
	public void test4() {
		assertEquals(2.0, SqrtBisection.squareRoot(4.0), 0);
	}

	@Test
	public void test256() {
		assertEquals(16.0, SqrtBisection.squareRoot(256.0), 0);
	}

	@Test
	public void test0_25() {
		assertEquals(0.5, SqrtBisection.squareRoot(0.25), 0);
	}

	@Test
	public void test0_00390625() {
		assertEquals(0.0625, SqrtBisection.squareRoot(0.00390625), 0);
	}

	@Test
	public void test9() {
		assertEquals(3, SqrtBisection.squareRoot(9), 0);
	}

	@Test
	public void test2() {
		checkWithTolerance(2);
	}

	@Test
	public void testPi() {
		checkWithTolerance(Math.PI);
	}

	@Test
	public void test500() {
		checkWithTolerance(500);
	}

	@Test
	public void testMaxVal() {
		assertEquals(Math.sqrt(Double.MAX_VALUE), SqrtBisection.squareRoot(Double.MAX_VALUE), 0);
	}
}

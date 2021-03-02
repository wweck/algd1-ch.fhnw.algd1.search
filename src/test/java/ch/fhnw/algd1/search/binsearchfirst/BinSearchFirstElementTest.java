package ch.fhnw.algd1.search.binsearchfirst;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class BinSearchFirstElementTest {
	@Test
	public void findFirstElement() {
		int[] numbers = new int[] { 1, 2, 3, 3, 3, 3, 3, 4, 5 };
		int index = BinSearchFirstElement.binSearch(numbers, 3);
		assertEquals(2, index);
	}

	@Test
	public void findFirstElementFirstHalf() {
		int[] numbers = new int[] { 1, 2, 2, 3, 3, 3, 3, 3, 4, 5 };
		int index = BinSearchFirstElement.binSearch(numbers, 2);
		assertEquals(1, index);
	}

	@Test
	public void findFirstElementSecondHalf() {
		int[] numbers = new int[] { 1, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 5 };
		int index = BinSearchFirstElement.binSearch(numbers, 4);
		assertEquals(8, index);
	}

	@Test
	public void testAllElementsEqual() {
		int[] numbers = new int[] { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 };
		int index = BinSearchFirstElement.binSearch(numbers, 3);
		assertEquals(0, index);
	}

	@Test
	public void testNoFirstElement() {
		int[] numbers = new int[] { 1, 2, 3, 3, 3, 3, 3, 8, 9 };
		int index = BinSearchFirstElement.binSearch(numbers, 5);
		assertEquals(7, index);
	}

	@Test
	public void testTooSmallElement() {
		int[] numbers = new int[] { 1, 2, 3, 3, 3, 3, 3, 8, 9 };
		int index = BinSearchFirstElement.binSearch(numbers, 0);
		assertEquals(0, index);
	}

	@Test
	public void testTooLargeElement() {
		int[] numbers = new int[] { 1, 2, 3, 3, 3, 3, 3, 8, 9 };
		int index = BinSearchFirstElement.binSearch(numbers, 11);
		assertEquals(9, index);
	}

	@Test
	public void testExistingIntegerAtStart() {
		int[] elements = new int[] { 1, 3, 4, 5, 9 };
		int index = BinSearchFirstElement.binSearch(elements, 1);
		assertEquals(0, index);
	}

	@Test
	public void testExistingIntegerInBetween1() {
		int[] elements = new int[] { 1, 3, 4, 5, 9 };
		int index = BinSearchFirstElement.binSearch(elements, 3);
		assertEquals(1, index);
	}

	@Test
	public void testExistingIntegerInBetween2() {
		int[] elements = new int[] { 1, 3, 4, 5, 9 };
		int index = BinSearchFirstElement.binSearch(elements, 4);
		assertEquals(2, index);
	}

	@Test
	public void testExistingIntegerInBetween3() {
		int[] elements = new int[] { 1, 3, 4, 5, 9 };
		int index = BinSearchFirstElement.binSearch(elements, 5);
		assertEquals(3, index);
	}

	@Test
	public void testExistingIntegerAtEnd() {
		int[] elements = new int[] { 1, 3, 4, 5, 9 };
		int index = BinSearchFirstElement.binSearch(elements, 9);
		assertEquals(4, index);
	}

	@Test
	public void testNonExistingInteger() {
		int[] elements = new int[] { 1, 3, 4, 5, 9 };
		int index = BinSearchFirstElement.binSearch(elements, 7);
		assertEquals(4, index);
	}

	@Test
	public void testTooSmallInteger() {
		int[] elements = new int[] { 1, 3, 4, 5, 9 };
		int index = BinSearchFirstElement.binSearch(elements, 0);
		assertEquals(0, index);
	}

	@Test
	public void testTooLargeInteger() {
		int[] elements = new int[] { 1, 3, 4, 5, 9 };
		int index = BinSearchFirstElement.binSearch(elements, 11);
		assertEquals(elements.length, index);
	}

	@Test
	public void testEqualInteger() {
		int[] elements = new int[] { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 };
		int index = BinSearchFirstElement.binSearch(elements, 6);
		assertEquals(elements.length, index);
	}

	private static final int VAL = 42;

	private static int timeOf(int arraySize, long duration, int key) {
		int[] elements = new int[arraySize];
		Arrays.fill(elements, VAL);
		final int expectedRes = key <= VAL ? 0 : arraySize;
		final long t = System.nanoTime() + duration;
		int cnt = 0;
		while (System.nanoTime() < t) {
			cnt++;
			assertEquals(expectedRes, BinSearchFirstElement.binSearch(elements, key));
		}
		return cnt;
	}

	@Test
	public void testSlowDownFirst() {
		final int N = 10_000_000, DUR = 250_000_000;
		timeOf(N, DUR, VAL);
		int n1 = timeOf(N, DUR, VAL), n2 = timeOf(2 * N, DUR, VAL);
		assertTrue("Laufzeit wächst zu schnell an. Sequnezielle Suche verwendet?", 3 * n2 > 2 * n1);
	}

	@Test
	public void testSlowDownLast() {
		final int N = 10_000_000, DUR = 250_000_000;
		timeOf(N, DUR, VAL + 1);
		int n1 = timeOf(N, DUR, VAL + 1), n2 = timeOf(2 * N, DUR, VAL + 1);
		assertTrue("Laufzeit wächst zu schnell an. Sequnezielle Suche verwendet?", 3 * n2 > 2 * n1);
	}
}

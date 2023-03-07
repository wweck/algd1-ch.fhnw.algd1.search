package ch.fhnw.algd1.search.sentinelsearch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class SentinelTestFirstElement {
	@Test
	public void testNumberAtStart() {
		int[] numbers = { 5, 2, 44, 534, 22 };
		assertExistenceAndArrayEquality(numbers, 5, 0);
	}

	private void assertExistenceAndArrayEquality(int[] numbers, int value, int index) {
		int[] copy = Arrays.copyOf(numbers, numbers.length);
		assertEquals(index, SentinelSearch.firstIndex(numbers, value));
		assertTrue("Array elements have changed", Arrays.equals(numbers, copy));
	}

	@Test
	public void testNumberInBetween() {
		int[] numbers = { 5, 2, 44, 534, 22 };
		assertExistenceAndArrayEquality(numbers, 44, 2);
	}

	@Test
	public void testNumberAtEnd() {
		int[] numbers = { 5, 2, 44, 534, 22 };
		assertExistenceAndArrayEquality(numbers, 22, 4);
	}

	@Test
	public void testNonExistingNumber() {
		int[] numbers = { 5, 2, 44, 534, 22 };
		int[] copy = Arrays.copyOf(numbers, numbers.length);
		assertEquals(-1, SentinelSearch.firstIndex(numbers, 30));
		assertTrue("Array elements have changed", Arrays.equals(numbers, copy));
	}

	@Test
	public void findFirstElementTest() {
		int[] numbers = { 5, 2, 44, 534, 22, 44 };
		int[] copy = Arrays.copyOf(numbers, numbers.length);
		assertEquals(2, SentinelSearch.firstIndex(numbers, 44));
		assertTrue("Array elements have changed", Arrays.equals(numbers, copy));
	}

	@Test
	public void findFirstElementTest2() {
		int[] numbers = { 5, 2, 44, 534, 22, 44, 45, 65 };
		int[] copy = Arrays.copyOf(numbers, numbers.length);
		assertEquals(2, SentinelSearch.firstIndex(numbers, 44));
		assertTrue("Array elements have changed", Arrays.equals(numbers, copy));
	}

	@Test
	public void testZeroLengthArray() {
		int[] numbers = new int[0];
		assertEquals("Empty array contains no elements", -1, SentinelSearch.firstIndex(numbers, 30));
	}

	@Test
	public void testLengthOneArrayTrue() {
		int[] numbers = new int[] { 30 };
		assertEquals("Element must be found even in an array of length one", 0, SentinelSearch.firstIndex(numbers, 30));
	}

	@Test
	public void testLengthOneArrayFalse() {
		int[] numbers = new int[] { 30 };
		assertEquals("Should return -1, if Array of length one does not contain element searched for", -1,
				SentinelSearch.firstIndex(numbers, 31));
	}
}

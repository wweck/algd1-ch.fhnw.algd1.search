/*
 * Created on 10.03.2022
 */
package ch.fhnw.algd1.search.tripleseqsearch;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author Wolfgang Weck
 */
public class TripleSeqSearchTest {
	@Test
	public void testEmpty() {
		assertFalse(TripleSeqSearch.hasSequence(new int[] {}));
	}

	@Test
	public void testSingleElement1() {
		assertFalse(TripleSeqSearch.hasSequence(new int[] { 1 }));
	}

	@Test
	public void testSingleElement7() {
		assertFalse(TripleSeqSearch.hasSequence(new int[] { 7 }));
	}

	@Test
	public void testThreeArbitraryElements() {
		assertFalse(TripleSeqSearch.hasSequence(new int[] { 1, 2, 3 }));
	}

	@Test
	public void testExactFits() {
		assertTrue(TripleSeqSearch.hasSequence(new int[] { 7, -11, 4 }));
		assertTrue(TripleSeqSearch.hasSequence(new int[] { 7, -11, -4 }));
	}

	@Test
	public void testFitWithPositiveEven() {
		assertTrue(TripleSeqSearch.hasSequence(new int[] { 1, 2, 7, 3, 4, -11, 5, 4, 9 }));
	}

	@Test
	public void testFitWithNegativeEven() {
		assertTrue(TripleSeqSearch.hasSequence(new int[] { 1, 2, 7, 3, 4, -11, 5, -4, 9 }));
	}

	@Test
	public void testFitWithReoccuring7() {
		assertTrue(TripleSeqSearch.hasSequence(new int[] { 1, 7, 7, -1, 7, 8, 7, -1 }));
	}

	@Test
	public void testFitWithDoubleOccurrences() {
		assertTrue(TripleSeqSearch.hasSequence(new int[] { 1, 7, 7, -1, -1, 8, 8, 9 }));
	}

	@Test
	public void testNoEven() {
		assertFalse(TripleSeqSearch.hasSequence(new int[] { 1, 2, 7, 3, 4, -11, 5, 9 }));
	}

	@Test
	public void testEvenNegativeOnly() {
		assertFalse(TripleSeqSearch.hasSequence(new int[] { 1, 2, 7, 3, 4, -2, 5, 9 }));
	}

	@Test(timeout = 1000)
	public void testEfficiency1() {
		int[] arr = new int[200_000];
		Arrays.fill(arr, -1);
		arr[0] = 7;
		assertFalse(TripleSeqSearch.hasSequence(arr));
	}

	@Test(timeout = 1000)
	public void testEfficiency2() {
		int[] arr = new int[200_000];
		Arrays.fill(arr, 7);
		assertFalse(TripleSeqSearch.hasSequence(arr));
	}

	@Test(timeout = 10)
	public void testEfficiency3() {
		int[] arr = new int[200_000];
		Arrays.fill(arr, 3);
		arr[0] = 7;
		arr[1] = -1;
		arr[2] = 2;
		for (int i = 0; i < 100; i++)
			assertTrue(TripleSeqSearch.hasSequence(arr));
	}
}

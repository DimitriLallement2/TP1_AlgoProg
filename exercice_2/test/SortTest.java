package test;

import java.util.Arrays;

import junit.framework.TestCase;
import src.DichoInsertSort;
import src.Sort;

public class SortTest extends TestCase {
	// Trieur
	Sort s;	
	
	// Tableau de test
	int[] tab = {8, -2, 27, 28, 56, 4, -7, 12, 0, 8};
	int[] expected = {-7, -2, 0, 4, 8, 8, 12, 27, 28, 56};
	
	/**
	 * Test du tri par insertion dichotomique
	 */
	public final void testSortInsertDicho() {
		s = new DichoInsertSort();
		int[] tmp = tab;
		s.sort(tmp);
		System.out.println(Arrays.equals(expected, tmp));
		assertTrue("Tri par Insertion Dichotomique", Arrays.equals(expected, tmp));
	}
}

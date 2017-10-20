package test;

import java.util.Arrays;

import junit.framework.TestCase;
import src.DichoInsertSort;
import src.ShakerSort;
import src.ShellSort;
import src.Sort;

public class SortTest extends TestCase {
	// Trieur
	Sort s;	
	
	// Tableau de test
	final int[] tab = {8, -2, 27, 28, 56, 4, -7, 12, 0, 8};
	final int[] expected = {-7, -2, 0, 4, 8, 8, 12, 27, 28, 56};
	
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
	
	/**
	 * Test du tri Shell Sort
	 */
	public final void testShellSort() {
		s = new ShellSort();
		int[] tmp = tab;
		s.sort(tmp);
		System.out.println(Arrays.equals(expected, tmp));
		assertTrue("Tri Shell Sort", Arrays.equals(expected, tmp));
	}
	
	/**
	 * Test du tri bulle melange
	 */
	public final void testSortShaker() {
		s = new ShakerSort();
		int[] tmp = tab;
		s.sort(tmp);
		assertTrue("Tri bulle melange cas de base", Arrays.equals(expected, tmp));
	}
	
	/**
	 * Test du tri Shell Sort avec tableau vide
	 */
	public final void testShellSortEmptyArr() {
		s = new ShellSort();
		int[] tmp = null;
		 try {
			    s.sort(tmp);
			    fail("Devrait lever une exception quand le tableau est vide");
			  }catch(IllegalArgumentException e){
			    assert(e.getMessage().contains("Tableau null ou taille invalide"));
			  }
	}
	
	/**
	 * Test du tri Shell Sort avec un seul element
	 */
	public final void testShellSortArrOneElement() {
		s = new ShellSort();
		int[] tmp = {1};
		 try {
			    s.sort(tmp);
			    fail("Devrait lever une exception quand le tableau ne contient qu un element");
			  }catch(IllegalArgumentException e){
			    assert(e.getMessage().contains("Tableau null ou taille invalide"));
			  }
	}
	

	/**
	 * Test du tri par insertion dichotomique avec tableau vide
	 */
	public final void testDichoEmptyArr() {
		s = new DichoInsertSort();
		int[] tmp = null;
		 try {
			    s.sort(tmp);
			    fail("Devrait lever une exception quand le tableau est vide");
			  }catch(IllegalArgumentException e){
			    assert(e.getMessage().contains("Tableau null ou taille invalide"));
			  }
	}
	
	/**
	 * Test du tri par insertion dichotomique avec un seul element
	 */
	public final void testDichoArrOneElement() {
		s = new DichoInsertSort();
		int[] tmp = {1};
		 try {
			    s.sort(tmp);
			    fail("Devrait lever une exception quand le tableau ne contient qu un element");
			  }catch(IllegalArgumentException e){
			    assert(e.getMessage().contains("Tableau null ou taille invalide"));
			  }
	}
	
	
	
	/**
	 * Test du tri bulle melange avec tableau vide
	 */
	public final void testSortShakerEmptyArr() {
		s = new ShakerSort();
		int[] tmp = null;
		 try {
			    s.sort(tmp);
			    fail("Devrait lever une exception quand le tableau est vide");
			  }catch(IllegalArgumentException e){
			    assert(e.getMessage().contains("Tableau null ou taille invalide"));
			  }
	}
	
	
	/**
	 * Test du tri bulle melange avec un seul element
	 */
	public final void testSortShakerArrOneElement() {
		s = new ShakerSort();
		int[] tmp = {1};
		 try {
			    s.sort(tmp);
			    fail("Devrait lever une exception quand le tableau ne contient qu un element");
			  }catch(IllegalArgumentException e){
			    assert(e.getMessage().contains("Tableau null ou taille invalide"));
			  }
	}
	
	/**
	 * Test de base de l echange de case des tableaux de int
	 */
	public final void testSwap() {
		s = new ShakerSort();
		int[] tmp = {1,2,3};
		int[] expected2 = {2,1,3};
		s.swap(tmp, 0, 1);
		assertTrue("Echange de deux valeurs consecutives", Arrays.equals(expected2, tmp));
		int[] expected3 = {3,1,2};
		s.swap(tmp, 0, 2);
		assertTrue("Echange de deux valeurs non consecutives", Arrays.equals(expected3, tmp));
	}
	
	/**
	 * Test des cas limites de l echange de case des tableaux de int
	 */
	public final void testSwapWithBadArg() {
		s = new ShakerSort();
		int	idx1 = tab.length+1;
		int[] tmp = tab;
		 try {
				s.swap(tmp, idx1, 1);
			    fail("Devrait lever une exception quand l indice est superieur a la taille du tableau");
			  }catch(IndexOutOfBoundsException e){
			    assert(e.getMessage().contains("Probleme dans les indices, taille superieure a la taille du tableau ou inferieure a 0"));
			  }
			int	idx2 = (-2);
		 try {
				s.swap(tmp, 0, idx2);
			    fail("Devrait lever une exception quand l indice est inferieur a 0");
			  }catch(IndexOutOfBoundsException e){
			    assert(e.getMessage().contains("Probleme dans les indices, taille superieure a la taille du tableau ou inferieure a 0"));
			  }
		 try {
				s.swap(tmp, idx1, idx2);
			    fail("Devrait lever une exception quand les indices sont incorrects");
			  }catch(IndexOutOfBoundsException e){
			    assert(e.getMessage().contains("Probleme dans les indices, taille superieure a la taille du tableau ou inferieure a 0"));
			  }
		 tmp = null;
		 try {
				s.swap(tmp, 0, 1);
			    fail("Devrait lever une exception quand le tableau est null");
			  }catch(IllegalArgumentException e){
			    assert(e.getMessage().contains("Tableau null ou taille invalide"));
			  }
		 int[] tmp2 = {1};
		 try {
				s.swap(tmp2, 0, 1);
			    fail("Devrait lever une exception quand la taille du tableau est inferieure a 2");
			  }catch(IllegalArgumentException e){
			    assert(e.getMessage().contains("Tableau null ou taille invalide"));
			  }
	}
}

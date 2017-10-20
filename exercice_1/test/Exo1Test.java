package test;

import junit.framework.TestCase;
import src.Candidate;
import src.CircularList;

public class Exo1Test extends TestCase {
	// Liste de test
	CircularList<Candidate> list = new CircularList<>();


	/**
	 * Test correspondant a la question d)
	 */
	public final void testBasic() {
		Candidate test;
		for (int i = 1; i <= 7; i++) {
			test = new Candidate("" + i, "");
			list.add(test);
		}
		Candidate expected = new Candidate("4", "");
		Candidate result = list.electItem(3);
		assertEquals("7 candidats, k= 3", expected.getName(), result.getName());
	}
	
	/**
	 * K superieur a la taille de la liste
	 */
	public final void testIllegalParamater() {
		CircularList<Candidate> list = new CircularList<>();
		Candidate test;
		for (int i = 1; i <= 7; i++) {
			test = new Candidate("" + i, "");
			list.add(test);
		}
		 try {
				list.electItem(8);
			    fail("Devrait lever une exception quand k est superieur a la taille de la liste");
			  }catch(IllegalArgumentException e){
			    assert(e.getMessage().contains("k choisi superieur a la taille de la liste"));
			  }
	}
	
	/**
	 * Indice superieur a la taille de la liste
	 */
	public final void testOutOfBound() {
		CircularList<Candidate> list = new CircularList<>();
		Candidate test = new Candidate("" , "");
		list.add(test);
		 try {
				list.get(2);
			    fail("Devrait lever une exception quand l indice de la liste est superieur a sa taille");
			  }catch(IndexOutOfBoundsException e){
			    assert(e.getMessage().contains("L index fourni est superieur a la taille de la liste"));
			  }
	}
}

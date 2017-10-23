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
	 * K inferieur a 0
	 */
	public final void testIllegalParamater() {
		CircularList<Candidate> list = new CircularList<>();
		Candidate test;
		for (int i = 1; i <= 7; i++) {
			test = new Candidate("" + i, "");
			list.add(test);
		}
		try {
			list.electItem(-1);
			fail("Devrait lever une exception quand k est inferieur a 0");
		} catch (IllegalArgumentException e) {
			assert (e.getMessage().contains("Le parametre k doit etre superieur a 0"));
		}
	}
	
}

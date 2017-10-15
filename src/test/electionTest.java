package test;

import exercice_1.Candidate;
import exercice_1.CircularList;

public class electionTest {
	// Liste de test
	CircularList<Candidate> list = new CircularList<>();

	public final void testOutOfBound() {
		CircularList<Candidate> list = new CircularList<>();
		Candidate test;
		for (int i = 1; i <= 7; i++) {
			test = new Candidate("" + i, "");
			list.add(test);
		}
		list.electItem(8);
		// TODO FINISH
	}
	
	public final void testBasic() {
		Candidate test;
		for (int i = 1; i <= 7; i++) {
			test = new Candidate("" + i, "");
			list.add(test);
		}
		Candidate expected = new Candidate("4", "");
		Candidate result = list.electItem(3);
		// assertEquals("7 candidats, k= 3", expected.getName(),
		// result.getName());
	}
}

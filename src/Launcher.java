
public class Launcher {
	public static void main(String[] args) {
		CircularList<Candidate> list = new CircularList<>();
		Candidate test;
		for (int i = 1; i < 6; i++) {
			test = new Candidate("nom" + i, "prenom" + i);
			list.add(test);
		}
		System.out.println(list);
	}
}

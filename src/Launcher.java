public class Launcher {
	public static void main(String[] args) {
		CircularList<Candidate> list = new CircularList<>();
		Candidate test;
		for (int i = 1; i <= 7; i++) {
			test = new Candidate("nom" + i, "prenom" + i);
			list.add(test);
		}
		list.electItem(3);
		System.out.println(list);
	}
}

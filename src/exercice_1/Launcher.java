package exercice_1;
public class Launcher {
	public static void main(String[] args) {
		CircularList<Candidate> list = new CircularList<>();
		Candidate test;
		for (int i = 1; i <= 7; i++) {
			test = new Candidate("" + i, "");
			list.add(test);
		}
		Candidate vainqueur = (Candidate)list.electItem(3);
		System.out.println("Le vainqueur est : " + vainqueur.getName());
	}
}

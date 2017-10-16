package exercice_1;

public class Launcher {
	public static void main(String[] args) {
		elections();
	}

	static CircularList<Candidate> initList(int nbCandidates) {
		CircularList<Candidate> list = new CircularList<>();
		for (int i = 0; i < nbCandidates; i++) {
			list.add(new Candidate("" + i, ""));
		}
		return list;
	}

	static void elections() {
		Object[] lists = new Object[4];
		for (int i = 0; i < 4; i++) {
			lists[i] = new CircularList<Candidate>();
		}

		for (int i = 0; i < 4; i++) {
			// 10^3 candidats
			lists[i] = initList((int) Math.pow(10, i + 3));
			System.out.println("Pour k = 2,  le vainqueur parmi 10e" + (i + 3) + " candidats est : "
					+ (((CircularList<Candidate>) lists[i]).electItem(2).getName()));
			// 10^4 candidats
			lists[i] = initList((int) Math.pow(10, i + 3));
			System.out.println("Pour k = 3,  le vainqueur parmi 10e" + (i + 3) + " candidats est : "
					+ (((CircularList<Candidate>) lists[i]).electItem(3).getName()));
			// 10^5 candidats
			lists[i] = initList((int) Math.pow(10, i + 3));
			System.out.println("Pour k = 5,  le vainqueur parmi 10e" + (i + 3) + " candidats est : "
					+ (((CircularList<Candidate>) lists[i]).electItem(5).getName()));
			// 10^6 candidats
			lists[i] = initList((int) Math.pow(10, i + 3));
			System.out.println("Pour k = 10, le vainqueur parmi 10e" + (i + 3) + " candidats est : "
					+ (((CircularList<Candidate>) lists[i]).electItem(10).getName()));
		}
	}

}

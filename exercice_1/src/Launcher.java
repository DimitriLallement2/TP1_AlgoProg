package src;

public class Launcher {
	
	public static void main(String[] args) {
		elections();
//		election7Candidates();
		// stats();
	}

	/**
	 * @param nbCandidates
	 *            nombre de candidat a l election
	 * @return la liste initialisee
	 */
	static CircularList<Candidate> initList(int nbCandidates) {
		CircularList<Candidate> list = new CircularList<>();
		for (int i = 1; i <= nbCandidates; i++) {
			list.add(new Candidate("" + i, ""));
		}
		return list;
	}
	
	/**
	 * Simulation de l election entre 7 candidats pour k valant 3
	 */
	static void election7Candidates(){
		CircularList<Candidate> list = new CircularList<>();
		for (int i = 1; i <= 7; i++) {
			list.add(new Candidate("Candidat " + i, ""));
		}
		System.out.println("Le candidat vainqueur est : " + list.electItem(3).getName());
	}

	/**
	 * Simulation des elections de la question e)
	 */
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

	/**
	 * Simulation des elections de la question f) pour k variant de 1 a 200 et n
	 * = 100
	 */
	static void stats() {
		CircularList<Candidate> list = new CircularList<Candidate>();
		for (int k = 1; k < 201; k++) {
			list = initList(100);
			list.electItem(k);
			System.out.println("k = " + k + ", iterations = " + list.getIterator());
		}
	}
}

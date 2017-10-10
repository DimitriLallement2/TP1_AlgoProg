/**
 * Structure de donnee reprensentant un candidat
 */
public class Candidate {
	// Nom du candidat
	private String name;
	// Prenom du candiat
	private String firstName;

	/**
	 * Constructeur parametre
	 * 
	 * @param name
	 *            nom du candidat
	 * @param firstName
	 *            prenom du candidat
	 */
	public Candidate(String name, String firstName) {
		this.name = name;
		this.firstName = firstName;
	}

	/**
	 * Affiche le prenom et le nom du candidat
	 */
	public void print() {
		System.out.println(firstName + " " + name);
	}
}

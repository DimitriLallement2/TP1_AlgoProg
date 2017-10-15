package exercice_1;
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
	@Override
	public String toString() {
		return (firstName + " " + name);
	}

	/**
	 * @return le nom du candidat
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return le prenom du candidat
	 */
	public String getFirstName() {
		return this.firstName;
	}
}

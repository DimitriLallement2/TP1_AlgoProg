package src;

public abstract class Sort {
	/**
	 * Trie un tableau d entier dans l ordre croissant des elements
	 * 
	 * @param tab
	 *            le tableau trie
	 */
	public void sort(int[] tab) {
		if (tab == null || tab.length < 2) {
			throw new IllegalArgumentException("Tableau null ou taille invalide");
		}
	}

	/**
	 * Permute deux elements dans un tableau
	 * 
	 * @param tab
	 *            tableau d entiers non vide
	 * @param index1
	 *            index du premier element
	 * @param index2
	 *            index du second element
	 */
	public void swap(int[] tab, int index1, int index2) throws IllegalArgumentException, IndexOutOfBoundsException {
		if (tab == null || tab.length < 2) {
			throw new IllegalArgumentException("Tableau null ou taille invalide");
		}
		if (index1 > tab.length || index2 > tab.length || index1 < 0 || index2 < 0) {
			throw new IndexOutOfBoundsException("Probleme dans les indices, taille superieure a la taille du tableau ou inferieure a 0");
		}
		int tmp = tab[index1];
		tab[index1] = tab[index2];
		tab[index2] = tmp;
	}
}

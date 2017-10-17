package src;

public abstract class Sort {
	/**
	 * Trie un tableau d entier dans l ordre croissant des elements
	 * 
	 * @param tab
	 *            le tableau trie
	 */
	public abstract void sort(int[] tab);

	/**
	 * Permutte deux elements dans un tableau
	 * 
	 * @param tab
	 *            tableau d entiers non vide
	 * @param index1
	 *            index du premier element
	 * @param index2
	 *            index du second element
	 */
	public void swap(int[] tab, int index1, int index2) {
		if (tab == null || tab.length == 0) {
			throw new IllegalArgumentException("Tableau vide ou null");
		}
		if (index1 > tab.length || index2 > tab.length) {
			throw new IndexOutOfBoundsException("Probleme dans les indices, taille superieur a la taille du tableau");
		}
		int tmp = tab[index1];
		tab[index1] = tab[index2];
		tab[index2] = tmp;
	}
}

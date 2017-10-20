package src;

public class DichoInsertSort extends Sort {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void sort(int[] tab) {
		super.sort(tab);
		long startTime = System.currentTimeMillis();
		int indSort, tmp;
		int a, b, m;

		for (int i = tab.length - 2; i >= 0; i--) {
			// Recherche dichotomique pour trouver la position d insertion
			a = i + 1;
			b = tab.length - 1;
			while (a <= b) {
				m = (a + b) / 2;
				if (tab[i] > tab[m]) {
					comparisons++;
					a = m + 1;
				} else {
					b = m - 1;
				}
			}
			indSort = (a + b) / 2;

			// Decalage des valeurs pour l insertion
			tmp = tab[i];
			assignments++;

			for (int j = i; j < indSort; j++) {
				tab[j] = tab[j + 1];
				assignments++;
			}
			tab[indSort] = tmp;
			assignments++;
		}
		long endTime = System.currentTimeMillis();
		runtime = endTime - startTime;
	}

}

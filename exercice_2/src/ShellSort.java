package src;

public class ShellSort extends Sort {

	/**
	 * Algorithme inspire de la page Wikipedia du shell sort
	 * (https://en.wikipedia.org/wiki/Shellsort)
	 * {@inheritDoc}
	 */
	@Override
	public void sort(int[] tab){
		super.sort(tab);
		long startTime = System.currentTimeMillis();
		
		// Tableau des "meilleurs" k repris de la page Wikipedia
		int[] gaps = {701, 301, 132, 57, 23, 10, 4, 1};
		
		for (int gap : gaps){
			for (int i=gap ; i < tab.length ; i++){
				int tmp = tab[i];
				assignments++;
				int j = i;
				for (j=i ; j >= gap && tab[j-gap] > tmp ; j -= gap){
					comparisons++;
					tab[j] = tab[j-gap];
					assignments++;
				}
				tab[j] = tmp;
				assignments++;
			}
		}
		long endTime = System.currentTimeMillis();
		runtime = endTime - startTime;
	}
}

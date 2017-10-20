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
		
		// Tableau des "meilleurs" k repris de la page Wikipedia
		int[] gaps = {701, 301, 132, 57, 23, 10, 4, 1};
		
		for (int gap : gaps){
			for (int i=gap ; i < tab.length ; i++){
				int tmp = tab[i];
				int j = i;
				for (j=i ; j >= gap && tab[j-gap] > tmp ; j -= gap){
					tab[j] = tab[j-gap];
				}
				tab[j] = tmp;
			}
		}
		
	}
}

package src;

/**
 * Tri bulle melange
 */
public class ShakerSort extends Sort {

	/**
	 * {@inheritDoc} Algorithme inspiree de wikipedia
	 */
	@Override
	public void sort(int[] tab) {
		super.sort(tab);
		long startTime = System.currentTimeMillis();
		int start = 0;
		int end = tab.length - 2;
		boolean changed = true;
		while (changed) {
			changed = false;
			for (int i = start; i <= end; i++) {
				comparisons++;
				if (tab[i] > tab[i + 1]) {
					swap(tab, i, i + 1);
					changed = true;
				}
			}
			end--;
			for (int i = end; i >= start; i--) {
				comparisons++;
				if (tab[i] > tab[i + 1]) {
					swap(tab, i, i + 1);
					changed = true;
				}
			}
			start++;
		}
		long endTime = System.currentTimeMillis();
		runtime = endTime - startTime;
	}
}

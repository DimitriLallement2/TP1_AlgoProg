package src;

/**
 * Tri bulle melange
 */
public class ShakerSort extends Sort {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void sort(int[] tab) {
		super.sort(tab);
		int start = 0;
		int end = tab.length - 2;
		boolean changed = true;
		while (changed){
			changed = false;
			for(int i = start; i <= end; i++){
				if(tab[i] > tab[i+1]){
					swap(tab, i, i+1);
					changed = true;
				}
			}
			end--;
			for(int i = end; i>= start; i--){
				if(tab[i] > tab[i+1]){
					swap(tab, i, i+1);
					changed = true;
				}
			}
			start++;
		}
	}
}

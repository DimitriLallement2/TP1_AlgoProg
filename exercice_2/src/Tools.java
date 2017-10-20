package src;

import java.util.Random;

public final class Tools {

	/**
	 * Genere un tableau de taille length rempli d entiers aleatoires compris
	 * entre low et high
	 * 
	 * @param length
	 *            taille du tableau voulu
	 * @param low
	 *            limite inferieure de generation
	 * @param high
	 *            limite superieure de generation
	 * @return tab le tableau
	 */
	public static int[] generateRandomArray(int length, int low, int high) {
		if (low > high) {
			throw new IllegalArgumentException("borne inferieur invalide");
		}
		if (length < 1) {
			throw new IllegalArgumentException("Taille du tableau invalide");
		}

		Random r = new Random();

		int[] tab = new int[length];
		for (int i = 0; i < length - 1; i++) {
			tab[i] = r.nextInt(high - low) + low;
		}
		return tab;
	}
}

package src;

import java.util.Random;

public class LauncherExo2 {

	public static void main(String[] args) {
		trisTaillesCroissantes(2, 10, 1);
		trisTaillesCroissantes(100, 1000, 100);
		trisTaillesCroissantes(1000, 10000, 1000);
		trisTaillesCroissantes(10000, 100000, 10000);
	}
	
	/**
	 * Compare les compteurs des trois méthodes de tris en fonction de tableaux de tailles croissantes
	 */
	private static void trisTaillesCroissantes(int tailleMin, int tailleMax, int pas){
		Sort sDicho = new DichoInsertSort();
		Sort sShaker = new ShakerSort();
		Sort sShell = new ShellSort();
		
		int[] tabToSort, tmp;
		
		System.out.println("\nComparaisons / Affectations / Temps d'execution\n");
		
		for (int i = tailleMin ; i <= tailleMax ; i += pas){
			tabToSort = Tools.generateRandomArray(i, -10*i, 10*i);
			
			// Insert Dicho
			tmp = tabToSort.clone();
			sDicho.sort(tmp);
			// Shaker Sort
			tmp = tabToSort.clone();
			sShaker.sort(tmp);
			// Shell Sort
			tmp = tabToSort.clone();
			sShell.sort(tmp);
			
			// Affichage des resultats
			System.out.println("--- Taille du tableau : " + i + "\n" 
					+ " Dicho  -- " + sDicho.getComparisons() + " / " + sDicho.getAssignments() + " / " + sDicho.getRuntime() + " ms \n"
					+ " Shaker -- " + sShaker.getComparisons() + " / " + sShaker.getAssignments() + " / " + sShaker.getRuntime() + " ms \n"
					+ " Shell  -- " + sShell.getComparisons() + " / " + sShell.getAssignments() + " / " + sShell.getRuntime() + " ms \n"		
			); 
			
			// Reinitialisaation des compteurs
			sDicho.resetCpt();
			sShaker.resetCpt();
			sShell.resetCpt();
		}
	}

}
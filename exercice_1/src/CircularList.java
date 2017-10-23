package src;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Structure de donnees reprensentant une liste chainee circulaire
 */
public class CircularList<Type> {

	// Premier element
	private Item last;
	// Taille de la liste
	private int size;
	// Logger de la classe
	private static Logger logger = Logger.getLogger(CircularList.class.getName());

	/**
	 * Constructeur par defaut
	 */
	public CircularList() {
		size = 0;
	}

	/**
	 * Ajoute un element a la liste
	 * 
	 * @param value
	 *            valeur du nouvel element
	 * @return true si l element a ete ajoute sinon false
	 * 
	 */
	public boolean add(Type value) {
		// liste vide
		if (size == 0) {
			last = new Item<Type>(value);
			// On fait pointer l element sur lui meme
			last.next = last;
		} else {
			Item<Type> tmp = new Item<Type>(value);
			// L element ajoute pointe sur le premier elt
			tmp.next = last.next;
			last.next = tmp;
			last = tmp;
		}
		size++;
		return true;
	}

	/**
	 * Supprime l element a un indice donne
	 * 
	 * @param index
	 *            indice de l element a supprimer
	 * @throws IndexOutOfBoundsException
	 */
	public void remove(int index) {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException("L indice est invalide");
		} else {

			if (size == 1) {
				// Un seul element restant
				this.last = null;
			} else {
				// Cas general
				Item tmp = last;
				// On parcourt la liste jusqu a l indice donne en parametre -1
				for (int i = 0; i < index; i++) {
					tmp = tmp.next;
				}
				//On met a jour le last si besoin
				if(tmp.next == last){
					last = tmp;
				}
				// on fait pointer l element precedent sur le suivant
				tmp.next = tmp.next.next;
			}
			size--;
		}
	}

	/**
	 * Elit le candidat suivant un schema : on elimine les k-ieme elements de
	 * facon recursive jusqu a ce qu il ne reste qu un element
	 * 
	 * @param k
	 *            la valeur de cycle de suppression, doit etre inferieur a la
	 *            taille de la liste
	 * @return item vainqueur
	 */
	public Type electItem(int k) {
		if (k < 0) {
			throw new IllegalArgumentException("Le parametre k doit etre superieur a 0");
		}
		int i = 0;
		// On supprime les elements jusqu a ce qu il en reste plus qu un
		while (size != 1) {
			i = (i + (k-1)) % size;
//			logger.log(Level.INFO, get(i) + "- Elimine");
			remove(i);
		}
		return (Type) last.value;
	}

	/**
	 * {@inheritDoc}
	 * Pour value il faut avoir surcharger le toString
	 */
	@Override
	public String toString() {
		String str = "";
		//premier elt
		Item tmp = last.next;
		for(int i = 0; i < size; i++){
			str += tmp.value.toString() + "\n";
			tmp = tmp.next;
		}
		return str;
	}

	/**
	 * Retourne l item de la liste d indice index
	 * 
	 * @param index
	 *            indice inferieur a la taille de la liste
	 * @return item
	 */
	public Item get(int index) {
		if (index >= size) {
			throw new IndexOutOfBoundsException("L index fourni est superieur a la taille de la liste");
		}
		Item tmp = last.next;
		for(int i = 0; i < index; i++){
			tmp = tmp.next;
		}
		return tmp;
	}

	/**
	 * @return la valeur de l item
	 */
	public Type getValue(Item i) {
		return (Type) i.value;
	}

	/**
	 * Structure de donne representant une cellule de la liste
	 *
	 * @param <Type>
	 */
	private class Item<Type> {
		// Prochain element
		private Item<?> next;
		// Valeur de l element
		private Type value;

		/**
		 * Constructeur
		 * 
		 * @param value
		 *            valeur de l element
		 */
		public Item(Type value) {
			this.value = value;
			this.next = null;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String toString() {
			return value.toString();
		}

	}

}

package src;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Structure de donnees reprensentant une liste chainee circulaire
 */
public class CircularList<Type> {

	// Premier element
	private Item cur;
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
		// Liste vide
		if (size == 0) {
			this.cur = new Item<Type>(value);
			// On fait pointer le seul element de la liste sur lui meme
			this.cur.next = this.cur;
		} else {
			Item<Type> newItem = new Item<Type>(value);
			// L element ajoute pointe sur le premier elt
			newItem.next = this.cur.next;
			this.cur.next = newItem;
			this.cur = newItem;
		}
		size++;
		return true;
	}

	/**
	 * Supprime l element suivant de cur
	 * 
	 * @param index
	 *            indice de l element a supprimer
	 * @throws IndexOutOfBoundsException
	 */
	public void removeNext() {
		if (size == 1) {
			// Cas avec un seul element dans la liste
			this.cur = null;
		} else {
			// Cas general - on supprime le next de cur de la liste
			this.cur.next = this.cur.next.next;
		}
		size--;
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
		// On supprime les elements jusqu a ce qu il en reste plus qu un
		while (this.size != 1) {
			for (int i=0 ; i < ((k - 1)%this.size) ; i++){
				this.cur = this.cur.next;
			}
//			logger.log(Level.INFO, this.cur.next.value + "- Elimine");
			removeNext();
		}
		return (Type) this.cur.value;
	}

	/**
	 * {@inheritDoc} Pour value il faut avoir surcharger le toString
	 */
	@Override
	public String toString() {
		String str = "";
		// premier elt
		Item tmp = cur.next;
		for (int i = 0; i < size; i++) {
			str += tmp.value.toString() + "\n";
			tmp = tmp.next;
		}
		return str;
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

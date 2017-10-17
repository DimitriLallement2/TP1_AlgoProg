package src;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Structure de donnees reprensentant une liste chainee circulaire
 */
public class CircularList<Type> {

	// Liste des elements
	private ArrayList<Item> items;
	// Logger de la classe
	private static Logger logger = Logger.getLogger(CircularList.class.getName());

	/**
	 * Constructeur par defaut
	 */
	public CircularList() {
		items = new ArrayList<>();
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
		if (items.isEmpty()) {
			return items.add(new Item<Type>(value));
		} else {
			items.add(new Item<Type>(value));
			// L avant dernier element pointe sur l element ajoute
			items.get(items.size() - 2).next = items.get(items.size() - 1);
			// Le dernier element ajoute pointe vers le premier element
			items.get(items.size() - 1).next = items.get(0);
			return true;
		}
	}

	/**
	 * Supprime l element a un indice donne
	 * 
	 * @param index
	 *            indice de l element a supprimer
	 * @throws IndexOutOfBoundsException
	 */
	public void remove(int index) {
		if (index < items.size()) {
			if (index == items.size() - 1) {
				// Si on supprime le dernier element on fait pointer l avant
				// dernier element sur le premier
				items.get(index - 1).next = items.get(0);
			} else {
				// Sinon on fait pointer l element precedent sur le suivant
				items.get(index - 1).next = items.get(index + 1);

			}
			items.remove(index);
		} else {
			throw new IndexOutOfBoundsException("L'indice est superieur a la taille de la liste");
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
		if (k > items.size()) {
			throw new IllegalArgumentException("k choisi superieur a la taille de la liste");
		}
		int i = 0;
		// On supprime les elements jusqu a ce qu il en reste plus qu un
		while (items.size() != 1) {
			i = (i + (k - 1)) % items.size();
			//logger.log(Level.INFO, items.get(i) + "- Elimine");
			items.remove(i);
		}
		return (Type) items.get(0).value;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		String str = "";
		for (Item item : items) {
			str += item.toString() + "\n";
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
		if (index >= items.size()) {
			throw new IndexOutOfBoundsException("L index fourni est superieur a la taille de la liste");
		}
		return items.get(index);
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

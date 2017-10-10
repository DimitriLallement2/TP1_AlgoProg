import java.util.ArrayList;

/**
 * Structure de donnees reprensentant une liste chainee circulaire
 */
public class CircularList<Type> {
	// Liste des elements
	private ArrayList<Item> items;

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
	 * @return true si l element a ete supprime sinon false
	 */
	public boolean remove(int index) {
		// TODO
		return false;
	}

	private class Item<Type> {
		// Prochain element
		private Item next;
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

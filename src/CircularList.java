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
	 * @throws IndexOutOfBoundsException
	 *             {@inheritDoc}
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
		}
	}

	/**
	 * Elit le candidat suivant un schema : on elimine les k-ieme elements de
	 * façon recursive jusqu a ce qu il ne reste qu un element
	 * 
	 * @param k
	 *            la valeur de cycle de suppression, doit etre inferieur a la
	 *            taille de la liste
	 * @return item vainqueur
	 */
	public Item electItem(int k) {
		if (k < items.size()) {
			// throw Exception e;
		}
		Item winner = null;
		int i = 0;
		while (items.size() != 1) {
			i = (i + (k - 1)) % items.size();
			System.out.println(items.get(i) + " - Elimine");
			items.remove(i);
		}
		return winner;
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

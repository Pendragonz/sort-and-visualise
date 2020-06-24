package sorters;

public abstract class Sorter {
	protected Sortable[] sortable;
	
	public Sorter(Sortable[] sortable) {
		this.sortable = sortable;
	}
	
	public Sorter() {
		
	}
	
	public abstract Sortable[] iter();
	
	public String nextLine() {
		sortable = iter();
		
		String str = "";
		for (int i = 0; i < sortable.length; i++) {
			str += sortable[i].getValue() + ", ";
		}
		return str;
	}
	
	/**Swap indexes a and b in sortable
	 * 
	 * @param a
	 * @param b
	 */
	public void swap(int a, int b) {
		Sortable temp = sortable[a];
		sortable[a] = sortable[b];
		sortable[b] = temp;
	}
	
}

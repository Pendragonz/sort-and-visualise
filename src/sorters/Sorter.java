package sorters;


public abstract class Sorter {
	protected Sortable[] sortable;
	
	public Sorter(Sortable[] sortable) {
		this.sortable = sortable;
	}
	
	public Sorter() {}
	
	public abstract Sortable[] iter();
	
	public String nextLine() {
		String old = toString(sortable);
		sortable = iter();
		String newLine = toString(sortable);

		if(old.equals(newLine)) {
			return "Done!";
		}
		
		
		return newLine;
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
	
	public String toString(Sortable[] arr) {
		String str = "";
		for (int i = 0; i < arr.length; i++) {
			str += arr[i].getValue() + ", ";
		}
		
		if(str.length() > 2) {
			//remove final ', '
			str = str.substring(0, str.length() - 2);
		}
		
		return str;
	}
	
}

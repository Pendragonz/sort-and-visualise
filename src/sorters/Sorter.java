package sorters;

public abstract class Sorter {
	private Sortable[] sortable;
	
	public Sorter(Sortable[] sortable) {
		this.sortable = sortable;
	}
	
	public abstract Sortable[] sort();
	
}

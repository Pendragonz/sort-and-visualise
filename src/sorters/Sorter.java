package sorters;

public abstract class Sorter {
	private Sortable[] sortable;
	
	public Sorter(Sortable[] sortable) {
		this.sortable = sortable;
	}
	
	public Sorter() {
		
	}
	
	public abstract Sortable[] sort();
	
	public abstract Sortable[] iter(Sortable[] in);
}

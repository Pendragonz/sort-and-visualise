package sorters;


/**
 * @author Pendragonz
 *
 */
public class Bubble extends Sorter {

	/**
	 * @param sortable
	 */
	public Bubble(Sortable[] sortable) {
		super(sortable);
	}

	@Override
	public Sortable[] iter() {
		for(int b = 1; b < sortable.length; b++) {
			int a = b - 1;
			
			if( sortable[b].getValue() > sortable[a].getValue() ) {
				//already in order
			} else {
				swap(a, b);
			}
		}
		
		return sortable;
		
	}

}

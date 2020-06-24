package sorters;

/**
 * 
 */

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
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public Sortable[] iter() {
		// TODO Auto-generated method stub
		//return sortable;
		System.out.println("Processing line");
		
		
		for(int b = 1; b < sortable.length; b++) {
			int a = b - 1;
			
			
			if( sortable[b].getValue() > sortable[a].getValue() ) {
				//already in order
			} else {
				//swap
				swap(a, b);
			}
			
		}
		
		return sortable;
		
	}

}

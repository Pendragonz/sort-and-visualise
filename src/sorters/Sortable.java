package sorters;
import java.util.Random;

public class Sortable {
	
	
	private int value;
	private String colour;
	
	/**
	 * 	
	 * @param maxnum
	 * @param rand		Random number generator.
	 */
	public Sortable(int maxnum, Random rand) {
		this.value = rand.nextInt(maxnum);
		generateColour(maxnum);
		
	}
	
	
	private void generateColour(int maxnum) {
		
	}
	
	public int getValue() {
		return value;
	}
	
	public String getColour() {
		return colour;
	}
	
	public String toString() {
		return "" + value;
	}
	
	
}

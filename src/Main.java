import java.util.Random;

/**
 * @author Pendragonz
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Random r = new Random();
		r.setSeed(912839);
		Visualisor v = new Visualisor(r);
	}

}

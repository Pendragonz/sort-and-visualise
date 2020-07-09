import javax.swing.JTextArea;

import sorters.Sorter;

public class SortingThread extends Thread {

	public volatile boolean running = false;
	private JTextArea text;
	private Sorter sorter;
	
	
	public void run() {
		running=true;
		while (running=true) {
			
			String newLine = sorter.nextLine();
			
			if(newLine.equals("Done!")) {
				text.append(newLine);
				return;
			}
			
			text.append(newLine + "\n");
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public SortingThread(JTextArea text, Sorter sorter) {
		this.text = text;
		this.sorter = sorter;
	}

}

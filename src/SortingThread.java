import javax.swing.JTextArea;

import sorters.Sorter;

public class SortingThread extends Thread {

	public volatile boolean running = false;
	private JTextArea text;
	private Sorter sorter;
	
	
	public void run() {
		running=true;
		while (running=true) {
			text.append(sorter.nextLine() + "\n");
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public SortingThread(JTextArea text, Sorter sorter) {
		// TODO Auto-generated constructor stub
		this.text = text;
		this.sorter = sorter;

	}

	public SortingThread(Runnable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public SortingThread(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public SortingThread(ThreadGroup arg0, Runnable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public SortingThread(ThreadGroup arg0, String arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public SortingThread(Runnable arg0, String arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public SortingThread(ThreadGroup arg0, Runnable arg1, String arg2) {
		super(arg0, arg1, arg2);
		// TODO Auto-generated constructor stub
	}

	public SortingThread(ThreadGroup arg0, Runnable arg1, String arg2, long arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}

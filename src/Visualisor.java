import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import sorters.Bubble;
import sorters.Sortable;
import sorters.Sorter;
/**
 * 
 * @author Pendragonz
 *
 */
public class Visualisor {
	private Random random;
	private JFrame mainFrame;
	private JTextArea text;
	
	
	public Visualisor(Random random) {
		this.random = random;
		createWindow();

	}
	
	
	public void createWindow() {
		
		
		final int blankSpace = 6;
		
		//step 1: create all components
		JButton bubbleButton = new JButton();
		JButton quickButton = new JButton();
		JButton insertionButton = new JButton();
		JButton mergeButton = new JButton();
		
		text = new JTextArea("", 20, 50);
		
				
		//step 2: specify component properties
		bubbleButton.setText("Bubble Sort");
		bubbleButton.setToolTipText("Starts a Bubble Sort");
		quickButton.setText("Quick Sort");
		quickButton.setToolTipText("Starts a Quick Sort");
		insertionButton.setText("Insertion Sort");
		insertionButton.setToolTipText("Starts an Insertion Sort");
		mergeButton.setText("Merge Sort");
		mergeButton.setToolTipText("Starts a Merge Sort");
		
		text.setLineWrap(true);
		text.setEditable(true);
		
		
		//step 3: create containers
		mainFrame = new JFrame("Visualisor");
		mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		JPanel buttonBox = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane(text);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		//step 4: specify LayoutManagers
		mainFrame.setLayout(new BorderLayout());
		((JPanel)mainFrame.getContentPane()).setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
		
		buttonBox.setLayout(new FlowLayout());
		buttonBox.setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
		
		
		//step 5: add components to containers
		buttonBox.add(bubbleButton);
		buttonBox.add(quickButton);
		buttonBox.add(insertionButton);
		buttonBox.add(mergeButton);
		

		mainFrame.add(buttonBox, BorderLayout.NORTH);
		mainFrame.add(scrollPane, BorderLayout.SOUTH);

		
		//step 6: arrange to handle events in user interface
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				exitApp();
			}
		});
		

		bubbleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bubbleClick();
			}
		});
		quickButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quickClick();
			}
		});
		mergeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mergeClick();
			}
		});
		insertionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertionClick();
			}
		});
		
		
		
		//step 7: display
		mainFrame.pack();
		mainFrame.setVisible(true);
		
	}
	
	private void exitApp() {
		System.exit(0);
	}
	
	
	private Sortable[] randomiseRow(int length, int max) {
		Sortable[] row = new Sortable[length];
		
		for(int i=0; i < row.length; i++) {
			row[i] = new Sortable(max, random);
		}
		
		return row;
	}
	
	
	private SortingThread sort;	
	
	
	//TODO merge all buttonClick methods and use an enum parameter
	
	/**
	 * onclick functionality for bubbleButton
	 */
	private void bubbleClick() {
		System.out.println("BubbleButton Clicked");
		if (sort == null) {
			Bubble b = new Bubble( randomiseRow(20, 100) );
			startThread(b);
		} 
		
		if (sort.running == true){
			sort.running = false;
			sort.stop();
			sort = null;
		} else if (sort.running == false) {
			sort.start();
		}
	}
	
	/**
	 * onclick functionality for quickButton
	 */
	private void quickClick() {//TODO
		System.out.println("QuickButton Clicked");
	}
	
	/**
	 * onclick functionality for mergeButton
	 */
	private void mergeClick() {//TODO
		System.out.println("MergeButton Clicked");
	}
	
	/**
	 * onclick functionality for insertionButton
	 */
	private void insertionClick() {//TODO
		System.out.println("InsertionButton Clicked");
	}
	
	private void startThread(Sorter s) {
		text.setText("");
		sort = new SortingThread(text, s);
	}
	
}

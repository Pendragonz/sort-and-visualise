import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
/**
 * 
 * @author Pendragonz
 *
 */
public class Visualisor {
	private JFrame mainFrame;
	private JTable table;

	//TODO -- generate table headers based on this value
	public static final int LENGTH_OF_SORTING_SPACE = 10;
	
	
	public Visualisor() {
		createWindow();
		loopNewTableRows();
	}
	
	
	public void createWindow() {
		
		
		final int blankSpace = 6;
		
		//step 1: create all components
		JButton bubbleButton = new JButton();
		JButton quickButton = new JButton();
		JButton insertionButton = new JButton();
		JButton mergeButton = new JButton();
		
		
		Object[][] startingData = {
				{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}
				};
		
		
		
		String[] columnTitles = {"", "", "", "", "", "", "", "", "", ""};
		
		table = new JTable(new DefaultTableModel(startingData, columnTitles));
		
		//step 2: specify component properties
		bubbleButton.setText("Bubble Sort");
		bubbleButton.setToolTipText("Starts a Bubble Sort");
		quickButton.setText("Quick Sort");
		quickButton.setToolTipText("Starts a Quick Sort");
		insertionButton.setText("Insertion Sort");
		insertionButton.setToolTipText("Starts an Insertion Sort");
		mergeButton.setText("Merge Sort");
		mergeButton.setToolTipText("Starts a Merge Sort");
		
		
		//step 3: create containers
		mainFrame = new JFrame("Visualisor");
		mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		JPanel buttonBox = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		
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
		
		//TODO add container to display a row of Sortable objects.
		
		
		
		//step 7: display
		mainFrame.pack();
		mainFrame.setVisible(true);
		
		
	}
	
	private void exitApp() {
		System.exit(0);
	}
	

	
	private void loopNewTableRows() {
		while (true)  {
			addTableRow(new Object[] {"0","1","2","3","4","5","6","7","8","9"});
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	private void addTableRow(Object[] row) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(row);
	}
	
	
	
	
	//TODO link to Sorters
	/**
	 * onclick functionality for bubbleButton
	 */
	private void bubbleClick() {
		System.out.println("BubbleButton Clicked");
	}
	
	/**
	 * onclick functionality for quickButton
	 */
	private void quickClick() {
		System.out.println("QuickButton Clicked");
	}
	
	/**
	 * onclick functionality for mergeButton
	 */
	private void mergeClick() {
		System.out.println("MergeButton Clicked");
	}
	
	/**
	 * onclick functionality for insertionButton
	 */
	private void insertionClick() {
		System.out.println("InsertionButton Clicked");
	}
	
}

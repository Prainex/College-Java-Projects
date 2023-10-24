package Project4;

import javax.swing.*;

@SuppressWarnings("serial")
public class RomanNumeralGUI extends JFrame
{
	/**
	 * Reference from Dr. Lord's lecture #6 on GUI's and Inheritance
	 * Creates the Gridlayout and initializes the name of it, location and size.
	 */
	public void initialize()
	{
		setTitle("Roman Numerals to Arabic Numbers");
		setSize(450, 300);
		setLocation(100, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createMenu();
		setVisible(true);
	}
	
	/**
	 * 
	 * Reference from Dr. Lord's lecture #10 Event-Driven Programming
	 * Creates the menu with the menubar, menus and items.
	 */
	private void createMenu() 
	{
		JMenuBar menuBar;
		JMenu fileMenu;
		JMenu convertMenu;
		JMenuItem openItem;
		JMenuItem quitItem;
		JMenuItem conversionItem;
		
		FileMenuHandler fmh  = new FileMenuHandler(this);
		
		menuBar  = new JMenuBar();
		fileMenu = new JMenu("File");
		convertMenu = new JMenu("Convert");
		openItem = new JMenuItem("Open"); 
		quitItem = new JMenuItem("Quit"); 
		conversionItem = new JMenuItem("Roman to Arabic");
		
		
		fileMenu.add(openItem);
		fileMenu.addSeparator(); 
		fileMenu.add(quitItem);
		convertMenu.add(conversionItem);
		
		openItem.addActionListener(fmh);
		quitItem.addActionListener(fmh);
		conversionItem.addActionListener(fmh);
		
		setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		menuBar.add(convertMenu);
	} //createMenu
}

package Project4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.TreeMap;
import java.util.Map.Entry;

public class FileMenuHandler implements ActionListener {
	JFrame jframe;
	Container myContentPane;
	
	// Initializes TreeMap
	TreeMap <RomanNumeral, Integer> romanNumerals = new TreeMap<RomanNumeral, Integer>();
	
	
	/**
	 * Initializes the jframe window for future reference.
	 * 
	 * @param jf = Create the Jframe
	 */
	public FileMenuHandler(JFrame jf) {
		jframe = jf;
	}

	/**
	 * Reference from Dr. Lord's lecture #10 Event-Driven Programming
	 * 
	 * @param event = Takes in the actionListener from RomanNumeral GUI
	 */
	public void actionPerformed(ActionEvent event) {
		String menuName;
		menuName = event.getActionCommand();
		if (menuName.equals("Open"))
			openFile();
		else if (menuName.equals("Quit"))
			System.exit(0);
		else if (menuName.equals("Roman to Arabic"))
			conversion();
	}

	/**
	 * Reference from Dr. Lord's lecture #10 Event-Driven Programming
	 */
	private void openFile() {
		int status = 0;
		JFileChooser chooser = new JFileChooser();

		status = chooser.showOpenDialog(null);
		if (status == JFileChooser.APPROVE_OPTION)
			readSource(chooser.getSelectedFile());
		else
			JOptionPane.showMessageDialog(null, "Open File Dialog Cancelled");

	} // openFile

	/**
	 * Takes the file and then reads through all the information within and adds the elments into the GUI
	 * Reference from Dr. Lord's lecture #10 Event-Driven Programming
	 *  
	 * 
	 * @param chosenFile = File Chosen By Person using computer
	 */
	private void readSource(File chosenFile) 
	{
		String chosenFileName = chosenFile.getAbsolutePath();
		TextFileInput textFile = new TextFileInput(chosenFileName); //Opens the file and reads the line
		myContentPane = jframe.getContentPane();
		jframe.setLayout(new GridLayout(1,3));
		
		TextArea roman = new TextArea();
		TextArea sortedArabic = new TextArea();
		
		
		
		String currentLine = textFile.readLine();
		//Does a loop to read through each line and process through all the roman numerals.
		while (currentLine != null)
		{
			//Takes the numerals before the comma and adds it to an array for temporary storage
			String[] numerals = currentLine.split(",");  
			for(String word : numerals)
			{
				try 
				{
					RomanNumeral rn = new RomanNumeral(word);
					romanNumerals.put(rn, rn.getArabicNumber()); //Gets the object of the roman numeral and arabic value and inserts it into the treemap.
				}
				catch (IllegalRomanNumeralException ex) 
				{
					System.out.println(ex.getMessage() + " " + word);
				}
			}
				currentLine = textFile.readLine(); 
		} //End of while loop (Ends once currentLine has no values left to read.
		textFile.close(); //Closes the file once it's done reading.
			
		
		/**
		 * Reference from Dr. Lord's lecture #6 on GUI's and Inheritance
		 * Adds the Roman Numerals and Arabic Sorted Numbers to each side of the GUI.
		 */
		for (Entry <RomanNumeral, Integer> me: romanNumerals.entrySet())  //Gets the interface of the treemap and returns the collection of key/value pairs in a for loop.
		{
			roman.append(me.getKey().getRomanNumeral() + "\n"); //Takes the key's roman numeral and adds it to the GUI.
			sortedArabic.append(me.getValue() + "\n"); //Takes the value's arabic number and adds it to the GUI.
		}
		
		myContentPane.add(roman); 
		myContentPane.add(sortedArabic);
		
		jframe.setVisible(true);
	}

	/**
	 * Converts the roman numerals to arabic numbers and is case sensitive. If in the case of 
	 * not being a roman numeral, an illegal argument exception will be thrown. 
	 */
	private void conversion() 
	{
		String input = JOptionPane.showInputDialog(null, "Enter a Roman Numeral");
		if (input != null) 
		{
			try 
			{
				RomanNumeral romanNumeral = new RomanNumeral(input);
				int arabicValue = romanNumeral.getArabicNumber();
				JOptionPane.showMessageDialog(null, "This is your converted number: " + arabicValue);
			} catch (IllegalRomanNumeralException ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage());
				System.out.println(input);
			}
		}
	}
}

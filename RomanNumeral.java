package Project4;

import java.util.HashMap;

public class RomanNumeral implements Comparable <RomanNumeral>
{
	private String romanNumeral;
	private int arabicNumber;
	

	/**
	 * Takes the Roman Numeral Strings and Converts them into integers
	 * @param romanN = The roman Numeral getting converted
	 * @return the converted String into an arabic number.
	 * 
	 * Reference from Dr. Lord's example code given on project 1.
	 */
	public static int valueOf(String romanN) 
	{	
        HashMap<Character, Integer> map = new HashMap<Character, Integer>(); //Hashmap intialization
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
		int len = romanN.length();
		Integer result = map.get(romanN.charAt(len - 1));
		
		if (result == null)
			throw new IllegalRomanNumeralException("Invalid Roman Numeral");
		
        for (int i = len - 2; i >= 0; i--) 
        {
        	Integer first = map.get(romanN.charAt(i));
        	Integer second = map.get(romanN.charAt(i + 1));
        	if (first == null || second == null)
        		throw new IllegalRomanNumeralException("Invalid Roman Numeral");
            if (first >= second)
                result += first;
            else
                result -= first;
        }
        return result;
	}
	
	
	
	/**
	 * Overwrites into a string. 
	 */
	public String toString() 
	{
		return "Roman Numeral " + romanNumeral + " Arabic Number " + arabicNumber + "\n";
	}
	
	/**
	 * Compares the object of the Roman Numeral and sees if it's arabic number value is higher or lower than the selected arabic number. 
	 * 
	 * @param x = The object the roman numeral 
	 * @return Positive or negative number depending on whether the number is deserves to be placed on a higher node or not. 
	 */
	public int compareTo(RomanNumeral x)
	{
		if (x.arabicNumber > this.arabicNumber)
		{
			return -1;
		}
		if (x.arabicNumber < this.arabicNumber)
		{
			return 1;
		}
		return 0;
		
	}
	
	/**
	 * Constructor to set the roman Numeral and convert into arabic number formation
	 * @param r = String that's being converted
	 */
	public RomanNumeral (String r)
	{
		romanNumeral = r;
		arabicNumber = valueOf(r);
	}
	
	/**
	 * //Sets roman numerals and converts it into arabic number formation
	 * @param r = Roman Numeral String that's being converted 
	 */
	public void setRomanN(String r) 
	{
		romanNumeral = r;
		arabicNumber = valueOf(r);
	}
	
	/**
	 * Get's the roman numeral 
	 * @return the Roman Numeral 
	 */
	public String getRomanNumeral()
	{
	      return romanNumeral;
	}
	
	/**
	 * Get's the arabic number conversion
	 * @return the Arabic number conversion
	 */
	public int getArabicNumber() 
	{
	      return arabicNumber;
	}
}



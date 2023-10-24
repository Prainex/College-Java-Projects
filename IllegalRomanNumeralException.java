package Project4;

@SuppressWarnings("serial")
public class IllegalRomanNumeralException extends IllegalArgumentException
{
	/**
	 * Prints out message when catched in the case of an illegalargumentexpcetion
	 * 
	 * @param message = Message that will be printed if in the case of an exception is catched
	 */
	public IllegalRomanNumeralException (String message)
	{
		super (message);
	}
}

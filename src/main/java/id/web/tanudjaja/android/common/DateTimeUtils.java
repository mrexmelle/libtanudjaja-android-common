
package id.web.tanudjaja.android.common;

// Java's imports
import java.text.SimpleDateFormat;
import java.util.Calendar;

// Android's imports

/**
 * A class to ease doing datetime-related operations in Android.
 * @author	Matthew Tanudjaja
 * @since	0.1.0
 */
public final class DateTimeUtils
{
	/**
	 * Private constructor to avoid construction of this class.
	 */
	private DateTimeUtils() {}
	
	/**
	 * Gets the UNIX timestamp of the current time in millisecond.
	 * @since	0.1.0
	 * @return	The UNIX timestamp.
	 */
	public static long getCurrentDateTime()
	{
		return Calendar.getInstance().getTimeInMillis();
	}

	/**
	 * Gets the String representation of the current datetime.
	 * @since	1.1.1
	 * @param	aFormat The format of the datetime.
	 * @return	The String representation of the current datetime.
	 */	
	public static String getCurrentDateTime(String aFormat)
	{
		try
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat(aFormat);
        		return dateFormat.format(Calendar.getInstance().getTime());
		}
		catch(IllegalArgumentException e)
		{
			return "";
		}
	}
};



package id.web.tanudjaja.android.common;

// Java's imports
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * A class that contains encryptor and decryptor of various encryption mechanisms.
 * @author	Matthew Tanudjaja
 * @since	0.1.0
 */
public final class CryptoUtils
{
	/**
	 * Private constructor to avoid construction of this class.
	 */
	private CryptoUtils() {}
	
	/**
	 * Gets an MD5 result of <u>aPlainText</u>.
	 * @since	0.1.1
	 * @param	aPlainText The plain text to be digested.
	 * @throws	NoSuchAlgorithmException The MD5 method is not available at this JRE.
	 * @throws	NullPointerException The <u>aPlainText</u> cannot be inserted to a MessageDigest instance.
	 * @return	The MD5 result.
	 */
	public static String md5L(String aPlainText) throws NoSuchAlgorithmException, NullPointerException
	{
		MessageDigest digest=null;
		
		if(aPlainText==null)
		{
			throw new NullPointerException("aPlainText is null");
		}
		
		// Create MD5 Hash
		try
		{
			digest = MessageDigest.getInstance("MD5");
		}
		catch(NoSuchAlgorithmException e)
		{
			throw e;
		}
		
		// fill digest with aPlainText
		try
		{
			digest.update(aPlainText.getBytes());
		}
		catch(NullPointerException e)
		{
			throw e;
		}
		
		// digest aPlainText
		byte messageDigest[] = digest.digest();

		// Create Hex String
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < messageDigest.length; i++)
		{
			String hex = Integer.toHexString(0xFF & messageDigest[i]);
			if (hex.length() == 1)
			{
				hexString.append('0');
			}
			hexString.append(hex);
		}	

		return hexString.toString();
	}

	/**
	 * Gets an MD5 result of <u>aPlainText</u>.
	 * @since	0.1.0
	 * @param	aPlainText The plain text to be digested.
	 * @return	The MD5 result. If the process fails, null is returned.
	 */	
	public static String md5(String aPlainText)
	{
		try
		{
			return md5L(aPlainText);
		}
		catch(Exception e)
		{
			return null;
		}
	}
};


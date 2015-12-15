
package id.web.tanudjaja.android.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;

/**
 * A class to read the value of meta-data tags from an AndroidManifest.xml.
 * @author	Harisen Ong
 * @since	0.1.0
 */
public class ManifestReader
{
	/**
	 * Reads the value from the meta-data tag.
	 * @since	0.1.0
	 * @param	aContext	The context from which the function can get the package name.
	 * @param	aFullKeyName	The key of the meta-data tag.
	 * @return	The value of the meta-data tag.
	 */
	protected static Object readKey(Context aContext, String aFullKeyName)
	{
		try
		{
			ApplicationInfo appi = aContext.getPackageManager().getApplicationInfo(
				aContext.getPackageName(), PackageManager.GET_META_DATA);
			if(appi==null) { return null; }

			Bundle bundle = appi.metaData;
			if(bundle==null) { return null; }

			Object value = bundle.get(aFullKeyName);
			
			return value;
		}
		catch (NameNotFoundException ex)
		{
			ex.printStackTrace();
		}
		
		return null;
	}

	/**
	 * Reads the value from the meta-data tag and return the value in Object.
	 * @since	0.1.0
	 * @param	aContext	The context from which the function can get the package name.
	 * @param	aFullKeyName	The key of the meta-data tag.
	 * @return	The value of the meta-data tag.
	 */
	public static Object get(Context aContext, String aFullKeyName)
	{
		return readKey(aContext, aFullKeyName);
	}

	/**
	 * Reads the value from the meta-data tag and return the value in String.
	 * @since	0.1.0
	 * @param	aContext	The context from which the function can get the package name.
	 * @param	aFullKeyName	The key of the meta-data tag.
	 * @return	The value of the meta-data tag. If the tag with specified key is not found, it returns false.
	 */
	public static String getString(Context aContext, String aFullKeyName)
	{
		Object o=readKey(aContext, aFullKeyName);
		if(o==null) { return null; }
		return String.valueOf(o);
	}

	/**
	 * Reads the value from the meta-data tag and return the value in Integer.
	 * @since	0.1.0
	 * @param	aContext	The context from which the function can get the package name.
	 * @param	aFullKeyName	The key of the meta-data tag.
	 * @return	The value of the meta-data tag. If the tag with specified key is not found, it returns null.
	 */
	public static Integer getInt(Context aContext, String aFullKeyName)
	{
		String s=getString(aContext, aFullKeyName);
		if(s==null)
		{
			return null;
		}

		try
		{
			Integer i=Integer.valueOf(s);
			return i;
		}
		catch(NumberFormatException e)
		{
			return null;
		}
	}

	/**
	 * Reads the value from the meta-data tag and return the value in boolean.
	 * @since	0.1.0
	 * @param	aContext	The context from which the function can get the package name.
	 * @param	aFullKeyName	The key of the meta-data tag.
	 * @return	The value of the meta-data tag. If the tag with specified key is not found, it returns false.
	 */
	public static boolean getBoolean(Context aContext, String aFullKeyName)
	{
		String s=getString(aContext, aFullKeyName);
		if(s==null)
		{
			return false;
		}

		return Boolean.parseBoolean(s);
	}
};


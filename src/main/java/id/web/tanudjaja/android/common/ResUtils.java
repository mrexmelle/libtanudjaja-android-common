
package id.web.tanudjaja.android.common;

import java.lang.reflect.Field;

/**
 * A class to read the value of meta-data tags from an AndroidManifest.xml.
 * @author	Jaka Tambunan
 * @since	0.2.0
 */
public class ResUtils
{
	private final static String TAG="ResUtils";
	
	private static Class<?> mLayoutClass=null;
	private static Class<?> mDrawableClass=null;
	private static Class<?> mIdClass=null;
	private static Class<?> mColorClass=null;
	private static Class<?> mStringClass=null;
	private static Class<?> mAnimClass=null;
	
	/**
	 * Gets an inner class of a specified class.
	 * @since	0.2.0
	 * @param	aClass		The main class where an inner class is expected to be in.
	 * @param	aInnerClassName	The name of the expected inner class.
	 * @return	The inner class if found, null if not found.
	 */
	protected static Class<?> getClass(Class<?> aClass, String aInnerClassName)
	{
		Class<?> [] innerClasses=aClass.getDeclaredClasses();
		for(Class<?> c : innerClasses)
		{
			if(c.getSimpleName().compareTo(aInnerClassName)==0)
			{
				return c;
			}
		}
		return null;
	}
	
	/**
	 * Gets the resource id with specific parameter.
	 * @since	0.2.0
	 * @param	aResClass	The namespace of main resource package.
	 * @param	aResCollection	The group where the resource belongs (e.g. id, anim, drawable, color, etc).
	 * @param	aResName	The name of the expected resource.
	 * @return	The resource id.
	 */
	protected static int getResourceId(Class<?> aResClass, String aResCollection, String aResName)
	{
		try
		{
			Class<?> soughtClass=getClass(aResClass, aResCollection);
			if(soughtClass==null)
			{
				return 0;
			}
			Field field = soughtClass.getField(aResName);
			return field.getInt(null);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Gets the resource id with specific parameter.
	 * @since	0.2.0
	 * @param	aResClass	The namespace of main resource package plus the resource's group.
	 * @param	aResName	The name of the expected resource.
	 * @return	The resource id.
	 */
	protected static int getResourceId(Class<?> aResClass, String aResName)
	{
		try
		{
			if(aResClass==null)
			{
				return 0;
			}
			Field field = aResClass.getField(aResName);
			return field.getInt(null);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Gets the layout resource id of <u>aResName</u>.
	 * @since	0.2.0
	 * @param	aResClass	The namespace of main resource package.
	 * @param	aResName	The name of the expected layout resource.
	 * @return	The resource id.
	 */
	public static int getLayoutId(Class<?> aResClass, String aResName)
	{
		if(mLayoutClass==null)
		{
			mLayoutClass=getClass(aResClass, "layout");
		}
		
		return getResourceId(mLayoutClass, aResName);
	}
	
	/**
	 * Gets the drawable resource id of <u>aResName</u>.
	 * @since	0.2.0
	 * @param	aResClass	The namespace of main resource package.
	 * @param	aResName	The name of the expected drawable resource.
	 * @return	The resource id.
	 */
	public static int getDrawableId(Class<?> aResClass, String aResName)
	{
		if(mDrawableClass==null)
		{
			mDrawableClass=getClass(aResClass, "drawable");
		}
		
		return getResourceId(mDrawableClass, aResName);
	}
	
	/**
	 * Gets the id resource id of <u>aResName</u>.
	 * @since	0.2.0
	 * @param	aResClass	The namespace of main resource package.
	 * @param	aResName	The name of the expected id resource.
	 * @return	The resource id.
	 */
	public static int getId(Class<?> aResClass, String aResName)
	{
		if(mIdClass==null)
		{
			mIdClass=getClass(aResClass, "id");
		}
		
		return getResourceId(mIdClass, aResName);
	}
	
	/**
	 * Gets the color resource id of <u>aResName</u>.
	 * @since	0.2.0
	 * @param	aResClass	The namespace of main resource package.
	 * @param	aResName	The name of the expected color resource.
	 * @return	The resource id.
	 */
	public static int getColorId(Class<?> aResClass, String aResName)
	{
		if(mColorClass==null)
		{
			mColorClass=getClass(aResClass, "color");
		}
		
		return getResourceId(mColorClass, aResName);
	}
	
	/**
	 * Gets the string resource id of <u>aResName</u>.
	 * @since	0.2.0
	 * @param	aResClass	The namespace of main resource package.
	 * @param	aResName	The name of the expected string resource.
	 * @return	The resource id.
	 */
	public static int getStringId(Class<?> aResClass, String aResName)
	{
		if(mStringClass==null)
		{
			mStringClass=getClass(aResClass, "string");
		}
		
		return getResourceId(mStringClass, aResName);
	}

	/**
	 * Gets the anim resource id of <u>aResName</u>.
	 * @since	1.0.0
	 * @param	aResClass	The namespace of main resource package.
	 * @param	aResName	The name of the expected anim resource.
	 * @return	The resource id.
	 */
	public static int getAnimId(Class<?> aResClass, String aResName)
	{
		if(mAnimClass==null)
		{
			mAnimClass=getClass(aResClass, "anim");
		}
		
		return getResourceId(mAnimClass, aResName);
	}	
};


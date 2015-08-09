
package id.web.tanudjaja.android.common;

// Java's imports
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

// Android's imports
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.graphics.Point;
import android.provider.Settings.Secure;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * A namespace that helps developers to do common application-specific operations in Android development.
 * @author	Matthew Tanudjaja
 * @since	0.1.0
 */
public final class AppUtils
{
	@SuppressWarnings("unused")
	private final static String TAG="AppUtils";
	
	/**
	 * Private constructor to avoid construction of this class.
	 */
	private AppUtils() {}
	
	// guarantee the request is executed once
	private static String mPackageName=null;
	private static String mVersionName;
	private static int mVersionCode=-1;
	
	/**
	 * Gets device's Android ID.
	 * @since	0.1.0
	 * @param	aContext The context from which the ContentResolver is retrieved to read the Android ID.
	 * @return	The Android ID.
	 */
	public static String getAndroidId(Context aContext)
	{
		return Secure.getString(
			aContext.getContentResolver(),
			android.provider.Settings.Secure.ANDROID_ID);
	}
	
	/**
	 * Gets device's model.
	 * @since	0.1.0
	 * @return	The model. This is exactly the value of android.os.Build.MODEL
	 */
	public static String getDeviceModel()
	{
		return android.os.Build.MODEL;
	}
	
	/**
	 * Gets device's OS version.
	 * @since	0.1.0
	 * @return	The OS version. This is exactly the value of android.os.Build.VERSION.SDK_INT
	 */
	public static int getOsVersion()
	{
		return android.os.Build.VERSION.SDK_INT;
	}
	
	/**
	 * Gets application's package name.
	 * @since	0.1.0
	 * @param	aContext The context from which the package name is retrieved.
	 * @return	The package name.
	 */
	public static String getPackageName(Context aContext)
	{
		if(mPackageName==null)
		{
			mPackageName=aContext.getPackageName();
		}
		return mPackageName;
	}
	
	/**
	 * Gets application's version code.
	 * @since	0.1.0
	 * @param	aContext The context from which the package manager is retrieved to get the version code.
	 * @return	The version code or -1 if package manager is not retrievable.
	 */
	public static int getVersionCode(Context aContext)
	{
		if(mVersionCode==-1)
		{
			try
			{
				PackageInfo info=aContext.getPackageManager().getPackageInfo(aContext.getPackageName(), 0);
				if(info!=null)
				{
					mVersionCode=info.versionCode;
				}
			}
			catch (NameNotFoundException e)
			{
				mVersionCode=-1;
			}
		}
		return mVersionCode;
	}
	
		/**
	 * Gets application's version code.
	 * @since	1.1.1
	 * @param	aContext The context from which the package manager is retrieved to get the version code.
	 * @return	The version code or -1 if package manager is not retrievable.
	 */
	public static String getVersionName(Context aContext)
	{
		if(mVersionName == null)
		{
			try
			{
				PackageInfo pInfo = aContext.getPackageManager().getPackageInfo(aContext.getPackageName(), 0);
				PackageInfo info=aContext.getPackageManager().getPackageInfo(aContext.getPackageName(), 0);
				if(info!=null)
				{
					mVersionName = pInfo.versionName;
				}
			}
			catch (NameNotFoundException e)
			{
				mVersionName=null;
			}
		}
		return mVersionName;
	}
	
	
	/**
	 * Gets device's display resolution.
	 * @since	0.1.0
	 * @param	aContext The context from which the system service is retrieved to get the window's information.
	 * @return	The struct of Point with x attribute contains the width and y attribute contains the height.
	 */
	public static Point getDisplayResolution(Context aContext)
	{
		WindowManager wm=(WindowManager)(aContext.getSystemService(
			Context.WINDOW_SERVICE));
		Point p=new Point();
		wm.getDefaultDisplay().getSize(p);
		return p;
	}
	
	/**
	 * Gets device's display resolution.
	 * @since	0.1.0
	 * @param	aActivity The activity from which the window's information is retrieved.
	 * @return	The struct of Point with x attribute contains the width and y attribute contains the height.
	 */
	public static Point getDisplayResolution(Activity aActivity)
	{
		Point p=new Point();
		aActivity.getWindowManager().getDefaultDisplay().getSize(p);
		return p;
	}
	
	/**
	 * Gets device's display density.
	 * @since	0.1.0
	 * @param	aContext The context from which the display metrics information is retrieved.
	 * @return	The density in String or an empty String if display metrics is not retrievable.
	 */
	public static String getScreenDpi(Context aContext)
	{
		DisplayMetrics metrics = aContext.getResources().getDisplayMetrics();
		switch (metrics.densityDpi)
		{
			case DisplayMetrics.DENSITY_LOW:
				return "ldpi";
			case DisplayMetrics.DENSITY_MEDIUM:
				return "mdpi";
			case DisplayMetrics.DENSITY_HIGH:
				return "hdpi";
			case DisplayMetrics.DENSITY_XHIGH:
				return "xhdpi";
			case DisplayMetrics.DENSITY_XXHIGH:
				return "xxhdpi";
			default:
				return "";
		}
	}
	
	/**
	 * Gets the key hash of application package's certificate signature.
	 * @since	0.1.1
	 * @param	aContext The context from which the package manager is retrieved to get the signature's information.
	 * @return	The list of signatures embedded to the application package.
	 */
	public static List<String> getKeyHash(Context aContext)
	{
	    try
	    {
	        PackageInfo info = aContext.getPackageManager().getPackageInfo(
	                getPackageName(aContext), 
	                PackageManager.GET_SIGNATURES);
	  
	        List<String> keyHashList=new ArrayList<String>(info.signatures.length);
	        
	        for (Signature signature : info.signatures)
	        {
	            MessageDigest md = MessageDigest.getInstance("SHA");
	            md.update(signature.toByteArray());
	            keyHashList.add(Base64.encodeToString(md.digest(), Base64.DEFAULT));
	        }
	        return keyHashList;
	    }
	    catch(Exception e)
	    {
	        return null;
	    }
	}
};


package id.web.tanudjaja.android.common;

// Java's imports
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.Map;

// Android's imports
import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * A class to ease doing network-related operations in Android.
 * @author	Matthew Tanudjaja
 * @since	0.1.0
 */
public final class NetUtils
{
	private static final String TAG="NetUtils";	
	
	/**
	 * Private constructor to avoid construction of this class.
	 */
	private NetUtils() {}
	
	/**
	 * Opens connection to specified <u>aUrl</u>.
	 * @since	0.1.0
	 * @param	aUrl The URL to which a connection is established.
	 * @throws	MalformedURLException The specified <u>aUrl</u> is invalid.
	 * @throws	IOException Cannot establish connection to the specified <u>aUrl</u>.
	 * @return	URLConnection A URLConnection class that stores information about the connection.
	 */
	public static URLConnection openConnectionL(String aUrl)
		throws MalformedURLException, IOException
	{
		// initiate URL
		URL url=null;
		try
		{
			url=new URL(aUrl);
		}
		catch (MalformedURLException e)
		{
			throw e;
		}
		
		// open the connection
		try
		{
			return url.openConnection();
		}
		catch (IOException e)
		{
			throw e;
		}
	}
	
	/**
	 * Adds header fields to <u>aConnection</u>.
	 * @since	0.1.0
	 * @param	aConnection The connection to which the header fields are appended.
	 * @param	aHeaderFields A map of header fields to be appended.
	 * @return	URLConnection A pointer to aConnection.
	 */
	public static URLConnection addHeaderFields(URLConnection aConnection, Map<String, String> aHeaderFields)
	{
		URLConnection con=aConnection;
		
		if (aHeaderFields != null)
		{
			for (Map.Entry<String, String> field : aHeaderFields.entrySet())
			{
				con.setRequestProperty(field.getKey(), field.getValue());
			}
		}
		
		return con;
	}
	
	/**
	 * A class that holds the MCC and MNC information.
	 * @author	Matthew Tanudjaja
	 * @since	0.1.0
	 */
	public static class SMccMnc
	{
		public String iMcc;
		public String iMnc;
		
		public SMccMnc()
		{
			iMcc="";
			iMnc="";
		}
		
		public SMccMnc(String aMcc, String aMnc)
		{
			iMcc=aMcc;
			iMnc=aMnc;
		}
	};
	
	/**
	 * Gets the MCC and MNC of the current network.
	 * @since	0.1.0
	 * @param	aContext The context to get a telephony system service.
	 * @return	An object that holds MCC and MNC information.
	 */
	public static SMccMnc getNetworkMccMnc(Context aContext)
	{
		TelephonyManager tel=(TelephonyManager)(aContext.getSystemService(Context.TELEPHONY_SERVICE));
		String networkOp=tel.getNetworkOperator();
		
		if(networkOp==null) { return null; }
		
		// validate mcc existence
		if(networkOp.length()<3) { return null; }
		
		// build SMccMnc object
		SMccMnc info=new SMccMnc();
		
		// get mcc
		info.iMcc=new String(networkOp.substring(0,3));
		
		// validate mnc existence
		if(networkOp.length()>=5)
		{
			// get mnc
			info.iMnc=new String(networkOp.substring(3));
		}
		
		return info;
	}
	
	/**
	 * Encode an URL to comply to standardized UTF-8 URL.
	 * @since	0.1.1
	 * @param	aPlainText The URL to be encoded.
	 * @return	The encoded URL.
	 */
	public static String encodeUrlUtf8(String aPlainText)
	{
		try
		{
			return URLEncoder.encode(aPlainText, "UTF-8");
		}
		catch(UnsupportedEncodingException e)
		{
			return aPlainText;
		}
	}
	
	/**
	 * Gets the phone number stored in the SIM card's ROM. Returns empty string if not available.
	 * @since	0.2.1
	 * @param	aContext The context to get a telephony system service.
	 * @return	The phone number.
	 */
	public static String getPhoneNumber(Context aContext)
	{
		TelephonyManager tm=(TelephonyManager)(aContext.getSystemService(Context.TELEPHONY_SERVICE));
		if(tm==null)
		{
			return "";
		}
		
		String phoneNo=tm.getLine1Number();
		if(phoneNo==null)
		{
			return "";
		}

		return phoneNo;
	}
	
	/**
	 * Gets the IP Address of the machine in the currently connected network.
	 * @since	0.1.1
	 * @return	The IP Address.
	 */
	public static String getIpAddress()
	{
		try
		{
			for(Enumeration<NetworkInterface> i = NetworkInterface.getNetworkInterfaces(); i.hasMoreElements();)
			{
				NetworkInterface nif=i.nextElement();
				for(Enumeration<InetAddress> j = nif.getInetAddresses(); j.hasMoreElements();)
				{
					InetAddress iad=j.nextElement();
					if(iad.isLoopbackAddress()==false)
					{
						return iad.getHostAddress().toString();
					}
				}
			}
			return "";
		}
		catch(SocketException e)
		{
			return "";
		}
	}
};

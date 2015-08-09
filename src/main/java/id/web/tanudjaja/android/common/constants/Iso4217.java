
package id.web.tanudjaja.android.common.constants;

/**
 * A namespace for world currencies based on ISO 4217.
 * @author	Matthew Tanudjaja
 * @since	0.1.1
 */
public final class Iso4217
{
	/**
	 * Private constructor to avoid construction of this class.
	 */
	private Iso4217() {}
	
	/**
	 * A namespace for world currencies in numeric form.
	 * @author	Matthew Tanudjaja
	 * @since	0.1.1
	 */
	public final static class Numeric
	{
		/**
		 * Private constructor to avoid construction of this class.
		 */
		private Numeric() {}
		
		public final static short AUD=36;
		public final static short BND=96;
		public final static short MMK=104;
		public final static short KHR=116;
		public final static short IDR=360;
		public final static short LAK=418;
		public final static short MYR=458;
		public final static short PGK=598;
		public final static short PHP=608;
		public final static short SGD=702;
		public final static short VND=714;
		public final static short THB=764;
		public final static short USD=840;
	};
	
	/**
	 * A namespace for world currencies in alphabetic form.
	 * @author	Matthew Tanudjaja
	 * @since	0.1.1
	 */
	public final static class Alphabetic
	{
		/**
		 * Private constructor to avoid construction of this class.
		 */
		private Alphabetic() {}
		
		public final static String AUD="AUD";
		public final static String BND="BND";
		public final static String MMK="MMK";
		public final static String KHR="KHR";
		public final static String IDR="IDR";
		public final static String LAK="LAK";
		public final static String MYR="MYR";
		public final static String PGK="PGK";
		public final static String PHP="PHP";
		public final static String SGD="SGD";
		public final static String VND="VND";
		public final static String THB="THB";
		public final static String USD="USD";
	};
};


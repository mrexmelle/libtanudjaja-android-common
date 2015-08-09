
package id.web.tanudjaja.android.common.constants;

/**
 * A namespace for country codes based on ISO 3166-1.
 * @author	Matthew Tanudjaja
 * @since	0.1.1
 */
public final class Iso3166
{
	/**
	 * Private constructor to avoid construction of this class.
	 */
	private Iso3166() {}
	
	/**
	 * A namespace for country codes in numeric form.
	 * @author	Matthew Tanudjaja
	 * @since	0.1.1
	 */
	public final static class Numeric
	{
		/**
		 * Private constructor to avoid construction of this class.
		 */
		private Numeric() {}
		
		public final static short BRUNEI=96;
		public final static short MYANMAR=104;
		public final static short CAMBODIA=116;
		public final static short CHRISTMAS_ISLAND=162;
		public final static short COCOS_ISLANDS=166;
		public final static short INDONESIA=360;
		public final static short LAOS=418;
		public final static short MALAYSIA=458;
		public final static short PAPUA_NEW_GUINEA=598;
		public final static short PHILLIPPINES=608;
		public final static short EAST_TIMOR=626;
		public final static short SINGAPORE=702;
		public final static short VIETNAM=714;
		public final static short THAILAND=764;
	};
	
	/**
	 * A namespace for country codes in alphabetic form.
	 * @author	Matthew Tanudjaja
	 * @since	0.1.1
	 */
	public final static class Alphabetic
	{
		/**
		 * Private constructor to avoid construction of this class.
		 */
		private Alphabetic() {}
		
		public final static String BRUNEI="BRN";
		public final static String MYANMAR="MMR";
		public final static String CAMBODIA="KHM";
		public final static String CHRISTMAS_ISLAND="CXR";
		public final static String COCOS_ISLANDS="CCK";
		public final static String INDONESIA="IDN";
		public final static String LAOS="LAO";
		public final static String MALAYSIA="MYS";
		public final static String PAPUA_NEW_GUINEA="PNG";
		public final static String PHILLIPPINES="PHL";
		public final static String EAST_TIMOR="TMP";
		public final static String SINGAPORE="SGP";
		public final static String VIETNAM="VNM";
		public final static String THAILAND="THA";
	};		
};


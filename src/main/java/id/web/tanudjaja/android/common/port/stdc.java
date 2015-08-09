
package id.web.tanudjaja.android.common.port;

/**
 * A namespace for Standard C functions.
 * @author	Matthew Tanudjaja
 * @since	0.1.0
 */
public final class stdc
{
	/**
	 * Private constructor to avoid construction of this class.
	 */
	private stdc() {}
	
	/**
	 * Fills the first <u>n</u> bytes of the memory area pointed to by <u>s</u> with the constant byte <u>c</u>.
	 * This function conforms to C99.
	 * @param	s	The destination byte array.
	 * @param	c	The value to be set.
	 * @param	n	The length of the setting operation from index 0 of array <b>s</b>.
	 * @return	A pointer to the memory area <u>s</u>.
	 * @since	0.1.0
	 */
	public static byte[] memset(byte[] s, int c, int n)
	{
		int i;
		for (i = 0; i < n; i++)
		{
			s[i] = (byte) (c);
		}
		return s;
	}

	/**
	 * Fills the array of <u>n</u> wide-characters starting at <u>wcs</u> with <u>n</u> copies of the wide character <u>wc</u>.
	 * This function conforms to C99.
	 * @param	wcs	The destination byte array.
	 * @param	wc	The value to be set.
	 * @param	n	The length of the setting operation from index 0 of array <b>s</b>.
	 * @return	A pointer to the memory area <u>s</u>.
	 * @since	0.1.1
	 */
	public static char[] wmemset(char[] wcs, int wc, int n)
	{
		int i;
		for (i = 0; i < n; i++)
		{
			wcs[i] = (char) (wc);
		}
		return wcs;
	}

	/**
	 * Copies <u>n</u> bytes from memory area <u>src</u> to memory area <u>dest</u>. The memory areas must not overlap.
	 * The programmer must ensure that there is room for at least <u>n</u> bytes at <u>dest</u>.
	 * This function conforms to SVr4, 4.3BSD, C89, C99, POSIX.1-2001.
	 * @param	dest	The destination byte array.
	 * @param	src	The source byte array.
	 * @param	n	The length of the setting operation from index 0 of array <b>s</b>.
	 * @return	A pointer to <u>dest</u>.
	 * @since	0.1.0
	 */
	public static byte[] memcpy(byte[] dest, byte[] src, int n)
	{
		int i;
		for (i = 0; i < n; i++)
		{
			dest[i] = src[i];
		}
		return dest;
	}

	/**
	 * Copies <u>n</u> wide characters from the array starting at <u>src</u> to the array starting at <u>dest</u>. The memory areas must not overlap.
	 * The programmer must ensure that there is room for at least <u>n</u> wide characters at <u>dest</u>.
	 * This function conforms to C99.
	 * @param	dest	The destination byte array.
	 * @param	src	The source byte array.
	 * @param	n	The length of the setting operation from index 0 of array <b>s</b>.
	 * @return	A pointer to <u>dest</u>.
	 * @since	0.1.1
	 */
	public static char[] wmemcpy(char[] dest, char[] src, int n)
	{
		int i;
		for (i = 0; i < n; i++)
		{
			dest[i] = src[i];
		}
		return dest;
	}
};


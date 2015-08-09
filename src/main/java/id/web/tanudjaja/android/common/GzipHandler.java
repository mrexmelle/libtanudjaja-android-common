
package id.web.tanudjaja.android.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import id.web.tanudjaja.android.common.port.stdc;

/**
 * A class to handle the compression and decompression using gzip algorithm.
 * @author	Matthew Tanudjaja
 * @since	1.1.0
 */
public class GzipHandler
{
	/**
	 * This function compresses the given plain bytes into compressed bytes.
	 * @since	1.1.0
	 * @param	aBytes The plain bytes.
	 * @return	The compressed bytes.
	*/
	public static byte[] compress(byte[] aBytes)
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		// initialize gzip compression engine
		GZIPOutputStream gzout = null;
		try
		{
			gzout = new GZIPOutputStream(baos);
		}
		catch (IOException e)
		{
			return null;
		}

		// try to write the aBytes to gz output stream
		try
		{
			gzout.write(aBytes);
		}
		catch (IOException e)
		{
			try
			{
				gzout.close();
			}
			catch (IOException ioe)
			{
			}
			return null;
		}

		// close and finalize compression
		try
		{
			gzout.close();
		}
		catch (IOException ioe)
		{
			return null;
		}

		// return the compressed bytes
		return baos.toByteArray();
	}

	/**
	 * This function decompresses the given compressed bytes back into its plain bytes.
	 * @since	1.1.0
	 * @param	aBytes The compressed bytes.
	 * @return	The plain bytes.
	*/
	public static byte[] decompress(byte[] aBytes)
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ByteArrayInputStream bais = new ByteArrayInputStream(aBytes);
		byte[] b = new byte[256];

		// initialize gzip decompression engine
		GZIPInputStream gzin = null;
		try
		{
			gzin = new GZIPInputStream(bais);
		}
		catch (IOException e)
		{
			return null;
		}

		// try to read the from gz input stream
		int bytesRead = 0;
		while (true)
		{
			b = stdc.memset(b, 0x0, b.length);
			try
			{
				bytesRead = gzin.read(b);
			}
			catch (IOException e)
			{
				bytesRead = -1;
			}

			// write the reading result to baos
			if (bytesRead > 0)
			{
				baos.write(b, 0, bytesRead);
			}
			else
			{
				break;
			}
		}

		// close and finalize decompression
		try
		{
			gzin.close();
		}
		catch (IOException ioe)
		{
			return null;
		}

		// return the decompressed bytes
		return baos.toByteArray();
	}
};


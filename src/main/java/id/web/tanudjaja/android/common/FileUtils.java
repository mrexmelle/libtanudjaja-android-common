
package id.web.tanudjaja.android.common;

// Java's imports
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

// Android's imports
import android.content.Context;
import android.util.Log;

import id.web.tanudjaja.android.common.port.stdc;

/**
 * A class that contains various file operation mechanisms.
 * @author	Matthew Tanudjaja
 * @since	1.1.0
 */
public final class FileUtils
{
	private final static String TAG="FileUtils";

	/**
	 * Private constructor to avoid construction of this class.
	 */
	private FileUtils() {}
	
	/**
	 * Save <u>aText</u> into <u>aFilename</u>.
	 * @since	1.1.0
	 * @param	aContext The context from which the file handler is to be opened.
	 * @param	aFilename The filename where the text is to be saved.
	 * @param	aText The text to be written.
	 * @param	aAppend if set to true, the <u>aText</u> will be appended to <u>aFilename</u> if it exists. If <u>aFilename</u>, a new file will be created.
	 * throw	FileNotFoundException, IOException.
	 */
	public static void saveToInternalStorage(Context aContext, String aFilename, String aText, boolean aAppend)
		throws IOException
	{
		FileOutputStream fos=null;
		try
		{
			// determine the flags
			int flags=Context.MODE_PRIVATE;
			if(aAppend) { flags |= Context.MODE_APPEND; }

			fos = aContext.openFileOutput(aFilename, flags);
			fos.write(aText.getBytes("UTF-8"));
			fos.close();
		}
		catch(Exception e)
		{
			try
			{
				if (fos != null)
				{
					fos.close();
				}
			}
			catch(IOException e1)
			{
			}
			throw e;
		}
	}

	/**
	 * Read the content in <u>aFilename</u>.
	 * @since	1.1.0
	 * @param	aContext The context from which the file handler is to be opened.
	 * @param	aFilename The filename where the text is to be read from.
	 * @return	The content of the file.
	 */	
	public static String loadFromInternalStorage(Context aContext, String aFilename)
		throws IOException
	{
		FileInputStream fis=null;
		try
		{
		    fis=aContext.openFileInput(aFilename);
		    byte [] buffer=new byte[256];
		    String readJson="";
		    int bytesRead=0;
		    while(true)
		    {
				stdc.memset(buffer, 0x0, buffer.length);
				int singleRead=fis.read(buffer, 0, buffer.length-1);
				if(singleRead==-1)
				{
					break;
				}
				bytesRead+=singleRead;
				readJson+=new String(buffer, 0, singleRead);
		    }
		    return readJson;
		}
		catch(Exception e)
		{
		    try
		    {
				if (fis != null)
				{
					fis.close();
				}
		    }
		    catch(IOException e1)
		    {
		    }
		    throw e;
		}
	}

	/**
	 * Delete file <u>aFilename</u> from internal storage.
	 * @since	1.1.0
	 * @param	aContext The context from which the file handler is to be opened.
	 * @param	aFilename The filename to be deleted.
	 */
	public static void deleteFromInternalStorage(Context aContext, String aFilename)
	{
		aContext.deleteFile(aFilename);
	}


	/**
	 * Rename a file from <u>aFrom</u> to <u>aTo</u>.
	 * @since	1.1.2
	 * @param	aContext The context from which the file handler is to be opened.
	 * @param	aFrom The original filename.
	 * @param	aFrom The destination filename.
	 */
	public static void renameFileInInternalStorage(Context aContext, String aFrom, String aTo)
	{
		File from=new File(aContext.getFilesDir(), aFrom);
		File to=new File(aContext.getFilesDir(), aTo);
		from.renameTo(to);
	}

	/**
	 * Create a filter for file name in a directory with pattern as defined in <u>aRegex</u>.
	 * @since	1.1.2
	 * @param	aRegex The pattern of the files.
	 * @return	The FilenameFilter instance to be passed when calling File::listFiles().
	 */
	public static FilenameFilter createFilter(final String aRegex)
	{
		return new FilenameFilter()
        	{
			@Override
			public boolean accept(File dir, String name)
			{
				Log.d(TAG, "FilenameFilter::accept - name: " + name);
				Log.d(TAG, "FilenameFilter::accept - regex: " + aRegex);
				if(name.matches(aRegex))
				{
					Log.d(TAG, "matching");
				}
				else
				{
					Log.d(TAG, "not matching");
				}

				return name.matches(aRegex);
			}
        	};
	}

	/**
	 * Get the name of the files matching <u>aRegex</u> in internal storage.
	 * @since	1.1.2
	 * @param	aContext The context from which the file handler is to be opened.
	 * @param	aRegex The pattern of the files.
	 * @param	aSorter The mechanism to sort the file. NULL if not required.
	 * @return	The list of filenames matching the pattern.
	 */
	public static File [] filterFilesInInternalStorage(Context aContext, String aRegex, Comparator<File> aSorter)
	{
		Log.d(TAG, "FilterFiles - start");

		File dir = new File(aContext.getFilesDir().toString());

	        File [] files = dir.listFiles(createFilter(aRegex));
	
		for(int i=0; i<files.length; i++)
		{
			Log.d(TAG, "FilterFiles - fileList: " + files[i]);
		}

		if(aSorter!=null)
		{
			Arrays.sort(files, aSorter);
		}

		return files;
	}

	/**
	 * Check whether <u>aFilename</u> is exist or not. Warning: This operation should not precede the call to open <u>aFilename</u>
	 * as overhead may be occured.
	 * @since	1.1.2
	 * @param	aContext The context from which the file handler is to be opened.
	 * @param	aFilename The filename to be deleted.
	 */
	public static boolean isExistInInternalStorage(Context aContext, String aFilename)
	{
		File f=new File(aContext.getFilesDir(), aFilename);
		return f.exists();
	}

	/**
	 * Count the size of <u>aFilename</u> in bytes
	 * @since	1.1.2
	 * @param	aContext The context from which the file handler is to be opened.
	 * @param	aFilename The filename whose length is to be retrieved.
	 */
	public static long getFileSizeInInternalStorage(Context aContext, String aFilename)
	{
		File f=new File(aContext.getFilesDir(), aFilename);
		return f.length();
	}
};



package id.web.tanudjaja.android.common;

// Android's imports
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * A class to ease doing database operations in Android.
 * @author	Matthew Tanudjaja
 * @since	0.1.0
 */
public final class DbUtils
{
	/**
	 * Private constructor to avoid construction of this class.
	 */
	private DbUtils() {}

	/**
	 * Drops all existing tables in an sqlite3 database file.
	 * @since	0.1.0
	 * @param	aDb An sqlite3 database whose tables are to be dropped.
	 * @throws	NullPointerException The operation fails to find a valid sqlite_master table.
	 */
	public static void dropAllTables(SQLiteDatabase aDb)
		throws NullPointerException
	{
		// query the sqlite_master table
		Cursor cursor = aDb.query(true, "sqlite_master",
				new String[] { "name" },
				"type=\'table\' AND name<>\'android_metadata\'", null, null,
				null, null, null);

		// cannot find valid sqlite_master table
		if (cursor == null)
		{
			throw new NullPointerException("no valid sqlite_master table found");
		}

		// below conditional statement indicates there is at least one table in
		// the database file
		if (cursor.moveToFirst())
		{
			int i;
			for (i = 0; i < cursor.getCount(); i++)
			{
				String dropSql = String.format("DROP TABLE IF EXISTS %s;",
						cursor.getString(cursor.getColumnIndex("name")));
				aDb.execSQL(dropSql);
				cursor.moveToNext();
			}
		}

		// close cursor
		cursor.close();
	}
};

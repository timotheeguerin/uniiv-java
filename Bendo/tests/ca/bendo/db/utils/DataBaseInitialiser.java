/**
 * 
 */
package ca.bendo.db.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ca.bendo.databasesync.ConnectionData;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>Data</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public final class DataBaseInitialiser
{
	/**
	 * 
	 */
	public static final String FILES_PATH = "tests/ca/bendo/db/files/";
	/**
	 * List having all the filenames.
	 */
	private static List<String> files = new ArrayList<String>();

	/**
	 * Database connection.
	 */
	private static Connection connection;

	/**
	 * Initialise data.
	 * 
	 * @param filename
	 *            Name of the file having all the element to insert.
	 * @throws SQLException 
	 */
	public static void init(final String filename) throws SQLException
	{
		initConnection();
		files.add(filename);
		FileData fileData = new FileData(FILES_PATH + filename);
		fileData.load();
		fileData.insert(connection);

	}

	/**
	 * Clear the data in the database specified in the file.
	 * 
	 * @param filename
	 *            Name of the file.
	 */
	public static void clear(final String filename)
	{
		files.remove(filename);
	}

	/**
	 * Clear all the data that has been added.
	 */
	public static void clearAll()
	{
		for (String filename : files)
		{
			clear(filename);
		}
	}

	/**
	 * Initialise the connection to the database if not done already.
	 */
	public static void initConnection()
	{
		if (connection == null)
		{
			ConnectionData connectionData = new ConnectionData();
			connectionData.setUrl("jdbc:mysql://localhost:3306/bendo_dev");
			connectionData.setUser("root");
			connectionData.setPassword("madremia350");

			try
			{
				connection = connectionData.getConnection();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

	/**
	 * Prevent instantiation.
	 */
	private DataBaseInitialiser()
	{

	}

}

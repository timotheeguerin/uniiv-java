/**
 * 
 */
package ca.bendo.db.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>DatabaseRow</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class TableRow
{
	/**
	 * 
	 */
	private String tableName;

	/**
	 * 
	 */
	private Map<String, String> values = new HashMap<String, String>();

	/**
	 * @return the tableName
	 */
	public String getTableName()
	{
		return tableName;
	}

	/**
	 * @param tableName
	 *            the tableName to set
	 */
	public void setTableName(final String tableName)
	{
		this.tableName = tableName;
	}

	/**
	 * @return the values
	 */
	public Map<String, String> getValues()
	{
		return values;
	}

	/**
	 * @param values
	 *            the values to set
	 */
	public void setValues(final Map<String, String> values)
	{
		this.values = values;
	}

	/**
	 * @param key
	 *            the key of the value to set
	 * @param value
	 *            the value to set
	 */
	public void addValue(final String key, final String value)
	{
		this.values.put(key, value);
	}

	/**
	 * Insert the row data in the database.
	 * 
	 * @param connection
	 *            Conection to the database
	 * @throws SQLException
	 *             Exception SQL
	 */
	public void insert(final Connection connection) throws SQLException
	{
		StringBuffer insertSql = new StringBuffer();
		StringBuffer valueSql = new StringBuffer();

		PreparedStatement prepStatement = null;

		insertSql.append("INSERT INTO ");
		insertSql.append(tableName);
		insertSql.append("(");

		boolean first = true;
		for (Entry<String, String> entry : values.entrySet())
		{

			if (!first)
			{
				insertSql.append(",");
				valueSql.append(",");
			} else
			{
				first = false;
			}

			insertSql.append(escape(entry.getKey()));
			valueSql.append("?");

		}

		insertSql.append(") VALUES (");
		insertSql.append(valueSql);
		insertSql.append(")");
		
		prepStatement = connection.prepareStatement(insertSql.toString());

		int i = 1;
		for (Entry<String, String> entry : values.entrySet())
		{
			prepStatement.setString(i, entry.getValue());
			i++;
		}

		// prepStatement.execute();

		System.out.println("Prep: " + prepStatement.toString());

	}

	/**
	 * Remove the fileData of the database.
	 * 
	 * @param connection
	 *            Conection to the database
	 */
	public void delete(final Connection connection)
	{

	}

	/**
	 * Escape a string by adding ' ` ' around.
	 * 
	 * @param str
	 *            String to escape
	 * @return The escaped string.
	 */
	private static String escape(final String str)
	{
		return "`" + str + "`";
	}

}

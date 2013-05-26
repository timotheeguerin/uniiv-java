/**
 * 
 */
package ca.bendo.db.dao;


/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>SqlGenerator</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public final class SqlGenerator
{

	/**
	 * Prevent instantiation.
	 */
	private SqlGenerator()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * Return the sql statement needed to delete an element from the table
	 * given.
	 * 
	 * @param tableName
	 *            Table containing element
	 * @return SQL statement.
	 */
	public static String selectAllFrom(final String tableName)
	{
		return "SELECT * FROM " + escape(tableName);
	}

	/**
	 * Return the sql statement needed to delete an element from the table
	 * given.
	 * 
	 * @param tableName
	 *            Table containing element
	 * @return SQL statement.
	 */
	public static String deleteFrom(final String tableName)
	{
		return "DELETE FROM " + escape(tableName) + "WHERE id_" + tableName + "= ?";
	}

	
	/**
	 * @param tableName Table containg element
	 * @return SQL statement select element with id given
	 */
	public static String selectFrom(final String tableName)
	{
		return "SELECT * FROM " + escape(tableName) + "WHERE id_" + tableName + "= ?";
	}
	/**
	 * 
	 * @param tableName
	 *            Table to get the is column from.
	 * @return Return the column id name which must be of the form
	 *         id_[tablename]
	 */
	public static String getColumnId(final String tableName)
	{
		return "id_" + tableName;
	}

	/**
	 * 
	 * @param str
	 *            String to escape
	 * @return Add ` around the string
	 */
	public static String escape(final String str)
	{
		if (!(str.startsWith("`") && str.endsWith("`")))
		{
			return "`" + str + "`";
		} else
		{
			return str;
		}
	}

	
}

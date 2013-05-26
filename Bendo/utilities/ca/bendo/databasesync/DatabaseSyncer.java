/**
 * 
 */
package ca.bendo.databasesync;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>DatabaseSyncer</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class DatabaseSyncer 
{

	/**
	 * 
	 */
	private static final int MAX_VARCHAR_LENGTH = 10000;
	/**
	 * Connection to the source database.
	 */
	private Connection source;

	/**
	 * Connection to the target database.
	 */
	private Connection target;

	/**
	 * Main function.
	 * 
	 * @param args
	 *            Args send
	 */
	public static void main(final String[] args)
	{

		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// autre: bendodev.no-ip.org
		// local: 192.168.2.27
		ConnectionData sourceData = new ConnectionData();
		int reply = JOptionPane.showConfirmDialog(null, "Tim palace?");
		String sourceUrl = "";
		if (reply == JOptionPane.YES_OPTION)
		{
			sourceUrl = "jdbc:mysql://192.168.2.27:3306/bendo_dev";
		} else
		{
			sourceUrl = "jdbc:mysql://bendodev.no-ip.org:3306/bendo_dev";
		}
		sourceData.setUrl(sourceUrl);
		sourceData.setUser("root");
		sourceData.setPassword("madremia350");

		ConnectionData targetData = new ConnectionData();
		targetData.setUrl("jdbc:mysql://localhost:3306/bendo_dev");
		targetData.setUser("root");
		targetData.setPassword("madremia350");

		DatabaseSyncer dataBaseSyncer;
		try
		{
			dataBaseSyncer = new DatabaseSyncer(sourceData, targetData);
			dataBaseSyncer.sync();
		} catch (ConnectException e)
		{
			System.out.println("Connection error, Ending program ...");
		}

	}

	/**
	 * 
	 */
	private void sync()
	{

		dropAllTables(target);
		Collection<String> tablesNames = getTablesNames(source);

		for (String tableName : tablesNames)
		{
			createTable(tableName);
			copyData(tableName);
		}

	}

	/**
	 * Contructor.
	 * 
	 * @param source
	 *            Connection to the source database to set.
	 * @param target
	 *            Connection to the target database to set.
	 */
	public DatabaseSyncer(final Connection source, final Connection target)
	{

		setSource(source);
		setTarget(target);

	}

	/**
	 * Contructor.
	 * 
	 * @param sourceData
	 *            Connection Data to the source database to set.
	 * @param targetData
	 *            Connection Data to the target database to set.
	 * @throws ConnectException
	 *             If connection error to target or source
	 */
	public DatabaseSyncer(final ConnectionData sourceData, final ConnectionData targetData) throws ConnectException
	{
		boolean sourceError = false;
		boolean targetError = false;
		try
		{
			source = sourceData.getConnection();
		} catch (SQLException e)
		{
			sourceError = true;
		}

		try
		{
			target = targetData.getConnection();
		} catch (SQLException e)
		{
			targetError = true;
		}

		if (sourceError || targetError)
		{
			StringBuilder msg = new StringBuilder();
			if (sourceError)
			{
				msg.append("Connection to source failed\n").append(sourceData.getUrl()).append("\n");
			}
			if (targetError)
			{
				msg.append("Connection to target failed\n").append(targetData.getUrl()).append("\n");
			}

			JOptionPane.showMessageDialog(null, msg, "Connection Error", JOptionPane.ERROR_MESSAGE);

			throw new ConnectException();
		}
		setSource(source);
		setTarget(target);

	}

	/**
	 * Return all the tables names contained in the database given.
	 * 
	 * @param connection
	 *            Connection to the databse.
	 * @return Tables names.
	 */
	public static Collection<String> getTablesNames(final Connection connection)
	{
		Collection<String> result = new ArrayList<String>();
		ResultSet rs = null;
		try
		{
			DatabaseMetaData dbm = connection.getMetaData();
			String[] types = { "TABLE" };
			rs = dbm.getTables(null, null, "", types);

			while (rs.next())
			{
				String str = rs.getString("TABLE_NAME");
				result.add(str);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			if (rs != null)
			{
				try
				{
					rs.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}

		return result;

	}

	/**
	 * Create a table in the target database from the table having the given
	 * name in the source database.
	 * 
	 * @param tableName
	 *            Name of the table to create from.
	 */
	private void createTable(final String tableName)
	{

		dropTable(target, tableName);
		String createStatement = generateCreateStatement(source, tableName);
		try
		{
			System.out.println(createStatement);
			Statement statement = target.createStatement();
			statement.executeUpdate(createStatement);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Drop the table given from the database connection given.
	 * 
	 * @param connection
	 *            Database connection containg the table to drop
	 * @param tableName
	 *            Name of the database to drop.
	 */
	public final void dropTable(final Connection connection, final String tableName)
	{

		try
		{
			String dropSQL = "DROP TABLE IF EXISTS " + escape(tableName);
			System.out.println(dropSQL);
			Statement statement = connection.createStatement();
			statement.executeUpdate(dropSQL);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Generate the SQL statement to create the table in the target databse.
	 * 
	 * @param connection
	 *            Source database connection.
	 * @param tableName
	 *            Table to create.
	 * @return The SQL Satement.
	 */
	public final String generateCreateStatement(final Connection connection, final String tableName)
	{
		StringBuffer result = new StringBuffer();
		String autoIncrement = "";
		try
		{
			// Basic query to retrieve the metadata of the table to create the
			// new one
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT * FROM ");
			sql.append(escape(tableName));

			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql.toString());
			ResultSetMetaData md = rs.getMetaData();

			// Start generating the table creation query
			result.append("CREATE TABLE ");
			result.append(escape(tableName));
			result.append(" ( ");

			for (int i = 1; i <= md.getColumnCount(); i++)
			{
				if (i != 1)
				{
					result.append(',');
				}
				result.append(escape(md.getColumnName(i)));
				result.append(' ');

				String type = processType(md.getColumnTypeName(i), md.getPrecision(i), md.getScale(i));
				result.append(type);
				if (md.getColumnTypeName(i).equalsIgnoreCase("VARCHAR"))
				{
					String collation = ((com.mysql.jdbc.ResultSetMetaData) md).getColumnCharacterSet(i);
					String collationResult = collation;
					if (collation.equalsIgnoreCase("UTF-8"))
					{
						collationResult = "utf8_general_ci";
					} else if (collation.equalsIgnoreCase("ISO8859_7"))
					{
						collationResult = "latin7_general_cs";
					} else if (collation.equalsIgnoreCase("Cp1252"))
					{
						collationResult = "latin1_general_cs";
					}

					result.append("COLLATE `").append(collationResult).append("` ");
				}
				if (isNumeric(md.getColumnType(i)))
				{
					if (!md.isSigned(i))
					{
						result.append("UNSIGNED ");
					}
				}

				if (md.isNullable(i) == ResultSetMetaData.columnNoNulls)
				{
					result.append("NOT NULL ");
				} else
				{
					result.append("NULL ");
				}
				if (md.isAutoIncrement(i))
				{
					result.append("AUTO_INCREMENT");
					autoIncrement = md.getColumnName(i);
				}
			}

			DatabaseMetaData dbm = connection.getMetaData();
			ResultSet primary = dbm.getPrimaryKeys(null, null, tableName);

			boolean first = true;
			boolean found = false;
			while (primary.next())
			{
				if (first && autoIncrement.equalsIgnoreCase(primary.getString("COLUMN_NAME")))
				{
					first = false;
					result.append(',');
					result.append("PRIMARY KEY(");
					found = true;
					result.append(escape(primary.getString("COLUMN_NAME")));
					primary.first();
				} else if (!first && !autoIncrement.equalsIgnoreCase(primary.getString("COLUMN_NAME")))
				{
					result.append(",");
					result.append(escape(primary.getString("COLUMN_NAME")));
				}
			}

			if (!first)
			{
				result.append(')');
			}

			result.append(" ); ");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return result.toString();
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

	/**
	 * Check if the type is numeric.
	 * 
	 * @param columnType
	 *            Type to check
	 * @return Boolean if numeric
	 */
	private static boolean isNumeric(final int columnType)
	{

		switch (columnType)
		{
		case Types.BIGINT:
		case Types.SMALLINT:
		case Types.INTEGER:
		case Types.TINYINT:
		case Types.NUMERIC:
			return true;
		default:
			return false;

		}
	}

	/**
	 * Generate the type of a column for sql use.
	 * 
	 * @param columnTypeName
	 *            Column type name
	 * @param precision
	 *            Precision
	 * @param scale
	 *            Scale
	 * @return the generated type
	 */
	private static String processType(final String columnTypeName, final int precision, final int scale)
	{
		StringBuilder result = new StringBuilder();

		if (columnTypeName.equalsIgnoreCase("DATETIME"))
		{
			result.append("DATETIME ");
		} else if (columnTypeName.equalsIgnoreCase("TIMESTAMP"))
		{
			result.append("TIMESTAMP ");
		} else if (precision != 0 && precision < MAX_VARCHAR_LENGTH)
		{
			result.append(columnTypeName);
			result.append('(');
			result.append(precision);
			if (scale > 0)
			{
				result.append(',');
				result.append(scale);
			}
			result.append(") ");
		} else if (precision >= MAX_VARCHAR_LENGTH)
		{
			result.append("TEXT ");

		} else
		{
			result.append(columnTypeName);
			result.append(' ');
		}

		return result.toString();
	}

	/**
	 * 
	 * @param md
	 *            MetaData of a resultset
	 * @return Column names
	 */
	public static Collection<String> getColumsNames(final ResultSetMetaData md)
	{
		Collection<String> columns = new ArrayList<String>();
		try
		{
			for (int i = 1; i <= md.getColumnCount(); i++)
			{

				columns.add(md.getColumnName(i));
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return columns;

	}

	/**
	 * Copy the data of the given table from the source database to the target
	 * database.
	 * 
	 * @param tableName
	 *            Name of the table to copy
	 */
	private void copyData(final String tableName)
	{
		try
		{
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT * FROM ");
			sql.append(tableName);

			Statement statement = source.createStatement();
			ResultSet rs = statement.executeQuery(sql.toString());
			ResultSetMetaData md = rs.getMetaData();

			Collection<String> columns = getColumsNames(md);

			StringBuffer insertSQL = new StringBuffer();
			StringBuffer values = new StringBuffer();

			System.out.println("Begin copy: " + tableName);

			insertSQL.append("INSERT INTO ");
			insertSQL.append(tableName);
			insertSQL.append("(");

			boolean first = true;
			for (String column : columns)
			{

				if (!first)
				{

					insertSQL.append(",");
					values.append(",");
				} else
				{
					first = false;
				}

				insertSQL.append(escape(column));
				values.append("?");
			}

			// selectSQL.append(" FROM ");
			// selectSQL.append(table);

			insertSQL.append(") VALUES (");
			insertSQL.append(values);
			insertSQL.append(")");

			// now copy
			PreparedStatement prepStatement = null;

			prepStatement = target.prepareStatement(insertSQL.toString());

			// rs = source.executeQuery(selectSQL.toString());

			int rows = 0;

			while (rs.next())
			{
				rows++;

				for (int i = 1; i <= columns.size(); i++)
				{
					prepStatement.setString(i, rs.getString(i));
				}

				prepStatement.execute();
			}

			System.out.println("Copied " + rows + " rows.");
			System.out.println("");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Drop all the tables in the given databse.
	 * 
	 * @param connection
	 *            Connection to the database
	 */
	public final void dropAllTables(final Connection connection)
	{
		Collection<String> tablesNames = getTablesNames(connection);
		for (String tableName : tablesNames)
		{

			try
			{
				Statement statement = connection.createStatement();
				statement.executeUpdate("DROP TABLE IF EXISTS " + escape(tableName));
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @return the target
	 */
	public final Connection getTarget()
	{
		return target;
	}

	/**
	 * @param target
	 *            the target to set
	 */
	public final void setTarget(final Connection target)
	{
		this.target = target;
	}

	/**
	 * @return the source
	 */
	public final Connection getSource()
	{
		return source;
	}

	/**
	 * @param source
	 *            the source to set
	 */
	public final void setSource(final Connection source)
	{
		this.source = source;
	}
}

package ca.bendo.databasesync;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Connains the information to connect to a database.
 * 
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ConnectionData</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class ConnectionData
{

	/**
	 * Databse url.
	 */
	private String url;
	/**
	 * Database user.
	 */
	private String user;

	/**
	 * Databse user password.
	 */
	private String password;

	/**
	 * @return Return the connection with the information specified.
	 * @throws SQLException
	 *             SQLException generate by the DriverManager.getConnection
	 */
	public Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection(getUrl(), getUser(), getPassword());
	}

	/**
	 * @return the url
	 */
	public String getUrl()
	{
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(final String url)
	{
		this.url = url;
	}

	/**
	 * @return the user
	 */
	public String getUser()
	{
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(final String user)
	{
		this.user = user;
	}

	/**
	 * @return the password
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(final String password)
	{
		this.password = password;
	}
}

/**
 * 
 */
package ca.bendo.db.dao;

import java.util.logging.Logger;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TestDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public final class TestDAO
{

	/**
	 * Default constructor: prevent instantiation.
	 */
	private TestDAO()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * Logger.
	 */
	private static Logger log = Logger.getLogger("JunitTesting");
	/**
	 * Datasource to connect to the dataBase.
	 */
	private static DriverManagerDataSource dataSource = null;

	/**
	 * Load the dataSource before all the test.
	 */
	public static void loadDataSource()
	{
		log.info("Loading dataSource");
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/bendo_dev");
		dataSource.setUsername("root");
		dataSource.setPassword("madremia350");
	}

	/**
	 * Retrun the datasource created at the beginning of the test.
	 * 
	 * @return the dataSource
	 */
	public static DriverManagerDataSource getDataSource()
	{
		if (dataSource == null)
		{
			loadDataSource();
		}
		return dataSource;
	}

	/**
	 * @param dataSource
	 *            the dataSource to set
	 */
	public static void setDataSource(final DriverManagerDataSource dataSource)
	{
		TestDAO.dataSource = dataSource;
	}

}

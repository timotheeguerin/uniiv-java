package ca.bendo.db.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ParentDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
public class ParentDAO
{

	/**
	 * 
	 */
	private JdbcTemplate jdbcTemplate;

	/**
	 * Default constructor.
	 */
	public ParentDAO()
	{
		System.out.println("ParentDAO create ...");
	}

	/**
	 * Set the dataSource.
	 * 
	 * @param dataSource
	 *            datSource to set
	 */
	@Autowired
	public final void setDataSource(final DataSource dataSource)
	{

		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * Return the jdbcTemplate.
	 * 
	 * @return the jdbctemplate
	 */
	public final JdbcTemplate getJdbcTemplate()
	{
		return this.jdbcTemplate;
	}

	/**
	 * 
	 * @param tableName
	 *            Table to update.
	 * @param id
	 *            of the element to remove
	 */
	public final void deleteFromWithId(final String tableName, final int id)
	{

		String sql = SqlGenerator.deleteFrom(tableName);
		Object[] parameters = new Object[] { id };
		getJdbcTemplate().update(sql, parameters);

	}

	/**
	 * 
	 * @param tableName
	 *            TableName
	 * @param clazz
	 *            Class mapping the element of the table.
	 * @param <T>
	 *            Template
	 * @return List of object of the class
	 */
	public final <T> List<T> selectAllFrom(final String tableName, final Class<T> clazz)
	{
		String sql = SqlGenerator.selectAllFrom(tableName);
		List<T> list = getJdbcTemplate().query(sql, new BeanPropertyRowMapper<T>(clazz));
		return list;
	}

	/**
	 * 
	 * @param tableName
	 *            TableName
	 * @param id
	 *            of the element to remove * @param clazz Class mapping the
	 *            element of the table.
	 * @param <T>
	 *            Template
	 * @return Object of the class
	 */
	public final <T> T selectFromWithId(final String tableName, final int id, final Class<T> clazz)
	{
		String sql = SqlGenerator.selectFrom(tableName);
		Object[] parameters = new Object[] { id };
		List<T> list = getJdbcTemplate().query(sql, parameters, new BeanPropertyRowMapper<T>(clazz));
		if (list.size() > 0)
		{
			return list.get(0);
		} else
		{
			return null;
		}
	}
}

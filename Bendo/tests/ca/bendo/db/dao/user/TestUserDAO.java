/**
 * 
 */
package ca.bendo.db.dao.user;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.entity.user.User;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TestUser</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Transactional
public class TestUserDAO
{
	/**
	 * 
	 */
	@Autowired
	private UserDAO userDAO;

	/**
	 * @throws SQLException
	 *             Exception SQl
	 * 
	 */
	@Test
	public void testListUser() throws SQLException
	{
		User users = userDAO.getById(1L);
		assertTrue(users != null);

		System.out.println(users.getEmail() + " " + users.getPassword());
	}
}

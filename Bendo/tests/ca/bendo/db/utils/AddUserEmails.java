/**
 * 
 */
package ca.bendo.db.utils;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.user.UserDAO;
import ca.bendo.db.dao.user.UserEmailDAO;
import ca.bendo.db.entity.user.User;
import ca.bendo.db.entity.user.UserEmail;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>AddUserEmails</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Transactional
public class AddUserEmails
{
	/**
	 * 
	 */
	@Autowired
	private UserDAO userDAO;

	/**
	 * 
	 */
	@Autowired
	private UserEmailDAO emailDAO;

	/**
	 * 
	 */
	@Test
	@Rollback(false)
	public void addEmail()
	{
		List<User> users = userDAO.list();
		for (User user : users)
		{
			UserEmail current = emailDAO.getByEmail(user.getEmail());
			if (current == null)
			{
				UserEmail userEmail = new UserEmail();
				userEmail.setEmail(user.getEmail());
				userEmail.setUser(user);
				if (user.getState().getState().equalsIgnoreCase("valid"))
				{
					userEmail.setValidated(true);
				} else
				{
					userEmail.setValidated(false);
				}
				emailDAO.add(userEmail);
			}
		}
	}
}

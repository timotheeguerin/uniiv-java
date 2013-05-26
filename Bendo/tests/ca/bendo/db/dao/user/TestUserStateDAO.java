/**
 * 
 */
package ca.bendo.db.dao.user;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.entity.user.UserState;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TestUserSateDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Transactional
public class TestUserStateDAO
{
	/**
	 * 
	 */
	@Autowired
	private UserStateDAO userStateDAO;

	/**
	 * Test the GetAllAchievementLevel from the AllAchievementLevelDAO class.
	 * 
	 * @see AllAchievementLevelDAO
	 */
	@Test
	public final void testListStates()
	{

		List<UserState> l = userStateDAO.list();
		assertTrue(l != null);

		System.out.println("id - UserState");
		for (UserState t : l)
		{
			System.out.printf("%-4d %s\n", t.getId(), t.getState());
		}
		
		UserState state = userStateDAO.getByState("wait_email_confirmation");
		assertTrue(state != null);

	}
}

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

import ca.bendo.db.entity.user.UserPermission;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TestUserPermissionDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Transactional
public class TestUserPermissionDAO
{
	/**
	 * 
	 */
	@Autowired
	private UserPermissionDAO permissionDAO;

	/**
	 * Test the GetAllAchievementLevel from the AllAchievementLevelDAO class.
	 * 
	 * @see AllAchievementLevelDAO
	 */
	@Test
	public final void testGetStates()
	{

		List<UserPermission> l = permissionDAO.list();

		System.out.println("id - logintype");
		for (UserPermission t : l)
		{
			System.out.println(t.getId() + " - " + t.getPermission());
		}

		assertTrue(l != null);

	}
}

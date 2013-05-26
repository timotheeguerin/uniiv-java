/**
 * 
 */
package ca.bendo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.user.UserDAO;
import ca.bendo.db.entity.user.User;
import ca.bendo.session.UserSession;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UserSessionHandler</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class UserSessionHandler
{
	/**
	 * 
	 */
	@Autowired
	private UserDAO userDAO;

	/**
	 * Reload the user in the given session.
	 * 
	 * @param userSession
	 *            userSession
	 */
	public void reloadUser(final UserSession userSession)
	{
		User oldUser = userSession.getUser();
		if (oldUser != null)
		{
			User user = userDAO.getById(oldUser.getId());
			userSession.setUser(user);
		}
	}
}

/**
 * 
 */
package ca.bendo.form.handler.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.user.UserDAO;
import ca.bendo.db.entity.user.User;
import ca.bendo.form.entity.user.LoginEntity;
import ca.bendo.session.UserSession;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>LoginHandler</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class LoginHandler
{
	/**
	 * 
	 */
	@Autowired
	private UserDAO userDAO;

	/**
	 * 
	 * @param request
	 *            Request
	 * @return if the user successfuly login
	 */
	public boolean handle(final HttpServletRequest request)
	{
		LoginEntity loginEntity = new LoginEntity();
		loginEntity.setup(request);
		if (!loginEntity.isValid())
		{
			System.out.println("Invalid login");
			return false;
		}

		User user = userDAO.getByEmail(loginEntity.getEmail());
		if (user == null)
		{
			System.out.println("No good email");
			return false;
		}
		if (!user.getPassword().match(loginEntity.getPassword()))
		{
			System.out.println("Password no match");
			return false;
		}

		UserSession.getSession(request).login(user);
		return true;
	}
}

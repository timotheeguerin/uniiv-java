/**
 * 
 */
package ca.bendo.form.handler.user;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.user.UserDAO;
import ca.bendo.db.dao.user.UserSessionCookieDAO;
import ca.bendo.db.entity.lang.Language;
import ca.bendo.db.entity.user.User;
import ca.bendo.db.entity.user.UserSessionCookie;
import ca.bendo.form.entity.user.LoginForm;
import ca.bendo.session.UserSession;
import ca.bendo.user.element.HashedPassword;
import ca.bendo.utils.security.Crypter;

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
	 */
	@Autowired
	private UserSessionCookieDAO sessionCookieDAO;

	/**
	 * 
	 * @param response
	 *            to set cookies
	 * @param request
	 *            Request
	 * @param loginForm
	 *            Login form
	 * @return if the user successfuly login
	 */
	public boolean handle(final HttpServletRequest request, final LoginForm loginForm,
			final HttpServletResponse response)
	{

		long languageId = Language.loadId(request);
		User user = userDAO.getByEmail(loginForm.getEmail());
		if (user == null)
		{
			return false;
		}
		if (!user.getPassword().match(loginForm.getPassword()))
		{
			return false;
		}
		remeberUser(response, user);
		UserSession.getSession(request).login(user);
		return true;
	}

	/**
	 * @param response
	 *            Response object to set cookies
	 * @param user
	 *            user to remember
	 */
	public void remeberUser(final HttpServletResponse response, final User user)
	{
		UserSessionCookie sessionCookie = new UserSessionCookie();
		sessionCookie.setUserId(user.getId());
		String key = RandomStringUtils.randomAlphanumeric(Crypter.RANDOM_KEY_LENGHT);
		sessionCookie.setKey(new HashedPassword(key));

		sessionCookieDAO.saveOrUpdate(sessionCookie);

		Cookie idCookie = new Cookie("user.id", String.valueOf(user.getId()));
		Cookie keyCookie = new Cookie("user.key", key);

		idCookie.setPath("/");
		keyCookie.setPath("/");
		response.addCookie(idCookie);
		response.addCookie(keyCookie);
	}
}

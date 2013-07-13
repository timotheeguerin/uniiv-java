/**
 * 
 */
package ca.bendo.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import ca.bendo.db.entity.user.User;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UserSession</b>
 *          <p>
 *          </p>
 * 
 * 
 */

public class UserSession
{

	/**
	 * Logger.
	 */
	@SuppressWarnings("unused")
	private Logger log = Logger.getLogger(UserSession.class);

	/**
	 * 
	 */
	private HttpServletRequest request;

	/**
	 * 
	 */
	private User user;

	/**
	 * 
	 */
	public UserSession()
	{

	}

	/**
	 * Load the user session from the session.
	 * 
	 * @param req
	 *            Request
	 */
	public void loadSession(final HttpServletRequest req)
	{
		setRequest(req);
		HttpSession session = getRequest().getSession();
		// Load the user from the session
		user = (User) session.getAttribute("user");
		req.setAttribute("userSession", this);
	}

	/**
	 * Log the user in.
	 * 
	 * @param tmpUser
	 *            User
	 */
	public void login(final User tmpUser)
	{
		user = tmpUser;
		HttpSession session = getRequest().getSession();
		session.setAttribute("user_session", true);
		session.setAttribute("user", user);
	}

	/**
	 * Log the user out.
	 */
	public void logout()
	{
		HttpSession session = getRequest().getSession();
		session.removeAttribute("user_session");
		session.removeAttribute("user_status");
		session.removeAttribute("user");
		user = null;
	}

	/**
	 * @return the request
	 */
	public HttpServletRequest getRequest()
	{
		return request;
	}

	/**
	 * @param request
	 *            the request to set
	 */
	public void setRequest(final HttpServletRequest request)
	{
		this.request = request;
	}

	/**
	 * @return the user
	 */
	public User getUser()
	{
		return user;
	}

	/**
	 * @return boolean if the user is a login member.
	 */
	public boolean isLogin()
	{
		return user != null;
	}

	/**
	 * @param permission
	 *            permission
	 * @return if the user has the given permission
	 */
	public boolean hasPermission(final String permission)
	{
		return user != null && user.hasPermission(permission);
	}

	/**
	 * @param request
	 *            request
	 * @return userSession loaded from request
	 */
	public static UserSession getSession(final HttpServletRequest request)
	{
		return (UserSession) request.getAttribute("userSession");
	}

	/**
	 * @return userSession loaded from request
	 */
	public static UserSession getSession()
	{
		return (UserSession) RequestContextHolder.currentRequestAttributes().getAttribute("userSession",
				RequestAttributes.SCOPE_REQUEST);
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(final User user)
	{
		this.user = user;
	}

}

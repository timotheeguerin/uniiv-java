/**
 * 
 */
package ca.bendo.filters;

import java.io.IOException;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.user.UserDAO;
import ca.bendo.db.dao.user.UserSessionCookieDAO;
import ca.bendo.db.entity.user.User;
import ca.bendo.db.entity.user.UserSessionCookie;
import ca.bendo.form.FieldValidator;
import ca.bendo.session.UserSession;
import ca.bendo.user.UserSessionHandler;

/**
 * @author Timoth�e Gu�rin
 * @version Bendo
 * 
 *          <b>SessionFilter</b>
 *          <p>
 * 
 *          Load the session from the request
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class SessionFilter extends IFilter
{

	/**
	 * 
	 */
	@Autowired
	private UserSessionHandler sessionHandler;

	/**
	 * 
	 */
	@Autowired
	private UserSessionCookieDAO sessionCookieDAO;

	/**
	 * 
	 */
	@Autowired
	private UserDAO userDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	/**
	 * 
	 */
	public SessionFilter()
	{

	}

	@Override
	public void destroy()
	{

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public String doFilter(final HttpServletRequest request, final ServletResponse response, final String currentUrl)
			throws IOException, ServletException
	{

		UserSession userSession = new UserSession();
		userSession.loadSession(request);
		sessionHandler.reloadUser(userSession);
		request.setAttribute("userSession", userSession);
		loginUserFromCookie(request);
		return currentUrl;
	}

	/**
	 * Try to login the user using his cookies.
	 * 
	 * @param request
	 *            request
	 */
	public void loginUserFromCookie(final HttpServletRequest request)
	{
		Cookie[] cookies = request.getCookies();
		if (cookies == null)
		{
			return;
		}
		String userIdStr = getCookieValue(cookies, "user.id");
		String keyStr = getCookieValue(cookies, "user.key");

		if (FieldValidator.isInt(userIdStr) && keyStr != null)
		{
			long userId = Integer.parseInt(userIdStr);
			UserSessionCookie sessionCookie = sessionCookieDAO.getById(userId);
			if (sessionCookie == null)
			{
				return;
			}
			// Check if the cookie key match the db one
			if (sessionCookie.getKey().match(keyStr))
			{
				User user = userDAO.getById(userId);
				if (user != null)
				{
					// Log the use in
					UserSession.getSession(request).login(user);
				}
			}
		}

	}

	/**
	 * 
	 * @param cookies
	 *            Cookies
	 * @param cookieName
	 *            Cookie name
	 * @return cookie with teh given name
	 */
	public static String getCookieValue(final Cookie[] cookies, final String cookieName)
	{
		for (int i = 0; i < cookies.length; i++)
		{
			Cookie cookie = cookies[i];
			if (cookieName.equals(cookie.getName()))
			{
				return (cookie.getValue());
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(final FilterConfig arg0) throws ServletException
	{

	}

}

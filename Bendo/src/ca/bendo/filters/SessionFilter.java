/**
 * 
 */
package ca.bendo.filters;

import java.io.IOException;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.bendo.session.UserSession;
import ca.bendo.user.UserSessionHandler;

/**
 * @author Timothée Guérin
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
public class SessionFilter extends IFilter
{

	/**
	 * 
	 */
	@Autowired
	private UserSessionHandler sessionHandler;

	/**
	 * Logger.
	 */
	private Logger log = Logger.getLogger(SessionFilter.class);

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
		// TODO Auto-generated constructor stub
	}

	@Override
	public void destroy()
	{
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public final String doFilter(final HttpServletRequest request, final ServletResponse response,
			final String currentUrl) throws IOException, ServletException
	{
		UserSession userSession = new UserSession();
		userSession.loadSession(request);
		sessionHandler.reloadUser(userSession);
		request.setAttribute("userSession", userSession);
		return currentUrl;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(final FilterConfig arg0) throws ServletException
	{
		// TODO Auto-generated method stub

	}

}

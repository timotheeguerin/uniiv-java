/**
 * 
 */
package ca.bendo.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Timothée Guérin
 * @version Bendo
 * @see IFilter <b>FilterDispatcher</b>
 *      <p>
 *      Manage all the BendoFilter
 *      </p>
 * 
 * 
 */
public class FilterDispatcher implements Filter
{

	/**
	 * Logger.
	 */
	private Logger log = Logger.getLogger(FilterDispatcher.class);

	/**
	 * 
	 */
	@Autowired
	private MultiLanguageFilter multiLanguageFilter;

	/**
	 * 
	 */
	@Autowired
	private SessionFilter sessionFilter;

	/**
	 * 
	 */
	@Autowired
	private AlertMessageFilter alertManagerFilter;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy()
	{
		//

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain filterChain)
			throws IOException, ServletException
	{
		HttpServletRequest hsRequest = (HttpServletRequest) request;
		String url = hsRequest.getRequestURI().substring(hsRequest.getContextPath().length());

		// system.loadFilters((HttpServletRequest) request);
		url = multiLanguageFilter.doFilter(hsRequest, response, url);

		url = sessionFilter.doFilter(hsRequest, response, url);
		url = alertManagerFilter.doFilter(hsRequest, response, url);

		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
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

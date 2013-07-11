/**
 * 
 */
package ca.bendo.filters;

import java.io.IOException;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import ca.bendo.alert.message.AlertMessageManager;

/**
 * @author Timoth�e Gu�rin
 * @version Bendo
 * 
 *          <b>AlertMessageFilter</b>
 *          <p>
 *          </p>
 * 
 * 
 */

@Service
public class AlertMessageFilter extends IFilter
{

	/**
	 * 
	 */
	public AlertMessageFilter()
	{
		//
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.bendo.filters.BendoFilter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(final FilterConfig fc) throws ServletException
	{

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.bendo.filters.BendoFilter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, java.lang.String)
	 */
	@Override
	public String doFilter(final HttpServletRequest request, final ServletResponse response, final String url)
			throws IOException, ServletException
	{
		if (excludeFromFilter(url))
		{
			return url;
		}
		request.getAttribute("translator");
		String alertMsg = request.getParameter("alertmsg");

		if (alertMsg == null)
		{
			return url;
		}

		String[] msgs = alertMsg.split(",");
		AlertMessageManager alertManager = AlertMessageManager.getManager(request);
		for (String key : msgs)
		{
			alertManager.addAlertMessage(key, request);
		}

		return url;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.bendo.filters.BendoFilter#destroy()
	 */
	@Override
	public void destroy()
	{
		//

	}

}

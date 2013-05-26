/**
 * 
 */
package ca.bendo.filters;

import java.io.IOException;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>BendoFilter</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public abstract class IFilter
{
	/**
	 * 
	 * @param fc
	 *            Config
	 * @throws ServletException
	 *             Exception
	 */
	abstract void init(FilterConfig fc) throws ServletException;

	/**
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @param url
	 *            Current url
	 * @return The url
	 * @throws IOException
	 *             Exception
	 * @throws ServletException
	 *             Exception
	 */
	abstract String doFilter(HttpServletRequest request, ServletResponse response, String url) throws IOException,
			ServletException;

	/**
	 * 
	 */
	abstract void destroy();

	/**
	 * Check if the url need to be exluded from filter.
	 * 
	 * @param url
	 *            Url to check
	 * @return Boolean if it need to be excluded from filter
	 */
	protected boolean excludeFromFilter(final String url)
	{
		return (url.startsWith("/ressources") || url.startsWith("/images") || url.startsWith("/styles")
				|| url.startsWith("/scripts") || url.startsWith("/fonts"));
	}

}

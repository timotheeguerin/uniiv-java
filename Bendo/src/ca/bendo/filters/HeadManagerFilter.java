/**
 * 
 */
package ca.bendo.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

import ca.bendo.head.HeadManager;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>HeadManagerFilter</b>
 *          <p>
 *          </p>
 * @see Filter
 * 
 */
public class HeadManagerFilter implements Filter
{
	/**
	 * Logger.
	 */
	@SuppressWarnings("unused")
	private Logger log = Logger.getLogger(HeadManagerFilter.class);

	@Override
	public void init(final FilterConfig fc) throws ServletException
	{
	}

	@Override
	public final void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain fc)
			throws IOException, ServletException
	{
		HeadManager head = new HeadManager();
		request.setAttribute("head", head);
		fc.doFilter(request, response);
	}

	@Override
	public void destroy()
	{
	}
}
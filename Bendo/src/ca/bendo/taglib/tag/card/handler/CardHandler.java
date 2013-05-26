/**
 * 
 */
package ca.bendo.taglib.tag.card.handler;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>CardHandler</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public interface CardHandler
{
	/**
	 * 
	 * @param request
	 *            request
	 * 
	 * @param value
	 *            value
	 */
	void setup(final HttpServletRequest request, final long value);
}

/**
 * 
 */
package ca.bendo.form;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>FormValidator</b>
 *          <p>
 *          </p>
 * 
 */
@Service
public abstract class FormValidator
{

	/**
	 * Request.
	 */
	private HttpServletRequest request;

	/**
	 * Default constructor.
	 */
	public FormValidator()
	{
	}

	/**
	 * Validate a form.
	 * 
	 * @param req
	 *            Request
	 * @return Form is valid
	 */
	public abstract boolean validate(HttpServletRequest req);

	/**
	 * @return the request
	 */
	public final HttpServletRequest getRequest()
	{
		return request;
	}

	/**
	 * @param request
	 *            the request to set
	 */
	public final void setRequest(final HttpServletRequest request)
	{
		this.request = request;
	}
}

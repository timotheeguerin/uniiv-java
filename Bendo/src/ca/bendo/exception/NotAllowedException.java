/**
 * 
 */
package ca.bendo.exception;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>NotAllowedException</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class NotAllowedException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1093792542414354553L;

	/**
	 * 
	 */
	private String redirectUrl;

	/**
	 * 
	 */
	public NotAllowedException()
	{

	}

	/**
	 * @param redirectUrl
	 *            Url to redirect to
	 */
	public NotAllowedException(final String redirectUrl)
	{
		this.redirectUrl = redirectUrl;
	}

	/**
	 * @return the redirectUrl
	 */
	public String getRedirectUrl()
	{
		return redirectUrl;
	}

	/**
	 * @param redirectUrl
	 *            the redirectUrl to set
	 */
	public void setRedirectUrl(String redirectUrl)
	{
		this.redirectUrl = redirectUrl;
	}
}

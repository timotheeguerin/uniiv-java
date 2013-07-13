/**
 * 
 */
package ca.bendo.json;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>JsonSuccess</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class JsonSuccess implements Json
{
	/**
	 * 
	 */
	private boolean success;

	/**
	 * 
	 */
	private String message;

	/**
	 * 
	 */
	public JsonSuccess()
	{
		this.success = true;
		this.message = "Great success";
	}

	/**
	 * @param message
	 *            Message to set
	 */
	public JsonSuccess(final String message)
	{
		this.success = true;
		this.message = message;
	}

	/**
	 * @param success
	 *            Success to set
	 * @param message
	 *            Message to set
	 */
	public JsonSuccess(final String message, final boolean success)
	{
		this.success = success;
		this.message = message;
	}

	/**
	 * @return the success
	 */
	public boolean isSuccess()
	{
		return success;
	}

	/**
	 * @param success
	 *            the success to set
	 */
	public void setSuccess(final boolean success)
	{
		this.success = success;
	}

	/**
	 * @return the message
	 */
	public String getMessage()
	{
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(final String message)
	{
		this.message = message;
	}

}

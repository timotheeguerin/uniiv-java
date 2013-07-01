/**
 * 
 */
package ca.bendo.form.entity.confirmation;

import javax.validation.constraints.Min;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>CheckConfirmation</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class CheckConfirmationForm
{
	/**
	 * 
	 */
	@Min(value = 0)
	private long confirmationId;

	/**
	 * 
	 */
	private String key;

	/**
	 * @return the confirmationId
	 */
	public long getConfirmationId()
	{
		return confirmationId;
	}

	/**
	 * @param confirmationId
	 *            the confirmationId to set
	 */
	public void setConfirmationId(final long confirmationId)
	{
		this.confirmationId = confirmationId;
	}

	/**
	 * @return the key
	 */
	public String getKey()
	{
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(final String key)
	{
		this.key = key;
	}

}

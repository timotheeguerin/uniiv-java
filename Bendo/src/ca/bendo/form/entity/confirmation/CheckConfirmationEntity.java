/**
 * 
 */
package ca.bendo.form.entity.confirmation;

import ca.bendo.annotation.Input;
import ca.bendo.form.entity.Entity;
import ca.bendo.form.entity.EntityType;

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
public class CheckConfirmationEntity extends Entity
{
	/**
	 * 
	 */
	@Input(name = "confirmationId", type = EntityType.NUMERIC)
	private String confirmationId;

	/**
	 * 
	 */
	@Input(name = "key", type = EntityType.OTHER)
	private String key;

	/**
	 * @return the confirmationId
	 */
	public final String getConfirmationId()
	{
		return confirmationId;
	}

	/**
	 * @param confirmationId
	 *            the confirmationId to set
	 */
	public final void setConfirmationId(final String confirmationId)
	{
		this.confirmationId = confirmationId;
	}

	/**
	 * @return the key
	 */
	public final String getKey()
	{
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public final void setKey(final String key)
	{
		this.key = key;
	}

}

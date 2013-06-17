/**
 * 
 */
package ca.bendo.form.entity.user;

import ca.bendo.annotation.Input;
import ca.bendo.form.entity.Entity;
import ca.bendo.form.entity.EntityType;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>InputEmailEntity</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class InputEmailEntity extends Entity
{
	/**
	 * 
	 */
	@Input(name = "email", type = EntityType.EMAIL)
	private String email;

	/**
	 * @return the email
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(final String email)
	{
		this.email = email;
	}

}

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
 *          <b>LoginEntity</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class LoginEntity extends Entity
{
	/**
	 * 
	 */
	@Input(name = "email", type = EntityType.EMAIL)
	private String email;

	/**
	 * 
	 */
	@Input(name = "password", type = EntityType.PASSWORD)
	private String password;

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

	/**
	 * @return the password
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(final String password)
	{
		this.password = password;
	}

}

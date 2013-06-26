/**
 * 
 */
package ca.bendo.form.entity.user;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>LoginForm</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class LoginForm
{
	/**
	 * 
	 */
	@Email
	private String email;

	/**
	 * 
	 */
	@NotEmpty
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

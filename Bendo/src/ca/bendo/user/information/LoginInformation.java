/**
 * 
 */
package ca.bendo.user.information;

import ca.bendo.user.element.Email;
import ca.bendo.user.element.Password;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>LoginInformation</b>
 *          <p>
 *          Contains login information send by the user to login: email and
 *          password
 *          </p>
 * 
 * 
 */
public class LoginInformation
{

	/**
	 * Login email.
	 */
	private Email email;

	/**
	 * Password.
	 */
	private Password password;

	/**
	 * @return the email
	 */
	public final Email getEmail()
	{
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public final void setEmail(final Email email)
	{
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public final Password getPassword()
	{
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public final void setPassword(final Password password)
	{
		this.password = password;
	}
}

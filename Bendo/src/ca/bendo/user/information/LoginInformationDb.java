/**
 * 
 */
package ca.bendo.user.information;

import ca.bendo.user.element.Email;
import ca.bendo.user.element.HashedPassword;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>LoginInformation</b>
 *          <p>
 *          Contains login information of the user to login saved on the
 *          database: email and hashedPassword
 *          </p>
 * 
 * 
 */
public class LoginInformationDb
{

	/**
	 * Login email.
	 */
	private Email email;

	/**
	 * HashedPassword.
	 */
	private HashedPassword hashedPassword;

	/**
	 * @return the email
	 */
	public Email getEmail()
	{
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(final Email email)
	{
		this.email = email;
	}

	/**
	 * @return the hashedPassword
	 */
	public HashedPassword getHashedPassword()
	{
		return hashedPassword;
	}

	/**
	 * @param hashedPassword
	 *            the hashedPassword to set
	 */
	public void setHashedPassword(final HashedPassword hashedPassword)
	{
		this.hashedPassword = hashedPassword;
	}
}

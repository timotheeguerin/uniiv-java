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
 *          </p>
 * 
 * 
 */
public class SignupInformation
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
	 * First name.
	 */
	private String firstName;

	/**
	 * Last name.
	 */
	private String lastName;

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

	/**
	 * @return the firstName
	 */
	public final String getFirstName()
	{
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public final void setFirstName(final String firstName)
	{
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public final String getLastName()
	{
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public final void setLastName(final String lastName)
	{
		this.lastName = lastName;
	}

}

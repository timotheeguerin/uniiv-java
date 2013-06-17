/**
 * 
 */
package ca.bendo.form.entity;

import ca.bendo.annotation.Input;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>SignupFormEntity</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class NewUserEntity extends Entity
{
	/**
	 * 
	 */
	@Input(name = "email", type = EntityType.EMAIL)
	private String email;

	/**
	 * 
	 * 
	 */
	@Input(name = "password", type = EntityType.PASSWORD)
	private String password;

	/**
	 * 
	 */
	@Input(name = "password_check", type = EntityType.PASSWORD, linkto = "password")
	private String passwordCheck;

	/**
	 * 
	 */
	@Input(name = "first_name", type = EntityType.NAME)
	private String firstName;

	/**
	 * 
	 */
	@Input(name = "last_name", type = EntityType.NAME)
	private String lastName;

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

	/**
	 * @return the passwordCheck
	 */
	public String getPasswordCheck()
	{
		return passwordCheck;
	}

	/**
	 * @param passwordCheck
	 *            the passwordCheck to set
	 */
	public void setPasswordCheck(final String passwordCheck)
	{
		this.passwordCheck = passwordCheck;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName()
	{
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(final String firstName)
	{
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName()
	{
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(final String lastName)
	{
		this.lastName = lastName;
	}

}

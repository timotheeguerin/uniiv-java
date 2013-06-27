/**
 * 
 */
package ca.bendo.form.entity.user;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import ca.bendo.form.FieldValidator;
import ca.bendo.form.constaints.FieldMatch;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ResetPasswordNew</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@FieldMatch(first = "password", second = "passwordCheck")
public class ResetPasswordForm
{
	/**
	 * 
	 */
	@NotEmpty
	private long id;

	/**
	 * 
	 */
	@NotEmpty
	private String key;

	/**
	 * 
	 */
	@Pattern(regexp = FieldValidator.PASSWORD_REGEX)
	private String password;

	/**
	 * 
	 */
	@Pattern(regexp = FieldValidator.PASSWORD_REGEX)
	private String passwordCheck;

	/**
	 * @return the id
	 */
	public long getId()
	{
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final long id)
	{
		this.id = id;
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

}

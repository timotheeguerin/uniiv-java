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
 *          <b>ResetPasswordNew</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class ResetPasswordNew extends Entity
{
	/**
	 * 
	 */
	@Input(name = "id", type = EntityType.NUMERIC)
	private String id;

	/**
	 * 
	 */
	@Input(name = "key", type = EntityType.ALPHANUMERIC)
	private String key;

	/**
	 * 
	 */
	@Input(name = "password", type = EntityType.PASSWORD)
	private String password;

	/**
	 * 
	 */
	@Input(name = "password", type = EntityType.PASSWORD, linkto = "password")
	private String passwordCheck;

	/**
	 * @return the id
	 */
	public final String getId()
	{
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public final void setId(final String id)
	{
		this.id = id;
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

	/**
	 * @return the password
	 */
	public final String getPassword()
	{
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public final void setPassword(final String password)
	{
		this.password = password;
	}

	/**
	 * @return the passwordCheck
	 */
	public final String getPasswordCheck()
	{
		return passwordCheck;
	}

	/**
	 * @param passwordCheck
	 *            the passwordCheck to set
	 */
	public final void setPasswordCheck(final String passwordCheck)
	{
		this.passwordCheck = passwordCheck;
	}

}

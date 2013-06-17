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
	public String getId()
	{
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final String id)
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

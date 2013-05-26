/**
 * 
 */
package ca.bendo.form.entity.professor;

import ca.bendo.annotation.Input;
import ca.bendo.form.entity.Entity;
import ca.bendo.form.entity.EntityType;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>NewProfessorEntity</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class NewProfessorEntity extends Entity
{
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
	 * 
	 */
	@Input(name = "programId", type = EntityType.NUMERIC)
	private String programId;

	/**
	 * 
	 */
	@Input(name = "recaptcha", type = EntityType.CAPTCHA)
	private String captcha;

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

	/**
	 * @return the programId
	 */
	public final String getProgramId()
	{
		return programId;
	}

	/**
	 * @param programId
	 *            the programId to set
	 */
	public final void setProgramId(final String programId)
	{
		this.programId = programId;
	}

	/**
	 * @return the captcha
	 */
	public final String getCaptcha()
	{
		return captcha;
	}

	/**
	 * @param captcha
	 *            the captcha to set
	 */
	public final void setCaptcha(final String captcha)
	{
		this.captcha = captcha;
	}

}

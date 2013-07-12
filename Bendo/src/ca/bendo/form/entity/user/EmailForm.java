/**
 * 
 */
package ca.bendo.form.entity.user;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

import ca.bendo.form.constaints.annotation.Unique;
import ca.bendo.form.constaints.type.UniqueType;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>EmailForm</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class EmailForm
{
	/**
	 * 
	 */
	@NotNull(message = "error.null")
	@Email(message = "error.email")
	@Unique(type = UniqueType.USER_EMAIL, message = "error.email.unique")
	private String email;

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

}

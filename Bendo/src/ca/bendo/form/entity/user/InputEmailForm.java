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
 *          <b>InputEmailEntity</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class InputEmailForm
{
	/**
	 * 
	 */
	@NotEmpty
	@Email
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

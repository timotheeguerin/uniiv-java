/**
 * 
 */
package ca.bendo.form.entity.user;

import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.ModCheck;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.ScriptAssert;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UserSignupForm</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class UserSignupForm
{
	/**
	 * 
	 */
	@NotEmpty
	private String firstName;

	/**
	 * 
	 */
	@NotEmpty
	private String lastName;

	/**
	 * 
	 */
	@Email
	private String email;

	/**
	 * 
	 */
	private String password;

	/**
	 * 
	 */
	private String passwordCheck;
	
	
}

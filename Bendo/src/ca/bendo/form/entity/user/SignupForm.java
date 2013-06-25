/**
 * 
 */
package ca.bendo.form.entity.user;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;

import ca.bendo.db.dao.user.UserDAO;
import ca.bendo.form.FieldValidator;
import ca.bendo.form.constaints.FieldMatch;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>SignupForm</b>
 *          <p>
 *          </p>
 * 
 * 
 */
// @Service
// @Transactional
@FieldMatch(first = "password", second = "passwordCheck")
public class SignupForm
{
	/**
	 * 
	 */
	@Autowired
	private UserDAO userDAO;

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
	@Pattern(regexp = FieldValidator.PASSWORD_REGEX)
	private String password;

	/**
	 * 
	 */
	@Pattern(regexp = FieldValidator.PASSWORD_REGEX)
	private String passwordCheck;

	/**
	 * 
	 * @return boolean if the two password are equals
	 */
	@AssertTrue(message = "error.email.unique")
	private boolean checkEmailAvailable()
	{
		System.out.println("CHECK EMAIL");
		return userDAO.isEmailAvailable(email);
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

}

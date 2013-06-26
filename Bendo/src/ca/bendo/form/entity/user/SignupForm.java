/**
 * 
 */
package ca.bendo.form.entity.user;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.user.UserDAO;
import ca.bendo.form.FieldValidator;
import ca.bendo.form.constaints.FieldMatch;
import ca.bendo.form.constaints.Unique;
import ca.bendo.form.constaints.type.UniqueType;

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
@Service
@Transactional
@FieldMatch(first = "password", second = "passwordCheck", message = "password.same")
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
	// @Unique(type = UniqueType.USER_EMAIL)
	private String email;

	/**
	 * 
	 */
	@Pattern(regexp = FieldValidator.PASSWORD_REGEX, message = "error.password.regex")
	private String password;

	/**
	 * 
	 */
	@Pattern(regexp = FieldValidator.PASSWORD_REGEX, message = "error.password.regex")
	private String passwordCheck;

	/**
	 * 
	 * @return boolean if the two password are equals
	 */
	@AssertTrue
	private boolean isValid()
	{
		// return userDAO.isEmailAvailable(email);
		return true;
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

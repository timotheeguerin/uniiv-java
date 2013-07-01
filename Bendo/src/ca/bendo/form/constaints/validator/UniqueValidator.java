/**
 * 
 */
package ca.bendo.form.constaints.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import ca.bendo.db.dao.user.UserDAO;
import ca.bendo.db.dao.user.UserEmailDAO;
import ca.bendo.form.constaints.Unique;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UniqueValidator</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class UniqueValidator implements ConstraintValidator<Unique, Object>
{
	/**
	 * 
	 */
	@Autowired
	private UserDAO userDAO;

	/**
	 *
	 */
	@Autowired
	private UserEmailDAO userEmailDAO;

	/**
	 * 
	 */
	private Unique annotation;

	@Override
	public void initialize(final Unique constraintAnnotation)
	{
		this.annotation = constraintAnnotation;
	}

	@Override
	public boolean isValid(final Object value, final ConstraintValidatorContext context)
	{
		switch (annotation.type())
		{
		case USER_EMAIL:

			return userDAO.isEmailAvailable((String) value) && userEmailDAO.isEmailAvailable((String) value);
		default:
			return false;
		}

	}
}

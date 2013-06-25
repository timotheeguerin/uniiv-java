/**
 * 
 */
package ca.bendo.form.constaints.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import ca.bendo.db.dao.user.UserDAO;
import ca.bendo.form.constaints.Unique;

/**
 * @author Timoth�e Gu�rin
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

	@Override
	public void initialize(final Unique constraintAnnotation)
	{

	}

	@Override
	public boolean isValid(final Object value, final ConstraintValidatorContext context)
	{
		return userDAO.isEmailAvailable((String) value);
	}
}

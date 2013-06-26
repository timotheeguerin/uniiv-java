/**
 * 
 */
package ca.bendo.form.constaints.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

import ca.bendo.form.constaints.FieldMatch;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>FieldMatchValidator</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object>
{
	/**
	 * 
	 */
	private String firstFieldName;
	/**
	 * 
	 */
	private String secondFieldName;

	@Override
	public void initialize(final FieldMatch constraintAnnotation)
	{
		firstFieldName = constraintAnnotation.first();
		secondFieldName = constraintAnnotation.second();
	}

	@Override
	public boolean isValid(final Object value, final ConstraintValidatorContext context)
	{
		try
		{
			final Object firstObj = BeanUtils.getProperty(value, firstFieldName);
			final Object secondObj = BeanUtils.getProperty(value, secondFieldName);

			String msg = context.getDefaultConstraintMessageTemplate();
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(msg).addPropertyNode(secondFieldName).addConstraintViolation();

			return firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
		} catch (final Exception ignore)
		{

		}
		return true;
	}
}

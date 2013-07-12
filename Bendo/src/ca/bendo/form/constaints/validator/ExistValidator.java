/**
 * 
 */
package ca.bendo.form.constaints.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.form.constaints.annotation.Exist;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ExistValidator</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Transactional
public class ExistValidator implements ConstraintValidator<Exist, Object>
{
	/**
	 * 
	 */
	@Autowired
	private ApplicationContext applicationContext;

	/**
	 * 
	 */
	private Exist annotation;

	@Override
	public void initialize(final Exist constraintAnnotation)
	{
		this.annotation = constraintAnnotation;
	}

	@Override
	public boolean isValid(final Object value, final ConstraintValidatorContext context)
	{
		System.out.println("CON: " + applicationContext);
		Object object = applicationContext.getBean(annotation.dao());
		if (object == null)
		{
			return false;
		}
		HibernateDAO<?> dao = (HibernateDAO<?>) object;
		Object result = dao.getById((Long) value);
		return result != null;
	}
}

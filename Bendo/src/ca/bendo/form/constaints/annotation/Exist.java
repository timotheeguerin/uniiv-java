/**
 * 
 */
package ca.bendo.form.constaints.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import ca.bendo.form.constaints.validator.ExistValidator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>Exist</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Target(ElementType.FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = ExistValidator.class)
@Documented
public @interface Exist
{
	/**
	 * 
	 */
	String message() default "error.exist";

	/**
	 * 
	 * @return
	 */
	Class<?> dao();

	/**
	 * 
	 * @return
	 */
	Class<?>[] groups() default {};

	/**
	 * 
	 * @return
	 */
	Class<? extends Payload>[] payload() default {};
}
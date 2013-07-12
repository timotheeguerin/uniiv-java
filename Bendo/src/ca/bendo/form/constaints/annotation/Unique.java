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

import ca.bendo.form.constaints.type.UniqueType;
import ca.bendo.form.constaints.validator.UniqueValidator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>Unique</b>
 *          <p>
 * 
 *          Validation annotation that check if the field is used
 *          </p>
 * 
 * 
 */

@Target(ElementType.FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = UniqueValidator.class)
@Documented
public @interface Unique
{
	/**
	 * 
	 */
	String message() default "Alias name is already in use.";

	/**
	 * 
	 * @return
	 */
	UniqueType type();

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
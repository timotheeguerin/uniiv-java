/**
 * 
 */
package ca.bendo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import ca.bendo.form.entity.EntityType;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>Input</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Input
{
	/**
	 * Name of the input.
	 */
	String name();

	/**
	 * Type of the input.
	 */
	EntityType type();

	/**
	 * 
	 */
	String linkto() default "";

	/**
	 * 
	 */
	long min() default 0L;

	/**
	 * 
	 */
	long max() default Long.MAX_VALUE;

}

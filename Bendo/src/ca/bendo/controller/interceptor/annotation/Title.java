/**
 * 
 */
package ca.bendo.controller.interceptor.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>Title</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Title
{
	/**
	 * 
	 */
	String value() default "";

}

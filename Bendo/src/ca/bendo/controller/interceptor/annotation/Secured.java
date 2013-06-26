/**
 * 
 */
package ca.bendo.controller.interceptor.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Timoth�e Gu�rin
 * @version Bendo
 * 
 *          <b>Secured</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Secured
{
	/**
	 * 
	 */
	String value();

}
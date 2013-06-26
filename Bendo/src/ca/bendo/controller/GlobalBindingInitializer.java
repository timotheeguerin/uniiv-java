/**
 * 
 */
package ca.bendo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.WebRequest;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>g</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@ControllerAdvice
public class GlobalBindingInitializer
{
	/**
	 * 
	 */
	@Autowired
	private Validator validator;
	
	/**
	 * 
	 * @param binder
	 *            Binder
	 * @param request
	 *            Request
	 */
	@InitBinder
	public void registerValidator(final WebDataBinder binder, final WebRequest request)
	{
		binder.setValidator(validator);
	}
}
/**
 * 
 */
package ca.bendo.json;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>JsonError</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class JsonError implements Json
{
	/**
	 * 
	 */
	private List<String> errors = new ArrayList<String>();

	/**
	 * @param result
	 *            to set
	 */
	public JsonError(final BindingResult result)
	{
		this(result.getAllErrors());
	}

	/**
	 * @param errors
	 *            init errors with this
	 */
	public JsonError(final List<ObjectError> errors)
	{
		if (errors != null)
		{
			for (ObjectError error : errors)
			{
				this.errors.add(error.getDefaultMessage());
			}
		}
	}

	/**
	 * @return the errors
	 */
	public List<String> getErrors()
	{
		return errors;
	}

	/**
	 * @param errors
	 *            the errors to set
	 */
	public void setErrors(final List<String> errors)
	{
		this.errors = errors;
	}

}

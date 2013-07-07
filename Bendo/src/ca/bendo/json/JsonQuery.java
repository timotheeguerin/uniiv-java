/**
 * 
 */
package ca.bendo.json;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.ObjectError;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>JsonQuery</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class JsonQuery
{
	/**
	 * 
	 */
	private boolean success;

	/**
	 * 
	 */
	private String message;

	/**
	 * 
	 */
	private List<String> errors = new ArrayList<String>();

	/**
	 * 
	 */
	public JsonQuery()
	{
	}

	/**
	 * @param message
	 *            success message
	 */
	public JsonQuery(final String message)
	{
		success = true;
		this.message = message;
	}

	/**
	 * @param errors
	 *            init errors with this
	 */
	public JsonQuery(final List<ObjectError> errors)
	{
		if (errors != null)
		{
			success = false;
			for (ObjectError error : errors)
			{
				this.errors.add(error.getDefaultMessage());
			}
		}
	}

	/**
	 * @return the success
	 */
	public boolean isSuccess()
	{
		return success;
	}

	/**
	 * @param success
	 *            the success to set
	 */
	public void setSuccess(final boolean success)
	{
		this.success = success;
	}

	/**
	 * @return the message
	 */
	public String getMessage()
	{
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(final String message)
	{
		this.message = message;
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

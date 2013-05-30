/**
 * 
 */
package ca.bendo.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>FormErrorHandler</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public final class FormErrorHandler
{
	/**
	 * 
	 */
	private Map<String, List<String>> errors = new HashMap<String, List<String>>();

	/**
	 * 
	 */
	private FormErrorHandler()
	{
		// 
	}

	/**
	 * 
	 * @param request
	 *            Load the error handler from the request
	 * @return formErrorHandler loaded from the request if it exist or a new
	 *         object
	 */
	public static FormErrorHandler getFormErrorHandler(final HttpServletRequest request)
	{
		FormErrorHandler handler = (FormErrorHandler) request.getAttribute("formErrorHandler");
		if (handler == null)
		{
			handler = new FormErrorHandler();
			request.setAttribute("formErrorHandler", handler);
		}

		return handler;
	}

	/**
	 * 
	 * @param key
	 *            key
	 * @param error
	 *            error
	 */
	public void addError(final String key, final String error)
	{
		List<String> errorsList = errors.get(key);
		if (errorsList == null)
		{
			errorsList = new ArrayList<String>();
			errors.put(key, errorsList);
		}
		errorsList.add(error);
	}

	/**
	 * @param <T>
	 *            class type
	 * @param clazz
	 *            claszz
	 * @param error
	 *            error
	 */
	public <T> void addError(final Class<T> clazz, final String error)
	{
		String key = clazz.getSimpleName();
		List<String> errorsList = errors.get(key);
		if (errorsList == null)
		{
			errorsList = new ArrayList<String>();
			errors.put(key, errorsList);
		}
		errorsList.add(error);
	}

	/**
	 * @param key
	 *            key
	 * @param list
	 *            errorlist
	 */
	public void addErrors(final String key, final List<String> list)
	{
		List<String> errorsList = errors.get(key);
		if (errorsList == null)
		{
			errorsList = new ArrayList<String>();
			errors.put(key, errorsList);
		}
		errorsList.addAll(list);
	}

	/**
	 * @param key
	 *            key
	 */
	public void clearErrors(final String key)
	{
		List<String> errorsList = errors.get(key);
		if (errorsList == null)
		{
			errorsList = new ArrayList<String>();
			errors.put(key, errorsList);
		}
		errorsList.clear();
	}

	/**
	 * 
	 * @param key
	 *            key
	 * @return the list of error with the given key
	 */
	public List<String> getErrors(final String key)
	{
		return errors.get(key);
	}

	/**
	 * @return the errors
	 */
	public Map<String, List<String>> getErrors()
	{
		return errors;
	}

	/**
	 * @param errors
	 *            the errors to set
	 */
	public void setErrors(final Map<String, List<String>> errors)
	{
		this.errors = errors;
	}

}

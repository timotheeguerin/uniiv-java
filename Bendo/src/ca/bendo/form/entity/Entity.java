/**
 * 
 */
package ca.bendo.form.entity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import ca.bendo.annotation.Input;
import ca.bendo.form.FieldValidator;
import ca.bendo.form.FormErrorHandler;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>Entity</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class Entity
{
	/**
	 * 
	 * @param request
	 *            Request
	 */
	public void setup(final HttpServletRequest request)
	{
		Field[] fields = getClass().getDeclaredFields();
		for (Field field : fields)
		{
			Input annotation = field.getAnnotation(Input.class);
			if (annotation != null)
			{
				String name = annotation.name();
				EntityType type = annotation.type();

				String value = request.getParameter(name);

				try
				{
					if (type != null)
					{
						value = checkType(value, type, request);
						long min = annotation.min();
						long max = annotation.max();
						if (!(value.length() >= min && value.length() <= max))
						{
							value = null;
						}
					}
					field.setAccessible(true);
					field.set(this, value);

				} catch (IllegalArgumentException e)
				{
					e.printStackTrace();
				} catch (IllegalAccessException e)
				{
					e.printStackTrace();
				} catch (SecurityException e)
				{
					e.printStackTrace();
				}

			}

		}
		for (Field field : fields)
		{
			Input annotation = field.getAnnotation(Input.class);
			if (annotation != null)
			{

				try
				{
					String linkto = annotation.linkto();

					if (linkto != null && !linkto.equals(""))
					{
						Field fieldCompare = getClass().getDeclaredField(linkto);
						field.setAccessible(true);
						fieldCompare.setAccessible(true);

						Object fieldVal = field.get(this);
						Object fieldCmpVal = fieldCompare.get(this);

						if (fieldVal != null && fieldCmpVal != null)
						{
							if (!(fieldVal.equals(fieldCmpVal)))
							{
								field.set(this, null);
							}
						}

					}

				} catch (IllegalArgumentException e)
				{
					e.printStackTrace();
				} catch (IllegalAccessException e)
				{
					e.printStackTrace();
				} catch (NoSuchFieldException e)
				{
					e.printStackTrace();
				} catch (SecurityException e)
				{

					e.printStackTrace();
				}

			}

		}
	}

	/**
	 * Check if all the fields are set.
	 * 
	 * @return if the entity is valid
	 */
	public boolean isValid()
	{
		Field[] fields = getClass().getDeclaredFields();
		for (Field field : fields)
		{
			try
			{
				field.setAccessible(true);
				Object value = field.get(this);

				// If the field is null(not set) then its invalid
				if (value == null)
				{
					return false;
				}

				if (value instanceof List<?>)
				{
					@SuppressWarnings("unchecked")
					List<Object> list = (List<Object>) value;
					for (Object o : list)
					{
						if (o == null)
						{
							return false;
						}
					}
				}

				if (value instanceof Map<?, ?>)
				{
					@SuppressWarnings("unchecked")
					Map<Object, Object> map = (Map<Object, Object>) value;
					for (Entry<Object, Object> entry : map.entrySet())
					{
						if (entry.getValue() == null)
						{
							return false;
						}
					}
				}

			} catch (IllegalArgumentException e)
			{
				e.printStackTrace();
				return false;
			} catch (IllegalAccessException e)
			{
				e.printStackTrace();
				return false;
			}
		}

		return true;
	}

	/**
	 * @param request
	 *            Request
	 */
	public void setupErrorsDisplay(final HttpServletRequest request)
	{

		Translator translator = (Translator) request.getAttribute("translator");
		Long languageId = (Long) request.getAttribute("languageId");
		List<String> errors = new ArrayList<String>();
		Field[] fields = getClass().getDeclaredFields();

		for (Field field : fields)
		{
			Input annotation = field.getAnnotation(Input.class);
			if (annotation != null)
			{
				try
				{
					field.setAccessible(true);
					Object value = field.get(this);
					// If the field is null(not set) then its invalid
					if (value == null)
					{

						String error = translator.translate("form_error_" + annotation.name(), languageId);

						errors.add(error);
					}

				} catch (IllegalArgumentException e)
				{
					e.printStackTrace();

				} catch (IllegalAccessException e)
				{
					e.printStackTrace();

				}
			}
		}

		FormErrorHandler errorHandler = FormErrorHandler.getFormErrorHandler(request);
		errorHandler.addErrors(getClass().getSimpleName(), errors);
	}

	/**
	 * @param request
	 *            Request
	 */
	public void setupForDisplay(final HttpServletRequest request)
	{
		Field[] fields = getClass().getDeclaredFields();
		for (Field field : fields)
		{
			Input annotation = field.getAnnotation(Input.class);
			if (annotation != null)
			{
				String name = annotation.name();

				String value = request.getParameter(name);

				try
				{
					field.setAccessible(true);
					field.set(this, value);

				} catch (IllegalArgumentException e)
				{

					e.printStackTrace();
				} catch (IllegalAccessException e)
				{
					e.printStackTrace();
				} catch (SecurityException e)
				{
					e.printStackTrace();
				}

			}

		}

	}

	/**
	 * @param value
	 *            to check
	 * @param type
	 *            of the value
	 * @param request
	 *            request
	 * @return value if its of the given type
	 */
	private String checkType(final String value, final EntityType type, final HttpServletRequest request)
	{
		boolean condition = true;
		String returnVal = value;
		switch (type)
		{
		case PASSWORD:
			condition = FieldValidator.isPassword(value);
			break;
		case NAME:
			condition = FieldValidator.isName(value);
			break;
		case EMAIL:
			condition = FieldValidator.isEmail(value);
			break;
		case COMMENT:
			condition = FieldValidator.isComment(value);
			break;
		case NUMERIC:
			condition = FieldValidator.isInt(value);
			break;
		case ALPHANUMERIC:
			condition = FieldValidator.isAlphaNumeric(value);
			break;
		case CODE:
			condition = FieldValidator.isCode(value);
			break;
		case CAPTCHA:
			condition = FieldValidator.checkCaptcha(request);
			returnVal = "recaptcha_succes";
			break;
		default:
			break;
		}

		if (condition)
		{
			return returnVal;
		} else
		{
			return null;
		}
	}
}

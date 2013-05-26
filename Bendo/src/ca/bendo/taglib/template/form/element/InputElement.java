/**
 * 
 */
package ca.bendo.taglib.template.form.element;

import javax.servlet.jsp.PageContext;

import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>InputElement</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class InputElement extends FormElement
{

	/**
	 * Form element name.
	 */
	private String name = "";

	/**
	 * Form element type(text,password,email,...).
	 */
	private String type = "text";

	/**
	 * Form element default value.
	 */
	private String value = "";

	/**
	 * Form element title.
	 */
	private String title = "";

	/**
	 * 
	 */
	private String pattern;

	/**
	 * 
	 */
	private boolean required;

	/**
	 * 
	 */
	private String placeholder;
	/**
	 * 
	 */
	private boolean needValidation = false;

	/**
	 * @param translator
	 *            Translator
	 * @param pageContext
	 *            PageContext
	 */
	public InputElement(final Translator translator, final PageContext pageContext)
	{
		super(translator, pageContext);

		// Set default values
		setName("");
		setTitle("");
		setValue("");
		setType("text");
		setNeedValidation(false);
	}

	@Override
	public final StringBuilder render()
	{
		StringBuilder result = new StringBuilder();

		String requiredStr = "";
		if (required)
		{
			requiredStr = "required='required'";
		}

		String patternStr = "";
		if (pattern != null)
		{
			patternStr = "pattern='" + pattern + "'";
		}

		String titleStr = "";
		if (title != null)
		{
			titleStr = "title='" + title + "'";
		}

		String placeholderStr = "";
		if (placeholderStr != null)
		{
			placeholderStr = "placeholder='" + placeholder + "'";
		}
		result.append("<input type='" + getType() + "' class='' name='" + getName() + "' value='" + getValue() + "'"
				+ requiredStr + " " + patternStr + " " + placeholderStr + " " + titleStr + " />");

		return result;
	}

	/**
	 * @return the name
	 * 
	 */
	public final String getName()
	{
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 * 
	 */
	public final void setName(final String name)
	{
		this.name = name;
	}

	/**
	 * @return the type
	 * 
	 */
	public final String getType()
	{
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 * 
	 */
	public final void setType(final String type)
	{
		this.type = type;
	}

	/**
	 * @return the value
	 * 
	 */
	public final String getValue()
	{
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 * 
	 */
	public final void setValue(final String value)
	{
		this.value = value;
	}

	/**
	 * @return the title
	 * 
	 */
	public final String getTitle()
	{
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 * 
	 */
	public final void setTitle(final String title)
	{
		this.title = title;
	}

	/**
	 * @return the needValidation
	 * 
	 */
	public final boolean isNeedValidation()
	{
		return needValidation;
	}

	/**
	 * @param needValidation
	 *            the needValidation to set
	 * 
	 */
	public final void setNeedValidation(final boolean needValidation)
	{
		this.needValidation = needValidation;
	}

	/**
	 * @return the pattern
	 */
	public String getPattern()
	{
		return pattern;
	}

	/**
	 * @param pattern
	 *            the pattern to set
	 */
	public void setPattern(final String pattern)
	{
		this.pattern = pattern;
	}

	/**
	 * @return the required
	 */
	public final boolean isRequired()
	{
		return required;
	}

	/**
	 * @param required
	 *            the required to set
	 */
	public final void setRequired(final boolean required)
	{
		this.required = required;
	}

	/**
	 * @return the placeholder
	 */
	public final String getPlaceholder()
	{
		return placeholder;
	}

	/**
	 * @param placeholder
	 *            the placeholder to set
	 */
	public final void setPlaceholder(String placeholder)
	{
		this.placeholder = placeholder;
	}

}

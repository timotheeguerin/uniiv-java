/**
 * 
 */
package ca.bendo.taglib.tag.form.input.password;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import ca.bendo.db.entity.lang.Language;
import ca.bendo.form.FieldValidator;
import ca.bendo.taglib.template.form.element.InputElement;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>PasswordTag</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class PasswordTag extends TagSupport
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3700149684255872040L;

	/**
	 * 
	 */
	private String name = "password";

	/**
	 * 
	 */
	private String value = "";

	/**
	 * 
	 */
	private String placeholder;
	/**
	 * 
	 */
	private boolean required = false;

	@Override
	public final int doStartTag() throws JspException
	{

		try
		{
			// Get the writer object for output.
			JspWriter out = pageContext.getOut();

			Translator translator = (Translator) pageContext.getRequest().getAttribute("translator");
			Long languageId = Language.loadId((HttpServletRequest) pageContext.getRequest());

			pageContext.getRequest();

			InputElement password = new InputElement(translator, pageContext);
			password.setName(name);
			password.setType("password");
			password.setTitle(translator.translate("password_format", languageId));
			password.setRequired(required);
			password.setPlaceholder(translator.translate(placeholder, languageId));
			password.setPattern(FieldValidator.PASSWORD_REGEX);
			password.setValue(value);

			out.println(password.render());

		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	/**
	 * @return the name
	 */
	public final String getName()
	{
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public final void setName(final String name)
	{
		this.name = name;
	}

	/**
	 * @return the value
	 */
	public final String getValue()
	{
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public final void setValue(final String value)
	{
		this.value = value;
	}

	/**
	 * @return the required
	 */
	public boolean isRequired()
	{
		return required;
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
	public final void setPlaceholder(final String placeholder)
	{
		this.placeholder = placeholder;
	}

	/**
	 * @param required
	 *            the required to set
	 */
	public void setRequired(final boolean required)
	{
		this.required = required;
	}

}

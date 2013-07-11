/**
 * 
 */
package ca.bendo.taglib.tag.form.input;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import ca.bendo.taglib.template.form.element.InputElement;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>InputElementTag</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class InputElementTag extends TagSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -517406520002658953L;

	/**
	 * Form element name.
	 */
	private String name = "";

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(final String name)
	{
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public String getType()
	{
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(final String type)
	{
		this.type = type;
	}

	/**
	 * @return the value
	 */
	public String getValue()
	{
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(final String value)
	{
		this.value = value;
	}

	/**
	 * @return the title
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(final String title)
	{
		this.title = title;
	}

	/**
	 * @return the needValidation
	 */
	public boolean isNeedValidation()
	{
		return needValidation;
	}

	/**
	 * @param needValidation
	 *            the needValidation to set
	 */
	public void setNeedValidation(final boolean needValidation)
	{
		this.needValidation = needValidation;
	}

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
	private boolean needValidation = false;

	@Override
	public int doStartTag() throws JspException
	{

		try
		{
			// Get the writer object for output.
			JspWriter out = pageContext.getOut();

			Translator translator = (Translator) pageContext.getRequest().getAttribute("translator");

			pageContext.getRequest();

			InputElement e = new InputElement(translator, pageContext);
			e.setCustclass("");
			e.setName(name);
			e.setNeedValidation(needValidation);
			e.setTitle(title);
			e.setType(type);
			e.setValue(value);

			out.println(e.render());

		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

}

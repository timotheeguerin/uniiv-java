/**
 * 
 */
package ca.bendo.taglib.tag.form.input;

import java.io.IOException;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import ca.bendo.taglib.template.form.element.Select;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>SelectTag</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class SelectTag extends TagSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3886846415710595134L;
	/**
	 * 
	 */
	private String title;
	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	private Map<Object, String> options;

	@Override
	public int doStartTag() throws JspException
	{

		try
		{
			// Get the writer object for output.
			JspWriter out = pageContext.getOut();

			Translator translator = (Translator) pageContext.getRequest().getAttribute("translator");

			Select select = new Select(translator, pageContext);
			select.setName(getName());
			select.setTitle(getTitle());
			select.setOptions(getOptions());
			out.println(select.render());

		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return SKIP_BODY;
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
	 * @return the options
	 */
	public Map<Object, String> getOptions()
	{
		return options;
	}

	/**
	 * @param options
	 *            the options to set
	 */
	public void setOptions(final Map<Object, String> options)
	{
		this.options = options;
	}
}

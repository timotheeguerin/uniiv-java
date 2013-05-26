/**
 * 
 */
package ca.bendo.taglib.tag.dropdown;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import ca.bendo.taglib.template.dropdown.DropdownElement;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>DropdownElementTqg</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class DropdownElementTag extends BodyTagSupport
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3648289210795291412L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.BodyTagSupport#doAfterBody()
	 */
	@Override
	public final int doEndTag() throws JspException
	{
		try
		{
			// Get the writer object for output.
			JspWriter out = pageContext.getOut();

			Translator translator = (Translator) pageContext.getRequest().getAttribute("translator");

			DropdownElement element = new DropdownElement(translator, pageContext);
			element.setBody(getBodyContent().getString());
			out.println(element.render());

		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return super.doEndTag();
	}

}

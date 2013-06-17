/**
 * 
 */
package ca.bendo.taglib.tag.dropdown;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import ca.bendo.taglib.template.dropdown.DropdownContent;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>DropdownContentTag</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class DropdownContentTag extends BodyTagSupport
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8751947005450994950L;

	/**
	 * 
	 */
	public DropdownContentTag()
	{
		//
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.BodyTagSupport#doAfterBody()
	 */
	@Override
	public int doEndTag() throws JspException
	{
		try
		{
			// Get the writer object for output.
			JspWriter out = pageContext.getOut();

			Translator translator = (Translator) pageContext.getRequest().getAttribute("translator");

			DropdownContent content = new DropdownContent(translator, pageContext);
			content.setBody(getBodyContent().getString());
			out.println(content.render());

		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return super.doEndTag();
	}

}

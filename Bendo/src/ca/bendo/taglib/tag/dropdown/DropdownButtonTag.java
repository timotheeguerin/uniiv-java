/**
 * 
 */
package ca.bendo.taglib.tag.dropdown;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import ca.bendo.taglib.template.dropdown.DropdownButton;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>DropdownButtonTag</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class DropdownButtonTag extends BodyTagSupport
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1298897092830067847L;

	/**
	 * 
	 */
	public DropdownButtonTag()
	{
		// TODO Auto-generated constructor stub
	}

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

			DropdownButton button = new DropdownButton(translator, pageContext);
			button.setBody(getBodyContent().getString());
			out.println(button.render());

		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return super.doEndTag();
	}

}

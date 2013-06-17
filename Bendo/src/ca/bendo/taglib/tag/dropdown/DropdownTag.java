/**
 * 
 */
package ca.bendo.taglib.tag.dropdown;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import ca.bendo.taglib.template.dropdown.Dropdown;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>DropdownTag</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class DropdownTag extends BodyTagSupport
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2518309766514810042L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.BodyTagSupport#doEndTag()
	 */
	@Override
	public int doEndTag() throws JspException
	{
		try
		{
			// Get the writer object for output.
			JspWriter out = pageContext.getOut();

			Translator translator = (Translator) pageContext.getRequest().getAttribute("translator");

			Dropdown drop = new Dropdown(translator, pageContext);
			drop.setBody(getBodyContent().getString());
			out.println(drop.render());

		} catch (IOException e)
		{
			e.printStackTrace();
		}

		return super.doEndTag();
	}
}

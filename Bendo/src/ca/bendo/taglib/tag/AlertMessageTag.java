/**
 * 
 */
package ca.bendo.taglib.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import ca.bendo.taglib.template.alert.AlertMessagesContainer;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>AlertMessageTag</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class AlertMessageTag extends TagSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7120245906928121299L;

	@Override
	public int doStartTag() throws JspException
	{

		try
		{
			// Get the writer object for output.
			JspWriter out = pageContext.getOut();

			Translator translator = (Translator) pageContext.getRequest().getAttribute("translator");
			AlertMessagesContainer container = new AlertMessagesContainer(translator, pageContext);

			out.println(container.render());

		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

}

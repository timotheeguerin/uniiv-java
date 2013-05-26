/**
 * 
 */
package ca.bendo.taglib.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>QuickSearchBarTag</b>
 *          <p>
 *          Tag that display an quick search bar
 *          </p>
 * @see TagSupport
 * 
 */
public class QuickSearchBarTag extends TagSupport
{
	/**
		 * 
		 */
	private static final long serialVersionUID = 4204319554798069995L;

	@Override
	public final int doStartTag() throws JspException
	{

		try
		{
			// Get the writer object for output.
			JspWriter out = pageContext.getOut();

			// out.println("<div>");
			out.println("<form id='search_form' action='#' method='post'>");
			out.println("<input type='search-section' id='h_search_section' class='search_section' name='search_input' id='search_input' title='Search'/>");
			out.println("<input type='submit' id='h_submit_icon' class='submit_icon'name='search_icon' id='search_input' title='Search icon' value=''/>");
			out.println("</form>");

		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
}

/**
 * 
 */
package ca.bendo.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>DropdownButtonTag</b>
 *          <p>
 *          </p>
 * @see Filter
 * 
 */
public class DropdownButtonTag extends BodyTagSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4581310987926875924L;
	/**
	 * 
	 */
	private Boolean dropdown = true;
	/**
	 * 
	 */
	private String custclass = "";
	/**
	 * 
	 */
	private String link;
	/**
	 * 
	 */
	private String value;

	@Override
	public final int doAfterBody() throws JspException
	{
		try
		{

			BodyContent bc = getBodyContent();

			String body = bc.getString();
			JspWriter out = bc.getEnclosingWriter();
			out.println("<div class='dropdown_button " + getCustclass() + "'>");
			out.println("<a class='dropdown_button button_link' href='" + getLink() + "'><span class='box_text'>"
					+ getValue() + "</span></a>");
			if (dropdown)
			{
				out.println(body);
			}
			out.println("</div>");

		} catch (IOException ioe)
		{
			throw new JspException("Error: " + ioe.getMessage());
		}
		return SKIP_BODY;
	}

	/**
	 * @return the dropdown
	 */
	public final Boolean getDropdown()
	{
		return dropdown;
	}

	/**
	 * @param dropdown
	 *            the dropdown to set
	 * 
	 */
	public final void setDropdown(final Boolean dropdown)
	{
		this.dropdown = dropdown;
	}

	/**
	 * @return the custclass
	 * 
	 */
	public final String getCustclass()
	{
		return custclass;
	}

	/**
	 * @param custclass
	 *            the custclass to set
	 * 
	 */
	public final void setCustclass(final String custclass)
	{
		this.custclass = custclass;
	}

	/**
	 * @return the link
	 * 
	 */
	public final String getLink()
	{
		return link;
	}

	/**
	 * @param link
	 *            the link to set
	 * 
	 */
	public final void setLink(final String link)
	{
		this.link = link;
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
}

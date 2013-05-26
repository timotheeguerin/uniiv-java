/**
 * 
 */
package ca.bendo.taglib.tag.form.input;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * @author Timoth�e Gu�rin
 * @version Bendo
 * 
 *          <b>TextArea</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class TextAreaTag extends TagSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private String name = "";

	/**
	 * 
	 */
	private String clazz = "";

	/**
	 * 
	 */
	private String content = "";

	/**
	 * 
	 */
	private int maxlength = -1;

	/**
	 * 
	 */
	private String counterId;

	@Override
	public final int doStartTag() throws JspException
	{

		try
		{
			// Get the writer object for output.
			JspWriter out = pageContext.getOut();

			StringBuilder result = new StringBuilder();
			String maxLenthStr = "";
			if (maxlength != -1)
			{
				maxLenthStr = "maxlength='" + maxlength + "'";
			}

			String counterIdStr = "data-counterId='" + counterId + "'";

			result.append("<textarea name='" + name + "' class='" + clazz + "' " + maxLenthStr + " " + counterIdStr
					+ ">");
			result.append(StringEscapeUtils.escapeHtml(content));
			result.append("</textarea>");

			out.println(result);

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
	 * @return the clazz
	 */
	public final String getClazz()
	{
		return clazz;
	}

	/**
	 * @param clazz
	 *            the clazz to set
	 */
	public final void setClazz(final String clazz)
	{
		this.clazz = clazz;
	}

	/**
	 * @return the content
	 */
	public final String getContent()
	{
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public final void setContent(final String content)
	{
		this.content = content;
	}

	/**
	 * @return the maxlength
	 */
	public final int getMaxlength()
	{
		return maxlength;
	}

	/**
	 * @param maxlength
	 *            the maxlength to set
	 */
	public final void setMaxlength(final int maxlength)
	{
		this.maxlength = maxlength;
	}

	/**
	 * @return the counterId
	 */
	public final String getCounterId()
	{
		return counterId;
	}

	/**
	 * @param counterId
	 *            the counterId to set
	 */
	public final void setCounterId(final String counterId)
	{
		this.counterId = counterId;
	}

}

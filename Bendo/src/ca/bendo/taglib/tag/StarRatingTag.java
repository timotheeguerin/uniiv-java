/**
 * 
 */
package ca.bendo.taglib.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import ca.bendo.db.entity.lang.Language;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>StarRatingTag</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class StarRatingTag extends TagSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3346165934056625736L;
	/**
	 * 
	 */
	private static final int RATING_NUMBER = 5;
	/**
	 * 
	 */
	private String name;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	@Override
	public int doStartTag() throws JspException
	{

		JspWriter out = pageContext.getOut();
		Translator translator = (Translator) pageContext.getRequest().getAttribute("translator");
		Long lanuageId = Language.loadId((HttpServletRequest) pageContext.getRequest());
		StringBuilder result = new StringBuilder();
		result.append("<div class='star_rating_content'>");

		result.append("<div class='star_rating'>");
		for (int i = RATING_NUMBER; i > 0; i--)
		{
			String id = name + "_" + i;
			result.append("<input id='" + id + "' type='radio' name='" + name + "' value='" + i + "'/>");
			String title = translator.translate("rating_star_" + i, lanuageId);
			result.append("<label title='" + title + "' for='" + id + "'> &#9733 ");
			result.append("</label>");
		}
		result.append("</div></div>");
		try
		{
			out.print(result);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return SKIP_BODY;
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

}

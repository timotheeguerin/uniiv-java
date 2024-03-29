/**
 * 
 */
package ca.bendo.taglib.tag.form;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import ca.bendo.db.entity.lang.Language;
import ca.bendo.translation.translation.Translator;
import ca.bendo.utils.url.UrlFactory;

/**
 * @author Timoth�e Gu�rin
 * @version Bendo
 * 
 *          <b>SearchBarTag</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class SearchBarTag extends TagSupport
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2228885444032739124L;

	/**
	 * 
	 */
	private String placeholder;

	/**
	 * 
	 */
	private String type;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	@Override
	public int doStartTag() throws JspException
	{

		try
		{
			// Get the writer object for output.
			JspWriter out = pageContext.getOut();

			pageContext.getRequest().getAttribute("translator");

			pageContext.getRequest();
			String action = "action='" + getFormUrl() + "'";
			StringBuilder result = new StringBuilder();
			result.append("<form method='GET' " + action + ">");
			result.append(getInputBar());
			result.append(getSearchButton());
			result.append("</form>");
			out.println(result);

		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	/**
	 * 
	 * @return String
	 */
	private StringBuilder getInputBar()
	{

		Translator translator = (Translator) pageContext.getRequest().getAttribute("translator");
		if (translator == null)
		{
			return new StringBuilder();
		}
		StringBuilder result = new StringBuilder();

		String placeholderStr = "placeholder='" + translator.translate(placeholder) + "'";
		String ajaxUrl = "data-ajax-href='" + getFormUrl() + "/ajaxlist' ";
		result.append("<input name='query' type='text' class='quickfind_bar searchAutcomplete'");
		result.append(placeholderStr).append(" ");
		result.append(ajaxUrl);
		result.append("/>");

		return result;
	}

	/**
	 * 
	 * @return String
	 */
	private StringBuilder getSearchButton()
	{

		Translator translator = (Translator) pageContext.getRequest().getAttribute("translator");
		if (translator == null)
		{
			return new StringBuilder();
		}
		StringBuilder result = new StringBuilder();
		String value = "value='" + translator.translate("search") + "'";
		result.append("<input name='submitbtn' class='quickfind_tool' type='submit' ");
		result.append(value).append(" ");
		result.append("/>");

		return result;
	}

	/**
	 * 
	 * @return the form url given the type
	 */
	private String getFormUrl()
	{
		Translator translator = (Translator) pageContext.getRequest().getAttribute("translator");
		if (translator == null)
		{
			return "";
		}
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();

		String value = "";
		if (type == null)
		{
			return "";
		} else if (type.equalsIgnoreCase("all"))
		{
			value = translator.translateUrl("/search/all/");
		} else if (type.equalsIgnoreCase("university"))
		{
			value = translator.translateUrl("/search/university/");
		} else if (type.equalsIgnoreCase("professor"))
		{
			value = translator.translateUrl("/search/professor/");
		} else if (type.equalsIgnoreCase("course"))
		{
			value = translator.translateUrl("/search/course/");
		}
		String url = UrlFactory.getUrl(value, request);
		return url;
	}

	/**
	 * @return the placeholder
	 */
	public String getPlaceholder()
	{
		return placeholder;
	}

	/**
	 * @param placeholder
	 *            the placeholder to set
	 */
	public void setPlaceholder(final String placeholder)
	{
		this.placeholder = placeholder;
	}

	/**
	 * @return the type
	 */
	public String getType()
	{
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(final String type)
	{
		this.type = type;
	}

}

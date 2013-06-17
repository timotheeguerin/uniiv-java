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
 * @author Timothée Guérin
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
		Long lanuageId = Language.loadId((HttpServletRequest) pageContext.getRequest());
		StringBuilder result = new StringBuilder();

		String placeholderStr = "placeholder='" + translator.translate(placeholder, lanuageId) + "'";
		String ajaxUrl = "data-ajax-href='" + getFormUrl() + "/ajaxlist' ";
		result.append("<input name='query' type='text' class='SubmitSearchUniProfCourse searchAutcomplete'");
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
		StringBuilder result = new StringBuilder();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		Long languageId = Language.loadId(request);
		String value = "value='" + translator.translate("search", languageId) + "'";
		result.append("<input name='submitbtn' class='btn_get_started_text' type='submit' ");
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
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		Long languageId = Language.loadId(request);
		String value = "";
		if (type == null)
		{
			return "";
		} else if (type.equalsIgnoreCase("all"))
		{
			value = translator.translateUrl("/search/all/", languageId);
		} else if (type.equalsIgnoreCase("university"))
		{
			value = translator.translateUrl("/search/university/", languageId);
		} else if (type.equalsIgnoreCase("professor"))
		{
			value = translator.translateUrl("/search/professor/", languageId);
		} else if (type.equalsIgnoreCase("course"))
		{
			value = translator.translateUrl("/search/course/", languageId);
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

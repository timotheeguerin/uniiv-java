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
 *          <b>UrlTag</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class UrlTag extends TagSupport
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7753930890867768691L;
	/**
	 * Value to translate.
	 */
	private String value;

	/**
	 * 
	 */
	private String var;

	@Override
	public int doStartTag() throws JspException
	{
		JspWriter out = pageContext.getOut();

		Translator translator = Translator.getTranslator((HttpServletRequest) pageContext.getRequest());

		Long languageId = Language.loadId((HttpServletRequest) pageContext.getRequest());
		String result = "";
		if (translator != null)

		{
			result = url(translator.translateUrl(value, languageId));
		}
		try
		{
			if (var != null && var != "")
			{
				pageContext.setAttribute(var, result);
			} else
			{
				out.print(result);
			}
		} catch (IOException e)
		{

			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	/**
	 * @return the value
	 */
	public String getValue()
	{
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(final String value)
	{
		this.value = value;
	}

	/**
	 * @return the var
	 */
	public String getVar()
	{
		return var;
	}

	/**
	 * @param var
	 *            the var to set
	 */
	public void setVar(final String var)
	{
		this.var = var;
	}

	/**
	 * Function to get the real url.
	 * 
	 * @param url
	 *            Url to translate
	 * @return the real url
	 */
	public String url(final String url)
	{
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		if (url.startsWith("/"))
		{
			return request.getContextPath() + url;
		} else
		{
			return url;
		}
	}
}

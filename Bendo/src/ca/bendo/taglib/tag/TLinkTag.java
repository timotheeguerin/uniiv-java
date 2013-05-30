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
 *          <b>TranslatorTag</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class TLinkTag extends TagSupport
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7753930890867768691L;
	/**
	 * Value to translate.
	 */
	private String value;

	@Override
	public final int doStartTag() throws JspException
	{
		JspWriter out = pageContext.getOut();

		Translator translator = Translator.getTranslator((HttpServletRequest) pageContext.getRequest());
		Long languageId = Language.loadId((HttpServletRequest) pageContext.getRequest());
		String result = "";
		result = url(translator.getLink(value, languageId));
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
	 * @return the value
	 */
	public final String getValue()
	{
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public final void setValue(final String value)
	{
		this.value = value;
	}

	/**
	 * Function to get the real url.
	 * 
	 * @param url
	 *            Url to translate
	 * @return the real url
	 */
	public final String url(final String url)
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

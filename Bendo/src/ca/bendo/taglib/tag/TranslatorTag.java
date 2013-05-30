/**
 * 
 */
package ca.bendo.taglib.tag;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
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
public class TranslatorTag extends TagSupport implements DynamicAttributes
{

	/**
	 * Value to translate.
	 */
	private String value;
	/**
	 * 
	 */
	private static final long serialVersionUID = -788583753512759302L;
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */

	/**
	 * Custom tag attributes containg any properties to add to the translation.
	 */
	private Map<String, Object> tagAttributes = new HashMap<String, Object>();

	@Override
	public final int doStartTag() throws JspException
	{
		JspWriter out = pageContext.getOut();
		Translator trans = (Translator) pageContext.getRequest().getAttribute("translator");
		Long languageId = Language.loadId((HttpServletRequest) pageContext.getRequest());
		String result = "";
		if (tagAttributes.size() > 0)
		{
			if (trans != null)
			{
				result = trans.translate(getValue(), languageId, tagAttributes);
			}
		} else
		{
			if (trans != null)
			{
				result = trans.translate(getValue(), languageId);
			}
		}
		try
		{
			out.print(result);
		} catch (IOException e)
		{
		
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.jsp.tagext.DynamicAttributes#setDynamicAttribute(java.lang
	 * .String, java.lang.String, java.lang.Object)
	 */
	@Override
	public final void setDynamicAttribute(final String uri, final String key, final Object obj) throws JspException
	{
		tagAttributes.put(key, obj);
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

}

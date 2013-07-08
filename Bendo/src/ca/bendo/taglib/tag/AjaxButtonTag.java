/**
 * 
 */
package ca.bendo.taglib.tag;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.TagSupport;

import ca.bendo.db.entity.lang.Language;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>AjaxButtonTag</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class AjaxButtonTag extends TagSupport implements DynamicAttributes
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -788583753512759302L;

	/**
	 * 
	 */
	private String url;

	/**
	 * 
	 */
	private String value;

	/**
	 * 
	 */
	private boolean checked;

	/**
	 * Custom tag attributes containg any properties to add to the translation.
	 */
	private Map<String, Object> tagAttributes = new HashMap<String, Object>();

	@Override
	public int doStartTag() throws JspException
	{
		Translator tranlator = (Translator) pageContext.getRequest().getAttribute("translator");
		Long languageId = Language.loadId((HttpServletRequest) pageContext.getRequest());
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		request.setAttribute("msg_default", tranlator.translate(value, languageId));
		request.setAttribute("msg_hover", tranlator.translate(value + ".hover", languageId));
		request.setAttribute("msg_check", tranlator.translate(value + ".check", languageId));
		request.setAttribute("msg_check_hover", tranlator.translate(value + ".check.hover", languageId));
		request.setAttribute("url", url);

		StringBuilder customTags = new StringBuilder();
		for (Entry<String, Object> tag : tagAttributes.entrySet())
		{
			if (tag.getValue() != null)
			{
				String val = tag.getValue().toString();
				if (!val.equalsIgnoreCase(""))
				{
					customTags.append(tag.getKey()).append("=").append(val).append(" ");
				}
			}
		}
		request.setAttribute("customTags", customTags.toString());

		if (checked)
		{
			request.setAttribute("state", "checked");
		} else
		{
			request.setAttribute("state", "default");
		}

		try
		{
			pageContext.include("/WEB-INF/jsp/tags/ajaxbutton.jsp");
		} catch (ServletException | IOException e)
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
	public void setDynamicAttribute(final String uri, final String key, final Object obj) throws JspException
	{
		tagAttributes.put(key, obj);
	}

	/**
	 * @return the url
	 */
	public String getUrl()
	{
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(final String url)
	{
		this.url = url;
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
	 * @return the checked
	 */
	public boolean isChecked()
	{
		return checked;
	}

	/**
	 * @param checked
	 *            the checked to set
	 */
	public void setChecked(final boolean checked)
	{
		this.checked = checked;
	}

}

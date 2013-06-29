/**
 * 
 */
package ca.bendo.taglib.tag.form;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import ca.bendo.db.entity.lang.Language;
import ca.bendo.form.entity.FormItem;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TranslateLabelsTag</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class TranslateLabelsTag extends TagSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8038161378429221876L;

	/**
	 * 
	 */
	private String var;

	/**
	 * 
	 */
	private String value;

	/**
	 * Value to translate.
	 */
	private List<FormItem> items;

	@Override
	public int doStartTag() throws JspException
	{
		JspWriter out = pageContext.getOut();
		Translator trans = (Translator) pageContext.getRequest().getAttribute("translator");
		Long languageId = Language.loadId((HttpServletRequest) pageContext.getRequest());

		List<FormItem> itemsCpy = new ArrayList<FormItem>(items);
		for (FormItem item : itemsCpy)
		{
			String label = "";
			if (value != null && !value.equalsIgnoreCase(""))
			{
				label = value + "." + item.getValue();
				if (trans != null)
				{
					label = trans.translate(label, languageId);
				}
			} else
			{
				label = String.valueOf(item.getValue());
			}
			item.setLabel(label);
		}

		pageContext.setAttribute(var, itemsCpy);
		return SKIP_BODY;
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
	 * @return the items
	 */
	public List<FormItem> getItems()
	{
		return items;
	}

	/**
	 * @param items
	 *            the items to set
	 */
	public void setItems(final List<FormItem> items)
	{
		this.items = items;
	}

}

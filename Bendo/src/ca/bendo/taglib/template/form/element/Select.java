/**
 * 
 */
package ca.bendo.taglib.template.form.element;

import java.util.Map;

import javax.servlet.jsp.PageContext;

import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>DropInput</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class Select extends FormElement
{
	/**
	 * 
	 */
	private String title;
	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	private Map<Object, String> options;

	/**
	 * @param translator
	 *            Translator
	 * @param pageContext
	 *            Pagecontext
	 */
	public Select(final Translator translator, final PageContext pageContext)
	{
		super(translator, pageContext);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.bendo.taglib.template.TagTemplate#render()
	 */
	@Override
	public StringBuilder render()
	{
		StringBuilder result = new StringBuilder();
		result.append("<div class='form_fields " + getCustclass() + "'>");
		// Display the label only if it exist
		if (getTitle() != "" && getTitle() != null && getTitle() != "null")
		{
			result.append("<label for='" + getName() + "' >" + getTitle() + "</label>");
		}
		result.append("<select name=" + getName() + ">");
		for (Object key : options.keySet())
		{
			String value = options.get(key);
			result.append("<option value=" + key + ">" + value);
			result.append("</option>");
		}
		result.append("</select>");

		result.append("</div>");
		return result;
	}

	/**
	 * @return the title
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(final String title)
	{
		this.title = title;
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

	/**
	 * @return the options
	 */
	public Map<Object, String> getOptions()
	{
		return options;
	}

	/**
	 * @param options
	 *            the options to set
	 */
	public void setOptions(final Map<Object, String> options)
	{
		this.options = options;
	}

}

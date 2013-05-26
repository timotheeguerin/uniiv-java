/**
 * 
 */
package ca.bendo.taglib.template;

import javax.servlet.jsp.PageContext;

import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>DropdownMenu</b>
 *          <p>
 *          </p>
 * @see Filter
 * 
 */
public class DropdownButton extends TagTemplate
{

	/**
	 * 
	 */
	private Boolean dropdown;
	/**
	 * 
	 */
	private String link;
	/**
	 * 
	 */
	private String value;
	/**
	 * 
	 */
	private StringBuilder dropdownContent;

	/**
	 * @param translator
	 *            Translator
	 * @param pageContext
	 *            PageContext
	 */
	public DropdownButton(final Translator translator, final PageContext pageContext)
	{
		super(translator, pageContext);
		setDropdown(true);
		setLink("");
		setValue("");
	}

	@Override
	public final StringBuilder render()
	{
		StringBuilder result = new StringBuilder();

		result.append("<div class='dropdown_button " + getCustclass() + "'>");
		result.append("<a class='dropdown_button button_link' href='" + getLink() + "'><div class='box_text'>"
				+ getValue() + "</div></a>");
		result.append("<div class='dropdown_content'>");
		if (dropdown)
		{
			result.append(getDropdownContent());
		}
		result.append("</div></div>");

		return result;
	}

	/**
	 * @return the dropdown
	 */
	public final Boolean getDropdown()
	{
		return dropdown;
	}

	/**
	 * @param dropdown
	 *            the dropdown to set
	 * 
	 */
	public final void setDropdown(final Boolean dropdown)
	{
		this.dropdown = dropdown;
	}

	/**
	 * @return the link
	 * 
	 */
	public final String getLink()
	{
		return link;
	}

	/**
	 * @param link
	 *            the link to set
	 * 
	 */
	public final void setLink(final String link)
	{
		this.link = link;
	}

	/**
	 * @return the value
	 * 
	 */
	public final String getValue()
	{
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 * 
	 */
	public final void setValue(final String value)
	{
		this.value = value;
	}

	/**
	 * @return the dropdownContent
	 * 
	 */
	public final StringBuilder getDropdownContent()
	{
		return dropdownContent;
	}

	/**
	 * @param dropdownContent
	 *            the dropdownContent to set
	 * 
	 */
	public final void setDropdownContent(final StringBuilder dropdownContent)
	{
		this.dropdownContent = dropdownContent;
	}

}

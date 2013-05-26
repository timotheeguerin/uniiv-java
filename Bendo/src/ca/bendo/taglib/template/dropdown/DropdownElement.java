/**
 * 
 */
package ca.bendo.taglib.template.dropdown;

import javax.servlet.jsp.PageContext;

import ca.bendo.taglib.template.TagBodyTemplate;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>DropdownElement</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class DropdownElement extends TagBodyTemplate
{

	/**
	 * @param translator
	 *            Translator
	 * @param pageContext
	 *            PageContext
	 */
	public DropdownElement(final Translator translator, final PageContext pageContext)
	{
		super(translator, pageContext);
	}

	@Override
	public final StringBuilder render()
	{
		StringBuilder result = new StringBuilder();
		result.append("<div class='dropdown_element " + getCustclass() + "'>");
		result.append(getBody());
		result.append("</div>");
		System.out.println("el: " + result);
		return result;
	}

}
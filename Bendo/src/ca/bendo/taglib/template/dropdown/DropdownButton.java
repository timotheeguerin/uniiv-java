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
 *          <b>DropdownButton</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class DropdownButton extends TagBodyTemplate
{

	/**
	 * @param translator
	 *            Translator
	 * @param pageContext
	 *            PageContext
	 */
	public DropdownButton(final Translator translator, final PageContext pageContext)
	{
		super(translator, pageContext);
	}

	@Override
	public StringBuilder render()
	{
		StringBuilder result = new StringBuilder();
		result.append("<div class='dropdown_button " + getCustclass() + "'>");
		result.append(getBody());
		result.append("</div>");
		System.out.println("but: " + result);
		return result;
	}

}

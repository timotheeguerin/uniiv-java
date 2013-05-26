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
 *          <b>DropdownContent</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class DropdownContent extends TagBodyTemplate
{

	/**
	 * @param translator
	 *            Translator
	 * @param pageContext
	 *            PageContext
	 */
	public DropdownContent(final Translator translator, final PageContext pageContext)
	{
		super(translator, pageContext);
	}

	@Override
	public final StringBuilder render()
	{
		StringBuilder result = new StringBuilder();
		result.append("<div class='dropdown_content " + getCustclass() + "'>");
		result.append(getBody());
		result.append("</div>");
		System.out.println("cont: " + result);
		return result;
	}

}
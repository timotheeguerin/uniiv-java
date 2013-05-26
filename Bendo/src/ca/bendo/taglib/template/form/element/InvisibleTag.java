/**
 * 
 */
package ca.bendo.taglib.template.form.element;

import javax.servlet.jsp.PageContext;

import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>InvisibleTag</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class InvisibleTag extends InputElement
{

	/**
	 * @param translator
	 *            Translator
	 * @param pageContext
	 *            PageContext
	 */
	public InvisibleTag(final Translator translator, final PageContext pageContext)
	{
		super(translator, pageContext);
		setName("submit_check");
		setCustclass("submit_check");
		setType("hidden");
		setTitle("");
		setValue("");
	}

}

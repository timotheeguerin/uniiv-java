/**
 * 
 */
package ca.bendo.taglib.template.form.element;

import javax.servlet.jsp.PageContext;

import ca.bendo.taglib.template.TagTemplate;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>FormElement</b>
 *          <p>
 *          Template for any form element(username, password,..)
 *          </p>
 * @see TagTemplate
 * 
 */
public abstract class FormElement extends TagTemplate
{

	/**
	 * @param translator
	 *            Translator
	 * @param pageContext
	 *            PageContext
	 */
	public FormElement(final Translator translator, final PageContext pageContext)
	{
		super(translator, pageContext);
	}

}

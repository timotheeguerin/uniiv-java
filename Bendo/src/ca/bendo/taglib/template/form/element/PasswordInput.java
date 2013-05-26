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
 *          <b>PasswordInput</b>
 *          <p>
 *          Generate the html for a password input based on a FormElement
 *          </p>
 * @see FormElement
 * 
 */
public class PasswordInput extends InputElement
{
	
	/**
	 * @param translator
	 *            Translator
	 * @param pageContext
	 *            PageContext
	 */
	public PasswordInput(final Translator translator, final PageContext pageContext)
	{
		super(translator, pageContext);
		
	}
}

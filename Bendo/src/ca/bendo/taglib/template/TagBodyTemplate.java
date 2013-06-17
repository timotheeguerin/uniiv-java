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
 *          <b>TagBodyTemplate</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public abstract class TagBodyTemplate extends TagTemplate
{

	/**
	 * Body.
	 */
	private String body;

	/**
	 * @param translator
	 *            Translator
	 * @param pageContext
	 *            PageContext
	 */
	public TagBodyTemplate(final Translator translator, final PageContext pageContext)
	{
		super(translator, pageContext);
	}

	/**
	 * @return the body
	 */
	public String getBody()
	{
		return body;
	}

	/**
	 * @param body
	 *            the body to set
	 */
	public void setBody(final String body)
	{
		this.body = body;
	}

}

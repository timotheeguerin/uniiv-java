/**
 * 
 */
package ca.bendo.taglib.template;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TagTemplate</b>
 *          <p>
 *          </p>
 * @see Filter
 * 
 */
public abstract class TagTemplate
{
	/**
	 * 
	 */
	private String custclass = "";

	/**
	 * Translator.
	 */
	private Translator translator;

	/**
	 * Page context.
	 */
	private PageContext pageContext;

	/**
	 * @param translator
	 *            Translator to set
	 * @param pageContext
	 *            Page context to set
	 */
	public TagTemplate(final Translator translator, final PageContext pageContext)
	{
		setTranslator(translator);
		setPageContext(pageContext);
	}

	/**
	 * Function call to render the tag template.
	 * 
	 * @return The tag renderer
	 */
	public abstract StringBuilder render();

	/**
	 * Function to get the real url.
	 * 
	 * @param url
	 *            Url to translate
	 * @return the real url
	 */
	public String url(final String url)
	{
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		if (url.startsWith("/"))
		{
			return request.getContextPath() + url;
		} else
		{
			return url;
		}
	}

	/**
	 * @return the custclass
	 * 
	 */
	public String getCustclass()
	{
		return custclass;
	}

	/**
	 * @param custclass
	 *            the custclass to set
	 * 
	 */
	public void setCustclass(final String custclass)
	{
		this.custclass = custclass;
	}

	/**
	 * @return the translator
	 * 
	 */
	public Translator getTranslator()
	{
		return translator;
	}

	/**
	 * @param translator
	 *            the translator to set
	 * 
	 */
	public void setTranslator(final Translator translator)
	{
		this.translator = translator;
	}

	/**
	 * @return the pageContext
	 * 
	 */
	public PageContext getPageContext()
	{
		return pageContext;
	}

	/**
	 * @param pageContext
	 *            the pageContext to set
	 * 
	 */
	public void setPageContext(final PageContext pageContext)
	{
		this.pageContext = pageContext;
	}

}

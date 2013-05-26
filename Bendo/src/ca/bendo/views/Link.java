/**
 * 
 */
package ca.bendo.views;

import javax.servlet.http.HttpServletRequest;

import ca.bendo.db.entity.lang.Language;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>Link</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class Link
{
	/**
	 * 
	 */
	private String link;

	/**
	 * 
	 */
	private String text;

	/**
	 * 
	 */
	public Link()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param request
	 *            Translator
	 * @param link
	 *            the link to set
	 * @param text
	 *            the text to set
	 */
	public Link(final HttpServletRequest request, final String text, final String link)
	{
		Translator translator = Translator.getTranslator(request);
		Long languageId = Language.load(request);
		this.text = translator.translate(text, languageId);
		this.link = translator.translateUrl(link, languageId);
	}

	/**
	 * @return the link
	 */
	public final String getLink()
	{
		return link;
	}

	/**
	 * @param link
	 *            the link to set
	 */
	public final void setLink(final String link)
	{
		this.link = link;
	}

	/**
	 * @return the text
	 */
	public final String getText()
	{
		return text;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public final void setText(final String text)
	{
		this.text = text;
	}

}

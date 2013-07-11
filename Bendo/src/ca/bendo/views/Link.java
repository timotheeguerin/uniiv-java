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
		//
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
		Long languageId = Language.loadId(request);
		this.text = translator.translate(text, languageId);
		this.link = translator.translateUrl(link, languageId);
	}

	/**
	 * @return the link
	 */
	public String getLink()
	{
		return link;
	}

	/**
	 * @param link
	 *            the link to set
	 */
	public void setLink(final String link)
	{
		this.link = link;
	}

	/**
	 * @return the text
	 */
	public String getText()
	{
		return text;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(final String text)
	{
		this.text = text;
	}

}

/**
 * 
 */
package ca.bendo.translation;

import javax.servlet.http.HttpServletRequest;

import ca.bendo.db.entity.lang.Language;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>RequestTranslator</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class RequestTranslator
{
	/**
	 * 
	 */
	private Translator translator;

	/**
	 * 
	 */
	private Language language;

	/**
	 * Load the requestTranslator from the request.
	 * 
	 * @param request
	 *            request
	 * 
	 * @return the requestTranslator loaded from the request
	 */
	public static final RequestTranslator load(final HttpServletRequest request)
	{
		return (RequestTranslator) request.getAttribute("requestTranslator");
	}

	/**
	 * 
	 * @param key
	 *            key to translate
	 * @return key translated in the requestTransaltor language
	 */
	public String translate(final String key)
	{
		return translator.translate(key, language.getId());
	}

	/**
	 * @return the translator
	 */
	public Translator getTranslator()
	{
		return translator;
	}

	/**
	 * @param translator
	 *            the translator to set
	 */
	public void setTranslator(final Translator translator)
	{
		this.translator = translator;
	}

	/**
	 * @return the language
	 */
	public Language getLanguage()
	{
		return language;
	}

	/**
	 * @param language
	 *            the language to set
	 */
	public void setLanguage(final Language language)
	{
		this.language = language;
	}

}

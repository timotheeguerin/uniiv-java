package ca.bendo.translation.translation;

import java.io.StringWriter;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import ca.bendo.db.dao.lang.LinkDAO;
import ca.bendo.db.dao.lang.TranslationsDAO;
import ca.bendo.db.entity.lang.Language;
import ca.bendo.db.entity.lang.Link;
import ca.bendo.db.entity.lang.Translation;
import ca.bendo.translation.language.SupportedLanguageManager;
import ca.bendo.translation.url.UrlTranslationManager;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>Translator</b>
 *          <p>
 *          Contains all the text and link translations
 *          </p>
 * @see Service
 * 
 */
@Service
public class Translator
{
	/**
	 * 
	 */
	@Autowired
	private SupportedLanguageManager supportedLangs;

	/**
	 * 
	 */
	@Autowired
	private UrlTranslationManager urlTranslationManager;

	/**
	 * 
	 */
	@Autowired
	private TranslationsDAO translationsDAO;

	/**
	 * 
	 */
	@Autowired
	private LinkDAO linkDAO;

	/**
	 * Default constructor.
	 */
	public Translator()
	{

	}

	/**
	 * 
	 * @param key
	 *            Key of the translation
	 * @param languageId
	 *            Language id
	 * @param tagAttributes
	 *            Attributes to put in the translation
	 * @return Translated element
	 */
	public String translate(final String key, final long languageId, final Map<String, Object> tagAttributes)
	{
		VelocityContext context = new VelocityContext(tagAttributes);
		StringWriter out = new StringWriter();
		String translation = translate(key, languageId);
		Velocity.evaluate(context, out, "mystring", translation);
		return out.toString();
	}

	/**
	 * 
	 * @param key
	 *            key to translate
	 * @param languageId
	 *            Language id
	 * @return url translated
	 */
	public String translate(final String key, final long languageId)
	{
		Translation translation = translationsDAO.getTranslation(key, languageId);
		if (translation == null)
		{
			return key;
		} else
		{
			return translation.getTranslation();
		}
	}

	/**
	 * 
	 * @param key
	 *            key to translate
	 * @return url translated
	 */
	public String translate(final String key)
	{
		Locale locale = LocaleContextHolder.getLocale();
		Translation translation = translationsDAO.getTranslation(key, locale.getDisplayName());
		if (translation == null)
		{
			return key;
		} else
		{
			return translation.getTranslation();
		}
	}

	/**
	 * 
	 * @param url
	 *            Url to translate
	 * @param languageId
	 *            Language id
	 * @return url translated
	 */
	public String translateUrl(final String url, final long languageId)
	{
		return urlTranslationManager.translateUrl(url, languageId);
	}

	/**
	 * @param url
	 *            Url to translate
	 * @param languageId
	 *            Language id
	 * @return url translated
	 */
	public String translateUrl(final String url)
	{
		Locale locale = LocaleContextHolder.getLocale();
		return urlTranslationManager.translateUrl(url, locale.getDisplayName());
	}

	/**
	 * @param langId
	 *            Id of the language
	 * @return the language
	 * 
	 */
	public Language getLanguage(final int langId)
	{
		return supportedLangs.getLanguage(langId);
	}

	/**
	 * @return the number of language
	 */
	public int getLanguageNumber()
	{
		return getSupportedLangs().getNumber();
	}

	/**
	 * @return the supportedLangs
	 * 
	 */
	public SupportedLanguageManager getSupportedLangs()
	{
		return supportedLangs;
	}

	/**
	 * @param supportedLangs
	 *            the supportedLangs to set
	 * 
	 */
	public void setSupportedLangs(final SupportedLanguageManager supportedLangs)
	{
		this.supportedLangs = supportedLangs;
	}

	/**
	 * @return list of all languages
	 */
	public List<Language> getLanguages()
	{
		return getSupportedLangs().getLanguages();
	}

	/**
	 * Get the link with the given key.
	 * 
	 * @param key
	 *            key of the link
	 * @param languageId
	 *            Language
	 * @return the link with the given key in the given language
	 */
	public String getLink(final String key, final long languageId)
	{
		Link link = linkDAO.getLink(key, languageId);
		if (link == null)
		{
			return "#";
		} else
		{
			return link.getLink();
		}
	}

	/**
	 * @param request
	 *            request
	 * @return translator loaded from request
	 */
	public static Translator getTranslator(final HttpServletRequest request)
	{
		return (Translator) request.getAttribute("translator");
	}

}

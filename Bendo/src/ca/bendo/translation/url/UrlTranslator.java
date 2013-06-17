package ca.bendo.translation.url;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.bendo.db.entity.lang.Language;
import ca.bendo.translation.language.SupportedLanguageManager;

/**
 * @author Timothée Guérin
 * @version Bendo v0.1
 * 
 *          <b>UrlTranslator </b>
 *          <p>
 *          </p>
 * @see Filter
 * 
 */
@Service
public class UrlTranslator
{

	/**
	 * Logger.
	 */
	private static Logger log = Logger.getLogger(UrlTranslator.class);

	/**
	 * 
	 */
	@Autowired
	private SupportedLanguageManager languageManager;

	/**
	 * 
	 */
	@Autowired
	private UrlTranslationManager segmentTranslations;

	/**
	 * Translation language.
	 */
	private Language language;

	/**
	 * URI.
	 */
	private String uri = "/";

	/**
	 * Default constructor.
	 */
	public UrlTranslator()
	{

	}

	/**
	 * Parse a url.
	 * 
	 * @param url
	 *            the url to parse
	 */
	public void parseUrl(final String url)
	{

		languageManager.loadFromDataBase();

		System.out.println("----------------------- : " + languageManager.getLanguages().size());
		String[] strs = url.split("\\?", 2);

		String[] segments = strs[0].split("/");
		int urlStartAt = 0;

		// IF url = "/"
		if (segments.length == 0)
		{
			log.debug("Empty Url");
			setDefaultLang();
		} else
		{
			/*
			 * Segment array schema segment[0] = "" segment[1] = lang segment[x
			 * > 1] = url to translate
			 */
			String langKey = segments[1];

			if (this.languageManager.isSupported(langKey))
			{
				setLanguage(this.languageManager.getLanguage(langKey));
				urlStartAt = 2; // Skip the first and second argument as its the
								// lang
			} else
			{
				urlStartAt = 1; // Skip the first argument as its empty(as the
								// url start with /)
				setDefaultLang();
			}
		}

		// Load the translation in the page language
		segmentTranslations.loadFromDataBase(this.language);
		log.debug("load translation end");
		this.setUri("/");
		for (int i = urlStartAt; i < segments.length; i++)
		{
			this.setUri(this.getUri() + (segmentTranslations.translate(segments[i]) + "/"));
		}

		log.info("Redirect url to: '" + getUri() + "' with language " + this.language);

	}

	/**
	 * Set the default language to be english.
	 */
	private void setDefaultLang()
	{
		this.setLanguage(languageManager.getLanguage("en"));
	}

	/**
	 * Get the language.
	 * 
	 * @return the language
	 */
	public Language getLang()
	{
		return language;
	}

	/**
	 * @param language
	 *            the language to set
	 */
	public void setLanguage(final Language language)
	{
		log.info("Setting language to " + language.getName());
		this.language = language;
	}

	/**
	 * @return the uri
	 */
	public String getUri()
	{
		return uri;
	}

	/**
	 * @param uri
	 *            the uri to set
	 */
	public void setUri(final String uri)
	{
		this.uri = uri;
	}

	/**
	 * @return the languageManager
	 */
	public SupportedLanguageManager getLanguageManager()
	{
		return languageManager;
	}

	/**
	 * @param languageManager
	 *            the languageManager to set
	 */
	public void setLanguageManager(final SupportedLanguageManager languageManager)
	{
		this.languageManager = languageManager;
	}

}

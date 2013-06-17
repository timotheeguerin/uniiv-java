package ca.bendo.translation.language;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.bendo.db.entity.lang.Language;
import ca.bendo.db.transaction.lang.LanguageTransaction;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>SupportedLanguageManager</b>
 *          <p>
 *          Manage all the supported language
 *          </p>
 * 
 */
@Service
public class SupportedLanguageManager
{

	/**
	 * Languages list.
	 */
	private List<Language> languages = new ArrayList<Language>();

	/**
	 * Logger.
	 */
	private Logger log = Logger.getLogger(SupportedLanguageManager.class);

	/**
	 * 
	 */
	@Autowired
	private LanguageTransaction languageTransaction;

	/**
	 * 
	 */
	public void loadFromDataBase()
	{
		log.info("Loading supported languages ...");
		languages = languageTransaction.listLanguages();
		log.info(languages.size() + " languages loaded");

	}

	// ////////////////////////////////////////////////////////////
	// SETTERS-GETTERS
	// ////////////////////////////////////////////////////////////
	/**
	 * @return the languages
	 * @see Language
	 */
	public List<Language> getLanguages()
	{
		return languages;
	}

	/**
	 * @param languages
	 *            the languages to set
	 * @see Language
	 */
	public void setLanguages(final List<Language> languages)
	{
		this.languages = languages;
	}

	/**
	 * @param lang
	 *            add a Language to the supported List
	 * @see Language
	 */
	public void addLanguage(final Language lang)
	{

		if (!this.isSupported(lang.getKey()))
		{
			this.languages.add(lang);
		}
	}

	/**
	 * @param key
	 *            Language key
	 * @return Language object
	 */
	public Language getLanguage(final String key)
	{
		log.debug("LANGUAGES: " + languages.size());

		for (Language lang : languages)
		{
			System.out.println("KEYL: " + lang.getKey());
			if (lang.getKey().equalsIgnoreCase(key))
			{
				return lang;
			}
		}
		return null;
	}

	/**
	 * @param id
	 *            Language id
	 * @return Language object
	 */
	public Language getLanguage(final int id)
	{
		for (Language lang : languages)
		{
			if (lang.getId() == id)
			{
				return lang;
			}
		}
		return null;
	}

	/**
	 * @param key
	 *            Language key
	 * @return Boolean
	 */
	public boolean isSupported(final String key)
	{
		return (getLanguage(key) != null);
	}

	/**
	 * @return the languageTransaction
	 */
	public LanguageTransaction getLanguageTransaction()
	{
		return languageTransaction;
	}

	/**
	 * @param languageTransaction
	 *            the languageTransaction to set
	 */
	public void setLanguageTransaction(final LanguageTransaction languageTransaction)
	{
		this.languageTransaction = languageTransaction;
	}

	/**
	 * @return the number of supported language
	 */
	public int getNumber()
	{
		return getLanguages().size();
	}
}

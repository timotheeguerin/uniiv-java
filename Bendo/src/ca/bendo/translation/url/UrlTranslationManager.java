package ca.bendo.translation.url;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.lang.LanguageDAO;
import ca.bendo.db.dao.lang.UrlSegmentTranslationDAO;
import ca.bendo.db.entity.lang.Language;
import ca.bendo.db.entity.lang.UrlSegmentTransaltion;
import ca.bendo.db.transaction.lang.UrlSegmentTransaltionTransaction;

/**
 * 
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UrlTranslationManager</b>
 *          <p>
 *          Manage the segment translation of the url
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class UrlTranslationManager
{

	/**
	 * Segments translation map.
	 */
	private Map<String, String> segments = new HashMap<String, String>();

	/**
	 * Logger.
	 */
	private Logger log = Logger.getLogger(UrlTranslationManager.class);

	/**
	 * Dao to connect to the Url translation table.
	 */
	@Autowired
	private UrlSegmentTransaltionTransaction urlSegmentTransaltionTransaction;

	/**
	 * 
	 */
	@Autowired
	private UrlSegmentTranslationDAO urlSegmentTranslationDAO;

	/**
	 * 
	 */
	@Autowired
	private LanguageDAO languageDAO;

	/**
	 * Default constructor.
	 */
	public UrlTranslationManager()
	{
	}

	/**
	 * Initialise the supported languages.
	 * 
	 * @param segments
	 *            list contains the supported languages
	 */
	public UrlTranslationManager(final Map<String, String> segments)
	{
		this.segments = segments;
	}

	/**
	 * Load the translations from database in the given language.
	 * 
	 * @param lang
	 *            Language for the translations
	 */
	public void loadFromDataBase(final Language lang)
	{
		log.info("Loading segments translations ...");
		segments = urlSegmentTransaltionTransaction.getTranslations(lang.getId());
	}

	/**
	 * Translate a segment.
	 * 
	 * @param segment
	 *            Segment to translate
	 * @return Translated segment
	 */
	public String translate(final String segment)
	{

		String trans = this.segments.get(segment);

		if (trans == null)
		{
			return segment;
		} else
		{
			return trans;
		}
	}

	/**
	 * Translate a segment.
	 * 
	 * @param segment
	 *            Segment to translate
	 * @param languageId
	 *            languageId
	 * @return Translated segment
	 */
	public String translate(final String segment, final long languageId)
	{
		UrlSegmentTransaltion translation = urlSegmentTranslationDAO.getByKeyAndLanguage(segment, languageId);
		if (translation == null)
		{
			return segment;
		} else
		{
			return translation.getTranslation();
		}
	}

	/**
	 * Translate a segment.
	 * 
	 * @param url
	 *            Url to translate
	 * @param languageId
	 *            language
	 * @return Translated segment
	 */
	public String translateUrl(final String url, final long languageId)
	{

		Language language = languageDAO.getById(languageId);

		StringBuilder uri = new StringBuilder();
		String tmpUrl = url;
		if (url.startsWith("/"))
		{
			uri.append("/");
			tmpUrl = url.substring(1);
		}
		String[] segs = tmpUrl.split("/");
		uri.append(language.getKey());

		for (String segment : segs)
		{
			uri.append("/").append(translate(segment, language.getId()));
		}
		uri.append("");

		//System.out.println("Url sgement translate to : " + uri);
		return uri.toString();
	}
}

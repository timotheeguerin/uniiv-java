package ca.bendo.db.dao.lang;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.lang.Translation;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>LanguageDAO </b>
 *          <p>
 *          Access the language table
 *          </p>
 * 
 */

@Repository
@Transactional
public class TranslationsDAO extends HibernateDAO<Translation>
{
	/**
	 * Logger.
	 */
	private Logger log = Logger.getLogger(TranslationsDAO.class);

	/**
	 * Default contructor.
	 */
	public TranslationsDAO()
	{
		setType(Translation.class);
	}

	/**
	 * @return a list of countries
	 */
	@SuppressWarnings("unchecked")
	public List<Translation> listTranslations()
	{
		return (List<Translation>) getSession().createCriteria(Translation.class).list();
	}

	/**
	 * @param languageId
	 *            Country Id
	 * @return Translations in the language given
	 */
	public Map<String, Translation> listTranslations(final long languageId)
	{

		@SuppressWarnings("unchecked")
		List<Translation> translations = getSession().createCriteria(Translation.class)
				.add(Restrictions.eq("language.id", languageId)).list();

		Map<String, Translation> translationsMap = new HashMap<String, Translation>();
		for (Translation translation : translations)
		{

			translationsMap.put(translation.getKey(), translation);
		}

		return translationsMap;
	}

	/**
	 * @param key
	 *            Translation key
	 * @return a map of the translation for the key in all language
	 */
	public Map<Long, Translation> getTranslationsWithKey(final String key)
	{

		@SuppressWarnings("unchecked")
		List<Translation> translations = getSession().createCriteria(Translation.class)
				.add(Restrictions.eq("key", key)).list();

		Map<Long, Translation> translationsMap = new HashMap<Long, Translation>();

		for (Translation translation : translations)
		{
			translationsMap.put(translation.getLanguage().getId(), translation);
		}
		return translationsMap;
	}

	/**
	 * @param key
	 *            Translation key
	 * @return a map of the translation for the key in all language
	 */
	public Map<Long, Translation> getNonNullTranslationsWithKey(final String key)
	{

		@SuppressWarnings("unchecked")
		List<Translation> translations = getSession().createCriteria(Translation.class)
				.add(Restrictions.eq("key", key)).list();

		Map<Long, Translation> translationsMap = new HashMap<Long, Translation>();

		for (Translation translation : translations)
		{
			if (translation.toString() != "")
			{
				translationsMap.put(translation.getLanguage().getId(), translation);
			}
		}
		return translationsMap;
	}

	/**
	 * Get the translation having the key and in the language given.
	 * 
	 * @param key
	 *            Key of the translation
	 * @param languageId
	 *            Id of Language of the translation.
	 * @return Transaltion object.
	 */
	public Translation getTranslation(final String key, final Long languageId)
	{
		Criterion keyRestriction = Restrictions.eq("key", key);
		Criterion langugageRestriction = Restrictions.eq("language.id", languageId);

		Translation translation = (Translation) getSession().createCriteria(Translation.class)
				.add(Restrictions.and(keyRestriction, langugageRestriction)).uniqueResult();
		return translation;
	}

	/**
	 * Get the translation having the key and in the language given.
	 * 
	 * @param key
	 *            Key of the translation
	 * @param languageKey
	 *            Key of Language of the translation.
	 * @return Transaltion object.
	 */
	public Translation getTranslation(final String key, final String languageKey)
	{
		Criterion keyRestriction = Restrictions.eq("key", key);
		Criterion langugageRestriction = Restrictions.eq("language.key", languageKey);

		Translation translation = (Translation) getSession().createCriteria(Translation.class)
				.createAlias("language", "language").add(Restrictions.and(keyRestriction, langugageRestriction))
				.uniqueResult();
		return translation;
	}

	/**
	 * Get all the unique keys of the translation table.
	 * 
	 * @return Key list
	 */
	@SuppressWarnings("unchecked")
	public List<String> listKeys()
	{

		return (List<String>) getSession().createCriteria(Translation.class)
				.setProjection(Projections.distinct(Projections.property("key"))).list();

	}

	/**
	 * @param query
	 *            Query
	 * @param firstResult
	 *            First result
	 * @param maxResults
	 *            Max result
	 * @return list of forum result
	 */
	@SuppressWarnings("unchecked")
	public List<String> searchTranslation(final String query, final int firstResult, final int maxResults)
	{
		String value = "%" + query + "%";
		return createCriteria()
				.setProjection(Projections.distinct(Projections.distinct(Projections.property("key"))))
				.add(Restrictions.ilike("key", value)).setFirstResult(firstResult).setMaxResults(maxResults).list();
	}

	/**
	 * @param query
	 *            to restrict
	 * @return the number of entity
	 */
	public long searchCount(final String query)
	{
		String value = "%" + query + "%";
		return (long) getSession().createCriteria(Translation.class).add(Restrictions.ilike("key", value))
				.setProjection(Projections.rowCount()).uniqueResult();
	}
}

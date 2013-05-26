package ca.bendo.db.dao.lang;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.lang.UrlSegmentTransaltion;

/**
 * 
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UrlSegmentTranslationDAO</b>
 *          <p>
 *          Connect to the UrlSegmentTranslation table
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class UrlSegmentTranslationDAO extends HibernateDAO<UrlSegmentTransaltion>
{
	/**
	 * Default contructor.
	 */
	public UrlSegmentTranslationDAO()
	{
		setType(UrlSegmentTransaltion.class);
	}

	/**
	 * @param languageId
	 *            Id of the language for the translation
	 * @return a map of the translation in the language specified
	 */
	public final Map<String, String> getTranslations(final long languageId)
	{
		@SuppressWarnings("unchecked")
		List<UrlSegmentTransaltion> translations = getSession().createCriteria(UrlSegmentTransaltion.class)
				.add(Restrictions.eq("language.id", languageId)).list();

		Map<String, String> translationMap = new HashMap<String, String>();
		for (UrlSegmentTransaltion trans : translations)
		{
			translationMap.put(trans.getTranslation(), trans.getKey());
		}
		return translationMap;
	}

	/**
	 * @param key
	 *            Translation key
	 * @param languageId
	 *            language Id
	 * @return segment translation with the given key in the given language
	 */
	public UrlSegmentTransaltion getByKeyAndLanguage(final String key, final long languageId)
	{
		Criterion restrictions = Restrictions.and(Restrictions.eq("key", key),
				Restrictions.eq("language.id", languageId));
		return (UrlSegmentTransaltion) getSession().createCriteria(UrlSegmentTransaltion.class).add(restrictions)
				.uniqueResult();

	}
}

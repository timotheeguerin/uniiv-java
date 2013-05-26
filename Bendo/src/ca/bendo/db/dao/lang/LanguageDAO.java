package ca.bendo.db.dao.lang;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.lang.Language;

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
public class LanguageDAO extends HibernateDAO<Language>
{
	/**
	 * Default constructor.
	 */
	public LanguageDAO()
	{
		setType(Language.class);
	}

	/**
	 * 
	 * @return a list of supported language loaded from database and table
	 *         lang_languages
	 */
	@SuppressWarnings("unchecked")
	public final List<Language> listLanguages()
	{
		return (List<Language>) getSession().createCriteria(Language.class).list();
	}
}

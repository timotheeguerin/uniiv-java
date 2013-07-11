/**
 * 
 */
package ca.bendo.db.transaction.lang;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.lang.LanguageDAO;
import ca.bendo.db.entity.lang.Language;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>LanguageTransaction</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class LanguageTransaction
{
	/**
	 * 
	 */
	@Autowired
	private LanguageDAO languageDAO;

	/**
	 * @return List all the languages.
	 */
	public List<Language> listLanguages()
	{
		return languageDAO.listLanguages();
	}

	/**
	 * @return the languageDAO
	 */
	public LanguageDAO getLanguageDAO()
	{
		return languageDAO;
	}

	/**
	 * @param languageDAO
	 *            the languageDAO to set
	 */
	public void setLanguageDAO(final LanguageDAO languageDAO)
	{
		this.languageDAO = languageDAO;
	}

}

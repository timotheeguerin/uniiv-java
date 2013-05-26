/**
 * 
 */
package ca.bendo.db.transaction.lang;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.lang.TranslationsDAO;
import ca.bendo.db.entity.lang.Translation;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TranslationTransaction</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class TranslationTransaction
{
	/**
	 * 
	 */
	@Autowired
	private TranslationsDAO translationDAO;

	/**
	 * @param id
	 *            Language id
	 * @return translations with given id
	 */
	public Map<String, Translation> listTranslations(final long id)
	{
		return translationDAO.listTranslations(id);
	}

}

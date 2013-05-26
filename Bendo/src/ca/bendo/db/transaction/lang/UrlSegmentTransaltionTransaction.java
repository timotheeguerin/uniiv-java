/**
 * 
 */
package ca.bendo.db.transaction.lang;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.lang.UrlSegmentTranslationDAO;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UrlTranslationTransaction</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class UrlSegmentTransaltionTransaction
{
	/**
	 * 
	 */
	@Autowired
	private UrlSegmentTranslationDAO urlSegmentTranslationDAO;

	/**
	 * @param l
	 *            id
	 * @return translations
	 */
	public Map<String, String> getTranslations(final long l)
	{
		return urlSegmentTranslationDAO.getTranslations(l);
	}

	/**
	 * @return the urlSegmentTranslationDAO
	 */
	public UrlSegmentTranslationDAO getUrlSegmentTranslationDAO()
	{
		return urlSegmentTranslationDAO;
	}

	/**
	 * @param urlSegmentTranslationDAO
	 *            the urlSegmentTranslationDAO to set
	 */
	public void setUrlSegmentTranslationDAO(final UrlSegmentTranslationDAO urlSegmentTranslationDAO)
	{
		this.urlSegmentTranslationDAO = urlSegmentTranslationDAO;
	}

}

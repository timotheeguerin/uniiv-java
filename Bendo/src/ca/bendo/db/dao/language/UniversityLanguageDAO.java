/**
 * 
 */
package ca.bendo.db.dao.language;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.language.UniversityLanguage;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UniversityLanguageDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class UniversityLanguageDAO extends HibernateDAO<UniversityLanguage>
{

	/**
	 * 
	 */
	public UniversityLanguageDAO()
	{
		setType(UniversityLanguage.class);
	}

	/**
	 * @return list all language
	 */
	@SuppressWarnings("unchecked")
	public List<UniversityLanguage> listUniversityLanguage()
	{
		Filter filter = getSession().enableFilter("languageId");
		filter.setParameter("param", getLanguageId());
		return getSession().createCriteria(UniversityLanguage.class).addOrder(Order.asc("translation")).list();
	}

}
/**
 * 
 */
package ca.bendo.db.dao.professor;

import java.util.List;

import org.hibernate.Filter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.professor.ProfessorRatingType;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ProfessorRatingTypeDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class ProfessorRatingTypeDAO extends HibernateDAO<ProfessorRatingType>
{
	/**
	 * 
	 */
	public ProfessorRatingTypeDAO()
	{
		setType(ProfessorRatingType.class);
	}

	/**
	 * @return list all ratingType
	 */
	@SuppressWarnings("unchecked")
	public List<ProfessorRatingType> listProfessorRatingType()
	{
		Filter filter = getSession().enableFilter("languageId");
		filter.setParameter("param", getLanguageId());
		return getSession().createCriteria(ProfessorRatingType.class).list();
	}

}

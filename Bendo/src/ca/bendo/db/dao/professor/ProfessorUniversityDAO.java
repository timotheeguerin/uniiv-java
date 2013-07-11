/**
 * 
 */
package ca.bendo.db.dao.professor;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.professor.ProfessorUniversity;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ProfessorUniversityDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */

@Repository
@Transactional
public class ProfessorUniversityDAO extends HibernateDAO<ProfessorUniversity>
{
	/**
	 * 
	 */
	public ProfessorUniversityDAO()
	{
		setType(ProfessorUniversity.class);
	}

	/**
	 * @param professorId
	 *            Professor Id
	 * @return ProfessorReviews in the university given
	 */
	public List<ProfessorUniversity> listProfessorUniversity(final long professorId)
	{
		

		@SuppressWarnings("unchecked")
		List<ProfessorUniversity> unis = getSession().createCriteria(ProfessorUniversity.class)
				.add(Restrictions.eq("professor.id", professorId)).list();
		return unis;
	}

	/**
	 * @param professorId
	 *            Professor Id
	 * @param maxResults
	 *            The maximum number of result to return
	 * @return ProfessorReviews in the university given
	 */
	public List<ProfessorUniversity> listProfessorUniversity(final long professorId, final int maxResults)
	{
		

		@SuppressWarnings("unchecked")
		List<ProfessorUniversity> unis = getSession().createCriteria(ProfessorUniversity.class)
				.createAlias("university", "university").add(Restrictions.eq("professor.id", professorId))
				.addOrder(Order.asc("university.name")).setMaxResults(maxResults).list();
		return unis;
	}

	/**
	 * @param universityId
	 *            University Id
	 * @return ProfessorReviews in the university given
	 */
	public List<ProfessorUniversity> listProfessorAtUniversity(final long universityId)
	{
		

		@SuppressWarnings("unchecked")
		List<ProfessorUniversity> profs = getSession().createCriteria(ProfessorUniversity.class)
				.add(Restrictions.eq("university.id", universityId)).list();
		return profs;
	}

	/**
	 * @param universityId
	 *            University id
	 * @param maxResults
	 *            Maximum number of result
	 * @return ProfessorReviews in the university given
	 */
	public List<ProfessorUniversity> listProfessorAtUniversity(final long universityId, final int maxResults)
	{
		

		@SuppressWarnings("unchecked")
		List<ProfessorUniversity> profs = getSession().createCriteria(ProfessorUniversity.class)
				.add(Restrictions.eq("university.id", universityId)).setMaxResults(maxResults).list();
		return profs;
	}

	/**
	 * @param universityId
	 *            University id
	 * @param firstResult
	 *            First result
	 * @param maxResults
	 *            Maximum number of result
	 * @return ProfessorReviews in the university given
	 */
	public List<ProfessorUniversity> listProfessorAtUniversity(final long universityId, final int firstResult,
			final int maxResults)
	{
		

		@SuppressWarnings("unchecked")
		List<ProfessorUniversity> profs = getSession().createCriteria(ProfessorUniversity.class)
				.add(Restrictions.eq("university.id", universityId)).setFirstResult(firstResult)
				.setMaxResults(maxResults).list();
		return profs;
	}

	/**
	 * @param professorId
	 *            Professor id
	 * @param universityId
	 *            UNiversity id
	 * @return boolean if the professor is at the given university
	 */
	public boolean professorIsAtUniversity(final long professorId, final long universityId)
	{
		
		Criterion restrictions = Restrictions.and(Restrictions.eq("professor.id", professorId),
				Restrictions.eq("university.id", universityId));

		ProfessorUniversity profUni = (ProfessorUniversity) getSession().createCriteria(ProfessorUniversity.class)
				.add(restrictions).uniqueResult();
		return profUni != null;
	}

	/**
	 * @param universityId
	 *            UniversityId
	 * @param query
	 *            Query
	 * @param maxResults
	 *            Maximum number of results
	 * @return list of professor university
	 */
	public List<ProfessorUniversity> listProfessorInUniversityLikeMaxResults(final long universityId,
			final String query, final int maxResults)
	{
		
		String name = "%" + query + "%";
		Criterion like = Restrictions.or(Restrictions.like("professor.firstName", name),
				Restrictions.like("professor.lastName", name));
		Criterion restriction = Restrictions.and(Restrictions.eq("university.id", universityId), like);
		@SuppressWarnings("unchecked")
		List<ProfessorUniversity> profs = getSession().createCriteria(ProfessorUniversity.class)
				.createAlias("professor", "professor").createAlias("university", "university").add(restriction)
				.setMaxResults(maxResults).list();
		return profs;

	}

}

/**
 * 
 */
package ca.bendo.db.dao.professor;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.professor.ProfessorReview;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ProfessorReviewReviewDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class ProfessorReviewDAO extends HibernateDAO<ProfessorReview>
{
	/**
	 * 
	 */
	public ProfessorReviewDAO()
	{
		setType(ProfessorReview.class);
	}

	/**
	 * @param professorId
	 *            Professor Id
	 * @return ProfessorReviews in the university given
	 */
	public List<ProfessorReview> getProfessorReview(final long professorId)
	{
		

		@SuppressWarnings("unchecked")
		List<ProfessorReview> profs = getSession().createCriteria(ProfessorReview.class)
				.add(Restrictions.eq("professor.id", professorId)).list();
		return profs;
	}

	/**
	 * @param amount
	 *            return a list with a maximum of amount review
	 * 
	 * @param professorId
	 *            Professor Id
	 * @return ProfessorReviews in the university given
	 */
	public List<ProfessorReview> listLastProfessorReview(final long professorId, final int amount)
	{
		return listLastProfessorReview(professorId, 0, amount);
	}

	/**
	 * @param start
	 *            start with the nth review
	 * @param amount
	 *            return a list with a maximum of amount review
	 * 
	 * @param professorId
	 *            Professor Id
	 * @return ProfessorReviews in the university given
	 */
	public List<ProfessorReview> listLastProfessorReview(final long professorId, final int start, final int amount)
	{
		

		@SuppressWarnings("unchecked")
		List<ProfessorReview> profs = getSession().createCriteria(ProfessorReview.class)
				.add(Restrictions.eq("professor.id", professorId)).addOrder(Order.desc("date")).setFirstResult(start)
				.setMaxResults(amount).list();
		return profs;
	}

}

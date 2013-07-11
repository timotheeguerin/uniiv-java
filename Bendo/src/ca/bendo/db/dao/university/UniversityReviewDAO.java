/**
 * 
 */
package ca.bendo.db.dao.university;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.university.UniversityReview;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UniversityReviewDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class UniversityReviewDAO extends HibernateDAO<UniversityReview>
{
	/**
 * 
 */
	public UniversityReviewDAO()
	{
		setType(UniversityReview.class);
	}

	/**
	 * @param universityId
	 *            University Id
	 * @return UniversityReviews in the university given
	 */
	public List<UniversityReview> getUniversityReview(final long universityId)
	{
		

		@SuppressWarnings("unchecked")
		List<UniversityReview> profs = getSession().createCriteria(UniversityReview.class)
				.add(Restrictions.eq("university.id", universityId)).list();
		return profs;
	}

	/**
	 * @param amount
	 *            return a list with a maximum of amount review
	 * 
	 * @param universityId
	 *            University Id
	 * @return UniversityReviews in the university given
	 */
	public List<UniversityReview> listLastUniversityReview(final long universityId, final int amount)
	{
		return listLastUniversityReview(universityId, 0, amount);
	}

	/**
	 * @param start
	 *            start with the nth review
	 * @param amount
	 *            return a list with a maximum of amount review
	 * 
	 * @param universityId
	 *            University Id
	 * @return UniversityReviews in the university given
	 */
	public List<UniversityReview> listLastUniversityReview(final long universityId, final int start, final int amount)
	{
		

		@SuppressWarnings("unchecked")
		List<UniversityReview> profs = getSession().createCriteria(UniversityReview.class)
				.add(Restrictions.eq("university.id", universityId)).addOrder(Order.desc("date"))
				.setFirstResult(start).setMaxResults(amount).list();
		return profs;
	}

}

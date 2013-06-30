/**
 * 
 */
package ca.bendo.db.dao.geolocation;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.geolocation.UserGeolocationRating;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UserGeolocationRatingDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class UserGeolocationRatingDAO extends HibernateDAO<UserGeolocationRating>
{
	/**
 * 
 */
	public UserGeolocationRatingDAO()
	{
		setType(UserGeolocationRating.class);
	}

	/**
	 * @param reviewId
	 *            Review Id
	 * @param criteriaId
	 *            Criteria ID
	 * @return the rating of the given review and with the given criteria
	 */
	public UserGeolocationRating getByReviewAndCriteria(final long reviewId, final long criteriaId)
	{
		return (UserGeolocationRating) getSession().createCriteria(UserGeolocationRating.class)
				.add(Restrictions.eq("review.id", reviewId)).add(Restrictions.eq("criteria.id", criteriaId))
				.uniqueResult();

	}
}

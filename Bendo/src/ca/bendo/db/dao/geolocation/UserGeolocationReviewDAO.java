/**
 * 
 */
package ca.bendo.db.dao.geolocation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.geolocation.GeolocationRatingCriteria;
import ca.bendo.db.entity.geolocation.UserGeolocationReview;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UserGeolocationReview</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class UserGeolocationReviewDAO extends HibernateDAO<UserGeolocationReview>
{
	/**
	 * 
	 */
	public UserGeolocationReviewDAO()
	{
		setType(UserGeolocationReview.class);
	}
}
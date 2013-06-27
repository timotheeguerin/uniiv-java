/**
 * 
 */
package ca.bendo.db.dao.geolocation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.geolocation.UserGeolocationRating;

/**
 * @author Timoth�e Gu�rin
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
}

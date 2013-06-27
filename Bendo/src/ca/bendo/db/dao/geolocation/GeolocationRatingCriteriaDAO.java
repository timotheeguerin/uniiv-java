/**
 * 
 */
package ca.bendo.db.dao.geolocation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.geolocation.GeolocationRatingCriteria;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>GeolocationRatingCriteriaDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class GeolocationRatingCriteriaDAO extends HibernateDAO<GeolocationRatingCriteria>
{
	/**
	 * 
	 */
	public GeolocationRatingCriteriaDAO()
	{
		setType(GeolocationRatingCriteria.class);
	}
}

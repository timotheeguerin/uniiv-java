/**
 * 
 */
package ca.bendo.db.dao.geolocation;

import java.awt.image.RescaleOp;

import org.hibernate.criterion.Restrictions;
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

	/**
	 * @param key
	 *            name of the rating criteria
	 * @return criteria with the given name
	 */
	public GeolocationRatingCriteria getByName(final String key)
	{
		return (GeolocationRatingCriteria) getSession().createCriteria(GeolocationRatingCriteria.class)
				.add(Restrictions.eq("name", key)).uniqueResult();
	}
}

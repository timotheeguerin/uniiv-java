/**
 * 
 */
package ca.bendo.db.dao.geolocation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vividsolutions.jts.geom.Point;

import ca.bendo.controller.handler.geolocation.HeatmapPoint;
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

	/**
	 * @param universityId
	 *            unversityId
	 * @return list of point for the heatmap
	 */
	@SuppressWarnings("unchecked")
	public List<HeatmapPoint> listLocationFromUniversity(final long universityId)
	{
		List<UserGeolocationReview> reviews = getSession().createCriteria(UserGeolocationReview.class)
				.add(Restrictions.eq("universityId", universityId)).list();

		List<HeatmapPoint> points = new ArrayList<HeatmapPoint>();
		for (UserGeolocationReview review : reviews)
		{
			points.add(new HeatmapPoint(review));
		}
		return points;

	}
}
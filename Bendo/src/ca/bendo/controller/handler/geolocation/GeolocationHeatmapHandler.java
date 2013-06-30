/**
 * 
 */
package ca.bendo.controller.handler.geolocation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.geolocation.GeolocationRatingCriteriaDAO;
import ca.bendo.db.dao.geolocation.UserGeolocationReviewDAO;
import ca.bendo.db.entity.geolocation.GeolocationRatingCriteria;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>GeolocationHeatmapController</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class GeolocationHeatmapHandler
{
	/**
	 * 
	 */
	@Autowired
	private UserGeolocationReviewDAO userGeolocationReviewDAO;

	/**
	 * 
	 */
	@Autowired
	private GeolocationRatingCriteriaDAO geolocationRatingCriteriaDAO;

	/**
	 * @param universityId
	 *            University Id
	 * @param type
	 *            type
	 * @return heatmap data
	 */
	public String loadStudentLocationHeatMap(final long universityId, final String type)
	{
		List<HeatmapPoint> points = null;
		geolocationRatingCriteriaDAO.enableTranslation(1);
		GeolocationRatingCriteria criteria = geolocationRatingCriteriaDAO.getByName(type);
		if (criteria == null)
		{
			points = userGeolocationReviewDAO.listLocationFromUniversity(universityId);
		} else
		{
			points = userGeolocationReviewDAO.listLocationFromUniversityWithWeight(universityId, criteria.getId());
		}
		return toHeatMapObject(points);
	}

	/**
	 * 
	 * @param points
	 *            Points
	 * @return string
	 */
	public String toHeatMapObject(final List<HeatmapPoint> points)
	{
		StringBuilder result = new StringBuilder();
		result.append("[");
		boolean first = true;
		for (HeatmapPoint point : points)
		{
			if (first)
			{
				first = false;
			} else
			{
				result.append(",");
			}
			result.append(point.toLatlng());

		}
		result.append("]");
		return result.toString();
	}

}

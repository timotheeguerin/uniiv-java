/**
 * 
 */
package ca.bendo.controller.handler.geolocation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.geolocation.UserGeolocationReviewDAO;

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
	 * @param universityId
	 *            University Id
	 * @return heatmap data
	 */
	public String loadStudentLocationHeatMap(final long universityId)
	{
		List<HeatmapPoint> points = userGeolocationReviewDAO.listLocationFromUniversity(universityId);
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

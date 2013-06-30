/**
 * 
 */
package ca.bendo.controller.geolocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.bendo.controller.handler.geolocation.GeolocationHeatmapHandler;
import ca.bendo.db.entity.university.University;

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
@Controller
public class GeolocationHeatmapController
{
	/**
	 * 
	 */
	@Autowired
	private GeolocationHeatmapHandler handler;

	/**
	 * @param universityId
	 *            {@link University}
	 * @param typeParam
	 *            To display a wighted map
	 * 
	 * @return the heat map data
	 */
	@RequestMapping(value = "/university/{universityId}/location/heatmap/", method = RequestMethod.GET)
	@ResponseBody
	public String loadStudtentLocationHeatmap(@PathVariable("universityId") final long universityId, @RequestParam(
			value = "type", defaultValue = "") final String typeParam)
	{
		return handler.loadStudentLocationHeatMap(universityId, typeParam);
	}
}

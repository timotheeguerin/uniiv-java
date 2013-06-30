/**
 * 
 */
package ca.bendo.controller.handler.geolocation;

import ca.bendo.db.entity.geolocation.UserGeolocationReview;

import com.vividsolutions.jts.geom.Point;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>HeatmapPoint</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class HeatmapPoint
{
	/**
	 * 
	 */
	private Point location;

	/**
	 * @param review
	 *            review
	 */
	public HeatmapPoint(final UserGeolocationReview review)
	{
		initWithReview(review);
	}

	/**
	 * @param review
	 *            review
	 */
	public void initWithReview(final UserGeolocationReview review)
	{
		this.location = review.getLocation();
	}

	/**
	 * 
	 * @return javascript google api object for heatmap
	 */
	public String toLatlng()
	{
		return "new google.maps.LatLng(" + location.getX() + "," + location.getY() + ")";
	}

	/**
	 * @return the location
	 */
	public Point getLocation()
	{
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(final Point location)
	{
		this.location = location;
	}
}

/**
 * 
 */
package ca.bendo.form.entity.geolocation;

import java.awt.Point;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import ca.bendo.form.entity.RatingEntity;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>GeolocationReviewForm</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class GeolocationReviewForm
{
	/**
	 * 
	 */
	@NotNull
	private Point location;

	/**
	 * 
	 */
	@Valid
	@NotEmpty
	private List<RatingEntity> ratings;

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

	/**
	 * @return the ratings
	 */
	public List<RatingEntity> getRatings()
	{
		return ratings;
	}

	/**
	 * @param ratings
	 *            the ratings to set
	 */
	public void setRatings(final List<RatingEntity> ratings)
	{
		this.ratings = ratings;
	}

}

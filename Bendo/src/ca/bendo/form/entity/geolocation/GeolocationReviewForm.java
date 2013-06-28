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
	private GeoLocation location;

	/**
	 * 
	 */
	@Valid
	@NotEmpty
	private List<RatingEntity> ratings;

	@Valid
	private RatingEntity ratingTest;

	/**
	 * @return the location
	 */
	public GeoLocation getLocation()
	{
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(final GeoLocation location)
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

	/**
	 * @return the ratingTest
	 */
	public RatingEntity getRatingTest()
	{
		return ratingTest;
	}

	/**
	 * @param ratingTest
	 *            the ratingTest to set
	 */
	public void setRatingTest(RatingEntity ratingTest)
	{
		this.ratingTest = ratingTest;
	}

}

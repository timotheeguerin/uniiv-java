/**
 * 
 */
package ca.bendo.form.entity.geolocation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

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
	@NotEmpty
	private String location;

	/**
	 * 
	 */
	@Valid
	@NotEmpty
	private List<RatingEntity> ratings = new ArrayList<RatingEntity>();

	/**
	 * @return the location
	 */
	public String getLocation()
	{
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(final String location)
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

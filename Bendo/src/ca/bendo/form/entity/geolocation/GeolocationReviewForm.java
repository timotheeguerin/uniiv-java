/**
 * 
 */
package ca.bendo.form.entity.geolocation;

import java.util.HashMap;
import java.util.Map;

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
	@NotNull(message = "error.location")
	private GeoLocation location;

	/**
	 * 
	 */
	@Valid
	@NotEmpty(message = "error.empty")
	private Map<String, RatingEntity> ratings = new HashMap<String, RatingEntity>();

	/**
	 * add a new Rating entity map to the given key if the key doesnt exist
	 * already.
	 * 
	 * @param key
	 *            Key
	 * 
	 */
	public void init(final String key)
	{
		if (!ratings.containsKey(key))
		{
			ratings.put(key, new RatingEntity());
		}
	}

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
	public Map<String, RatingEntity> getRatings()
	{
		return ratings;
	}

	/**
	 * @param ratings
	 *            the ratings to set
	 */
	public void setRatings(final Map<String, RatingEntity> ratings)
	{
		this.ratings = ratings;
	}
}

/**
 * 
 */
package ca.bendo.utils.facebook;

import com.restfb.Facebook;
import com.restfb.types.CategorizedFacebookType;
import com.restfb.types.Location;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>Page</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class Place extends CategorizedFacebookType
{

	@Facebook
	private Location location;

	@Facebook("location")
	private String locationAsString;

	@Facebook
	private String name;

	@Facebook
	private Long likes;

	/**
	 * Location containing geographic information such as latitude, longitude,
	 * country, and other fields (fields will vary based on geography and
	 * availability of information).
	 * <p>
	 * It is possible for Facebook to return either this value or
	 * {@link #getLocationAsString()}.
	 * 
	 * @return Location containing geographic information such as latitude,
	 *         longitude, country, and other fields.
	 */
	public Location getLocation()
	{
		return location;
	}

	/**
	 * Description for this location.
	 * <p>
	 * It is possible for Facebook to return either this value or
	 * {@link #getLocation()}. If {@link #getLocation()} returns {@code null},
	 * then check this method to see if it has data, e.g.
	 * {@code "Philadelphia, PA"}.
	 * 
	 * @return Description for this location.
	 * @since 1.6.12
	 */
	public String getLocationAsString()
	{
		return locationAsString;
	}

	/**
	 * @return the likes
	 */
	public Long getLikes()
	{
		return likes;
	}

	/**
	 * @param likes
	 *            the likes to set
	 */
	public void setLikes(final Long likes)
	{
		this.likes = likes;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(final String name)
	{
		this.name = name;
	}

}

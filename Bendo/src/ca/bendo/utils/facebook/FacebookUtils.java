/**
 * 
 */
package ca.bendo.utils.facebook;

import org.springframework.stereotype.Service;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>FacebookUtils</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
public class FacebookUtils
{
	/**
	 * 
	 */
	private FacebookClient facebook = new DefaultFacebookClient("193939527441772|f7f393a52e1de95d58b2889b9589763c");

	/**
	 * 
	 * @param placeId
	 *            Place id
	 * @return place with the given id
	 */
	public Place getPlace(final long placeId)
	{
		return getPlace(String.valueOf(placeId));
	}

	/**
	 * 
	 * @param placeId
	 *            Place id
	 * @return place with the given id
	 */
	public Place getPlace(final String placeId)
	{
		return facebook.fetchObject(placeId, Place.class);
	}
}

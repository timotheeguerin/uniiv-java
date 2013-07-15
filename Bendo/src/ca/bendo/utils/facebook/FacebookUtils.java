/**
 * 
 */
package ca.bendo.utils.facebook;

import org.springframework.stereotype.Service;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.exception.FacebookException;
import com.restfb.exception.FacebookNetworkException;

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
	private static final String CLIENT_ID = "193939527441772";
	private static final String CLIENT_SECRET = "f7f393a52e1de95d58b2889b9589763c";

	private String accessToken;

	private FacebookClient facebook = new DefaultFacebookClient(CLIENT_ID + "|" + CLIENT_SECRET);

	/**
	 * 
	 */
	public FacebookUtils()
	{
		try
		{
			refreshAccessToken();
		} catch (FacebookNetworkException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Retrieve the access token of the application from facebook.
	 */
	public void refreshAccessToken()
	{
		AccessToken token = facebook.obtainAppAccessToken(CLIENT_ID, CLIENT_SECRET);
		accessToken = token.getAccessToken();
	}

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

	/**
	 * @return the accessToken
	 */
	public String getAccessToken()
	{
		return accessToken;
	}

	/**
	 * @param accessToken
	 *            the accessToken to set
	 */
	public void setAccessToken(final String accessToken)
	{
		this.accessToken = accessToken;
	}

}

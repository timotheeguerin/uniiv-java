/**
 * 
 */
package ca.bendo.utils.url;

import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.tiles.util.URLUtil;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UrlFactory</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public final class UrlFactory
{

	/**
	 * Prevent instantiation of Utility class.
	 */
	private UrlFactory()
	{
	}

	/**
	 * 
	 * @param url
	 *            Url
	 * @param params
	 *            params
	 * @return merge the params with the url
	 */
	public static String mergeUrl(final String url, final String params)
	{
		if (url.contains("?"))
		{
			return url + "&" + params;
		} else
		{
			return url + "?" + params;
		}
	}
	
	/**
	 * 
	 * @param url
	 *            Url to get
	 * @param request
	 *            request
	 * @return the given url with the application path if in absolute
	 */
	public static String getUrl(final String url, final HttpServletRequest request)
	{
		if (url.startsWith("/"))
		{
			return request.getContextPath() + url;
		} else
		{
			return url;
		}
	}

	/**
	 * Generate a url with the arguments specified.
	 * 
	 * @param baseUrl
	 *            The url
	 * @param args
	 *            The arguments to add at the end of the url
	 * @return the merge url
	 */
	public static String getUrl(final String baseUrl, final Map<String, String> args)
	{
		StringBuilder result = new StringBuilder();
		result.append(baseUrl);
		if (args.size() > 0)
		{
			result.append('?');
		}

		boolean first = true;
		for (Entry<String, String> entry : args.entrySet())
		{
			if (first)
			{
				first = false;
			} else
			{
				result.append('&');
			}
			result.append(entry.getKey());
			result.append('=');
			result.append(entry.getValue());
		}
		return result.toString();
	}
}

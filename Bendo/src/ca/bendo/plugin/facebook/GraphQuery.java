/**
 * 
 */
package ca.bendo.plugin.facebook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author toby
 * @version Bendo
 * 
 *          <b>GraphQuery</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class GraphQuery
{
	private static final String graphUrl = "http://graph.facebook.com/fql";

	public static void main(String[] args) throws IOException
	{
		String q = getHTML("SELECT fan_count, location, phone FROM page WHERE page_id=59945106352");
		System.out.println(q);
	}

	public static String getHTML(String query) throws UnsupportedEncodingException
	{
		String urlToRead = graphUrl + "?q=" + query;
		urlToRead = urlToRead.replace(" ", "%20");
		URL url;
		HttpURLConnection conn;
		BufferedReader rd;
		String line;
		String result = "";
		try
		{
			url = new URL(urlToRead);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((line = rd.readLine()) != null)
			{
				result += line;
			}
			rd.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}

}

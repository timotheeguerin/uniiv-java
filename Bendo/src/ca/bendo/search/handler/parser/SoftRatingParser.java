/**
 * 
 */
package ca.bendo.search.handler.parser;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>SoftRatingParser</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class SoftRatingParser extends ParameterParser
{

	/**
	 * 
	 */
	private Map<Long, Long> softRatings = new HashMap<Long, Long>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ca.bendo.search.handler.parser.ParameterParser#parse(java.lang.String)
	 */
	@Override
	public void parse(final String parameter)
	{
		if (parameter != null && parameter.length() > 0)
		{
			for (String s : parameter.split(","))
			{
				String[] argv = s.split(":", 2);
				if (argv.length == 2)
				{
					try
					{
						long ratingId = Long.parseLong(argv[0]);
						long ratingVal = Long.parseLong(argv[1]);

						this.softRatings.put(ratingId, ratingVal);
					} catch (NumberFormatException nfe)
					{
						nfe.printStackTrace();
					}
				}

			}
		}

	}

	/**
	 * @return the softRatings
	 */
	public Map<Long, Long> getSoftRatings()
	{
		return softRatings;
	}

	/**
	 * @param softRatings
	 *            the softRatings to set
	 */
	public void setSoftRatings(final Map<Long, Long> softRatings)
	{
		this.softRatings = softRatings;
	}

}

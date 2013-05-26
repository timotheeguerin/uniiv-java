/**
 * 
 */
package ca.bendo.search.handler.parser;

import java.util.ArrayList;
import java.util.List;

import ca.bendo.db.entity.location.Country;
import ca.bendo.db.entity.location.State;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>LocationParser</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class LocationParser extends ParameterParser
{

	/**
	 * 
	 */
	private List<Country> countries = new ArrayList<Country>();

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
				Country country = new Country();
				String countryStr = "";
				s.trim();

				// If any state are specified
				if (s.contains("(") && s.endsWith(")"))
				{

					countryStr = s.substring(0, s.indexOf("("));

					String statesStr = s.substring(s.indexOf("(") + 1, s.length() - 1);

					for (String stateStr : statesStr.split(";"))
					{
						if (isNumeric(stateStr))
						{
							State state = new State();
							state.setId(Integer.parseInt(stateStr));
							country.addState(state);
						}
					}

				} else
				{
					// If there is only the country
					countryStr = s;
				}

				if (isNumeric(countryStr))
				{
					country.setId(Integer.parseInt(countryStr));
					countries.add(country);
				}
			}
		}

	}

	/**
	 * @return the countries
	 */
	public List<Country> getCountries()
	{
		return countries;
	}

	/**
	 * @param countries
	 *            the countries to set
	 */
	public void setCountries(final List<Country> countries)
	{
		this.countries = countries;
	}

}

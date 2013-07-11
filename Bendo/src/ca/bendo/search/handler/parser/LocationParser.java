/**
 * 
 */
package ca.bendo.search.handler.parser;

import java.util.ArrayList;
import java.util.List;

import ca.bendo.form.FieldValidator;

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
	private List<Long> countries = new ArrayList<Long>();

	/**
	 * 
	 */
	private List<Long> states = new ArrayList<Long>();

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
				s.trim();

				// If any state are specified
				if (s.contains("(") && s.endsWith(")"))
				{
					String statesStr = s.substring(s.indexOf("(") + 1, s.length() - 1);

					for (String stateStr : statesStr.split(";"))
					{
						if (FieldValidator.isInt(stateStr))
						{
							states.add(Long.parseLong(stateStr));
						}
					}

				} else
				{

					// If there is only the country
					if (FieldValidator.isInt(s))
					{

						countries.add(Long.parseLong(s));
					}
				}

			}
		}

	}

	/**
	 * @return the countries
	 */
	public List<Long> getCountries()
	{
		return countries;
	}

	/**
	 * @param countries
	 *            the countries to set
	 */
	public void setCountries(final List<Long> countries)
	{
		this.countries = countries;
	}

	/**
	 * @return the states
	 */
	public List<Long> getStates()
	{
		return states;
	}

	/**
	 * @param states
	 *            the states to set
	 */
	public void setStates(final List<Long> states)
	{
		this.states = states;
	}
}

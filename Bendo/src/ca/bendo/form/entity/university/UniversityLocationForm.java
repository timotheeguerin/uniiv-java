/**
 * 
 */
package ca.bendo.form.entity.university;

import ca.bendo.db.entity.location.Location;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UniversityLocationForm</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class UniversityLocationForm
{
	/**
	 * 
	 */
	private long state;

	/**
	 * 
	 */
	private long country;

	/**
	 * 
	 */
	private String city;

	/**
	 * 
	 */
	public UniversityLocationForm()
	{
	}

	/**
	 * 
	 */
	public UniversityLocationForm(Location location)
	{
		this.country = location.getCountry().getId();
		this.state = location.getState().getId();
		this.city = location.getCity();
	}

	/**
	 * @return the state
	 */
	public long getState()
	{
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(long state)
	{
		this.state = state;
	}

	/**
	 * @return the country
	 */
	public long getCountry()
	{
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(long country)
	{
		this.country = country;
	}

	/**
	 * @return the city
	 */
	public String getCity()
	{
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city)
	{
		this.city = city;
	}

}

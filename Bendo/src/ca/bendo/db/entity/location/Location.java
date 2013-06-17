/**
 * 
 */
package ca.bendo.db.entity.location;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>Location</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "uni_location")
public class Location
{

	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_uni_location")
	private long id;

	/**
	 * 
	 */
	@Column(name = "city")
	private String city;

	/**
	 * 
	 */
	@ManyToOne(optional = true)
	@JoinColumn(name = "id_loc_state", nullable = true)
	private State state;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_loc_country")
	private Country country;

	/**
	 * @return the id
	 */
	public long getId()
	{
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final long id)
	{
		this.id = id;
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
	public void setCity(final String city)
	{
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public State getState()
	{
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(final State state)
	{
		this.state = state;
	}

	/**
	 * @return the country
	 */
	public Country getCountry()
	{
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(final Country country)
	{
		this.country = country;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		result.append(city);
		result.append(", ");
		result.append(country.toString());
		if (state != null)
		{
			result.append("(" + state + ")");
		}

		return result.toString();
	}
}

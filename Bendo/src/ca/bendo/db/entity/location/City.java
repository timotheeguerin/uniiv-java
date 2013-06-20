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
 *          <b>City</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "loc_city")
public class City
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_loc_city")
	private long id;

	/**
	 * 
	 */
	@Column(name = "name")
	private String name;

	/**
	 * 
	 */
	@ManyToOne(optional = true)
	@JoinColumn(name = "id_loc_state")
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
}

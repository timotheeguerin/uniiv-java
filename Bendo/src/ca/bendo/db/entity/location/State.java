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

import org.hibernate.annotations.Formula;

import ca.bendo.db.entity.lang.Translation;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>State</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "loc_state")
public class State
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_loc_state", nullable = false, unique = true)
	private long id;

	/**
	 * 
	 */
	@Column(name = "name")
	private String name;

	/**
	 * 
	 */
	@Formula(Translation.FORMULA)
	private String translation;

	/**
	 * id of the linked country.
	 */
	@ManyToOne
	@JoinColumn(name = "id_loc_country", insertable = false, updatable = false)
	private Country country;

	/**
	 * @return the idLocState
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
	 * @return the state
	 */
	public String getState()
	{
		return name;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(final String state)
	{
		this.name = state;
	}

	/**
	 * @return the country id
	 */
	public Country getCountry()
	{
		return country;
	}

	/**
	 * @param country
	 *            the idCountry to set
	 */
	public void setCountry(final Country country)
	{
		this.country = country;
	}

	/**
	 * @return the translation
	 */
	public String getTranslation()
	{
		if (translation != null)
		{
			return translation;
		} else
		{
			return name;
		}
	}

	/**
	 * @param translation
	 *            the translation to set
	 */
	public void setTranslation(final String translation)
	{
		this.translation = translation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return getTranslation();
	}

}

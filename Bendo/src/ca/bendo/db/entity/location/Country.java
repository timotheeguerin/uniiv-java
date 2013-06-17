/**
 * 
 */
package ca.bendo.db.entity.location;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>Country</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "loc_country")
public class Country
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_loc_country", nullable = false, unique = true)
	private long id;

	/**
	 * 
	 */
	@Column(name = "country")
	private String country;

	/**
	 * 
	 */
	@OneToMany(mappedBy = "country")
	private List<State> states = new ArrayList<State>();

	/**
	 * 
	 */
	@Formula("(SELECT t.translation FROM lang_translation t "
			+ "WHERE (t.key = country) AND t.id_lang_language = :languageId.param)")
	private String translation;

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
	 * @return the country
	 */
	public String getCountry()
	{
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(final String country)
	{
		this.country = country;
	}

	/**
	 * @return the states
	 */
	public List<State> getStates()
	{
		return states;
	}

	/**
	 * @param states
	 *            the states to set
	 */
	public void setStates(final List<State> states)
	{
		this.states = states;
	}

	/**
	 * @return if the country has state
	 */
	public boolean hasStates()
	{
		return states != null && !states.isEmpty();
	}

	/**
	 * @param state
	 *            State to add
	 */
	public void addState(final State state)
	{
		if (!states.contains(state))
		{
			states.add(state);
		}
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
			return country;
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

/**
 * 
 */
package ca.bendo.db.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UserState</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "user_state")
public class UserState
{
	/**
	 * State id.
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_user_state")
	private int id;

	/**
	 * State name.
	 */
	@Column(name = "state")
	private String state;

	/**
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final int id)
	{
		this.id = id;
	}

	/**
	 * @return the state
	 */
	public String getState()
	{
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(final String state)
	{
		this.state = state;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return state;
	}
}

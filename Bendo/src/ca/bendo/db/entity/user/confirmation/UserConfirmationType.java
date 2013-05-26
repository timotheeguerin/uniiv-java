/**
 * 
 */
package ca.bendo.db.entity.user.confirmation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UserConfirmationType</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "user_confirmation_type")
public class UserConfirmationType
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_user_confirmation_type", nullable = false, unique = true)
	private long id;

	/**
	 * 
	 */
	@Column(name = "name")
	private String name;

	/**
	 * @return the id
	 */
	public final long getId()
	{
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public final void setId(final long id)
	{
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public final String getName()
	{
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public final void setName(final String name)
	{
		this.name = name;
	}

}

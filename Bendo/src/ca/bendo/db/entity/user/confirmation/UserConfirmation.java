/**
 * 
 */
package ca.bendo.db.entity.user.confirmation;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ca.bendo.db.entity.user.User;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UserConfirmation</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "user_confirmation")
public class UserConfirmation
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_user_confirmation")
	private long id;

	/**
	 * 
	 */
	@Column(name = "`key`")
	private String key;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_user_confirmation_type")
	private UserConfirmationType type;

	/**
	 * 
	 */
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = " date")
	private Date date;

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
	 * @return the key
	 */
	public final String getKey()
	{
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public final void setKey(final String key)
	{
		this.key = key;
	}

	/**
	 * @return the user
	 */
	public final User getUser()
	{
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public final void setUser(final User user)
	{
		this.user = user;
	}

	/**
	 * @return the type
	 */
	public final UserConfirmationType getType()
	{
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public final void setType(final UserConfirmationType type)
	{
		this.type = type;
	}

	/**
	 * @return the date
	 */
	public final Date getDate()
	{
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public final void setDate(final Date date)
	{
		this.date = date;
	}
	
	

}

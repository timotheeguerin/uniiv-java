/**
 * 
 */
package ca.bendo.db.entity.user;

import java.util.Date;

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
 *          <b>UserResetPassword</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "user_reset_password")
public class UserResetPassword
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_user_reset_password", nullable = false, unique = true)
	private long id;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_user", nullable = false)
	private User user;

	/**
	 * 
	 */
	@Column(name = "key", nullable = false)
	private String key;

	/**
	 * 
	 */
	@Column(name = "date_expired", nullable = false)
	private Date dateExpired;

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
	 * @return the user
	 */
	public User getUser()
	{
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(final User user)
	{
		this.user = user;
	}

	/**
	 * @return the key
	 */
	public String getKey()
	{
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(final String key)
	{
		this.key = key;
	}

	/**
	 * @return the dateExpired
	 */
	public Date getDateExpired()
	{
		return dateExpired;
	}

	/**
	 * @param dateExpired
	 *            the dateExpired to set
	 */
	public void setDateExpired(final Date dateExpired)
	{
		this.dateExpired = dateExpired;
	}

}

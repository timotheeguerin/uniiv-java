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
 *          <b>UserConfirmation</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "user_email_confirmation")
public class UserEmailConfirmation
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_user_email_confirmation")
	private long id;

	/**
	 * 
	 */
	@Column(name = "key")
	private String key;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_user_email")
	private UserEmail userEmail;

	/**
	 * 
	 */
	@Column(name = "date_created")
	private Date dateCreated;

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
	 * @return the userEmail
	 */
	public UserEmail getUserEmail()
	{
		return userEmail;
	}

	/**
	 * @param userEmail
	 *            the userEmail to set
	 */
	public void setUserEmail(final UserEmail userEmail)
	{
		this.userEmail = userEmail;
	}

	/**
	 * @return the dateCreated
	 */
	public Date getDateCreated()
	{
		return dateCreated;
	}

	/**
	 * @param dateCreated
	 *            the dateCreated to set
	 */
	public void setDateCreated(final Date dateCreated)
	{
		this.dateCreated = dateCreated;
	}

}

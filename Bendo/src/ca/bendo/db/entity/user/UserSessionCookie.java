/**
 * 
 */
package ca.bendo.db.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import ca.bendo.user.element.HashedPassword;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UserSessionCookie</b>
 *          <p>
 *          </p>
 * 
 *          |
 */
@Entity
@Table(name = "user_session_cookie")
public class UserSessionCookie
{
	/**
	 * 
	 */
	@Id
	@Column(name = "id_user")
	private long userId;

	/**
	 * 
	 */
	@Type(type = "ca.bendo.db.type.HashPasswordType")
	@Column(name = "key", nullable = false)
	private HashedPassword key;

	/**
	 * @return the userId
	 */
	public long getUserId()
	{
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(final long userId)
	{
		this.userId = userId;
	}

	/**
	 * @return the key
	 */
	public HashedPassword getKey()
	{
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(final HashedPassword key)
	{
		this.key = key;
	}

}

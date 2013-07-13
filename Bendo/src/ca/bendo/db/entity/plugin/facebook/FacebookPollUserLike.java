/**
 * 
 */
package ca.bendo.db.entity.plugin.facebook;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ca.bendo.db.entity.user.User;

/**
 * @author Timoth�e Gu�rin
 * @version Bendo
 * 
 *          <b>FacebookPollUserLike</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "plugin_facebook_poll_user_like")
public class FacebookPollUserLike
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_plugin_facebook_poll_user_like", nullable = false, unique = true)
	private long id;

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
	@JoinColumn(name = "id_plugin_facebook_poll_entity")
	private FacebookPollEntity entity;

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
	 * @return the entity
	 */
	public FacebookPollEntity getEntity()
	{
		return entity;
	}

	/**
	 * @param entity
	 *            the entity to set
	 */
	public void setEntity(final FacebookPollEntity entity)
	{
		this.entity = entity;
	}

}
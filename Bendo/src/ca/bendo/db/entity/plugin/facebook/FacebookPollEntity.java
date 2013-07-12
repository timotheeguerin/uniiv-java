/**
 * 
 */
package ca.bendo.db.entity.plugin.facebook;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>FacebookPollEntity</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "plugin_facebook_poll_entity")
public class FacebookPollEntity
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_plugin_facebook_poll_entity", unique = true, nullable = false)
	private long id;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_plugin_facebook_poll", nullable = false)
	private FacebookPoll poll;

	/**
	 * 
	 */
	@Column(name = "name", nullable = false)
	private String name;

	/**
	 * 
	 */
	@Column(name = "facebook_id", nullable = false)
	private long facebookId;

	/**
	 * 
	 */
	@OneToMany(mappedBy = "entity")
	private Set<FacebookPollUserLike> likes;

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
	 * @return the poll
	 */
	public FacebookPoll getPoll()
	{
		return poll;
	}

	/**
	 * @param poll
	 *            the poll to set
	 */
	public void setPoll(final FacebookPoll poll)
	{
		this.poll = poll;
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
	 * @return the facebookId
	 */
	public long getFacebookId()
	{
		return facebookId;
	}

	/**
	 * @param facebookId
	 *            the facebookId to set
	 */
	public void setFacebookId(final long facebookId)
	{
		this.facebookId = facebookId;
	}

	/**
	 * @return the likes
	 */
	public Set<FacebookPollUserLike> getLikes()
	{
		return likes;
	}

	/**
	 * @param likes
	 *            the likes to set
	 */
	public void setLikes(final Set<FacebookPollUserLike> likes)
	{
		this.likes = likes;
	}

}

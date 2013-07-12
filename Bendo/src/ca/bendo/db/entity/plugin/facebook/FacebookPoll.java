/**
 * 
 */
package ca.bendo.db.entity.plugin.facebook;

import java.util.List;

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
 *          <b>FacebookPoll</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "plugin_facebook_poll")
public class FacebookPoll
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_plugin_facebook_poll")
	private long id;

	/**
	 * 
	 */
	@Column(name = "name")
	private String name;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_plugin_facebook_poll_type")
	private FacebookPollType type;

	/**
	 * 
	 */
	@OneToMany(mappedBy = "poll")
	private List<FacebookPollEntity> entities;

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
	 * @return the type
	 */
	public FacebookPollType getType()
	{
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(final FacebookPollType type)
	{
		this.type = type;
	}

	/**
	 * @return the entities
	 */
	public List<FacebookPollEntity> getEntities()
	{
		return entities;
	}

	/**
	 * @param entities
	 *            the entities to set
	 */
	public void setEntities(final List<FacebookPollEntity> entities)
	{
		this.entities = entities;
	}

}

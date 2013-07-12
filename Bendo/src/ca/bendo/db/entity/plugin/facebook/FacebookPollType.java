/**
 * 
 */
package ca.bendo.db.entity.plugin.facebook;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>FacebookPollType</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "plugin_facebook_poll_type")
public class FacebookPollType
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_plugin_facebook_poll_type")
	private long id;

	/**
	 * 
	 */
	@Column(name = "name")
	private String name;

	/**
	 * 
	 */
	@Column(name = "facebook_type")
	private String facebookType;

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
	 * @return the facebookType
	 */
	public String getFacebookType()
	{
		return facebookType;
	}

	/**
	 * @param facebookType
	 *            the facebookType to set
	 */
	public void setFacebookType(final String facebookType)
	{
		this.facebookType = facebookType;
	}

}

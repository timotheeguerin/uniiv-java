/**
 * 
 */
package ca.bendo.db.entity.forum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>Group</b>
 *          <p>
 *          </p>
 *          
 */
@Entity
@Table(name = "forum_group")
public class ForumGroup
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_forum_group")
	private long id;

	/**
	 * 
	 */
	@Column(name = "name")
	private String name;

	/**
	 * @return the id
	 */
	public long getId()
	{
		return id;
	}

	/**
	 * @param id the id to set
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
	 * @param name the name to set
	 */
	public void setName(final String name)
	{
		this.name = name;
	}
}

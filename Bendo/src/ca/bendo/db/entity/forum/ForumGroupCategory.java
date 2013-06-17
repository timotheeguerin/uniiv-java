/**
 * 
 */
package ca.bendo.db.entity.forum;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ForumCategory</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "forum_group_category")
public class ForumGroupCategory
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_forum_group_category", nullable = false, unique = true)
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
	@JoinColumn(name = "id_forum_group_type")
	private ForumGroupType type;

	/**
	 * 
	 */
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "forum_group_category_tag", joinColumns = { @JoinColumn(name = "id_forum_group_category") },
			inverseJoinColumns = { @JoinColumn(name = "id_forum_tag") })
	private Set<ForumTag> tags;

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
	public ForumGroupType getType()
	{
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(final ForumGroupType type)
	{
		this.type = type;
	}

	/**
	 * @return the tags
	 */
	public Set<ForumTag> getTags()
	{
		return tags;
	}

	/**
	 * @param tags
	 *            the tags to set
	 */
	public void setTags(final Set<ForumTag> tags)
	{
		this.tags = tags;
	}

}

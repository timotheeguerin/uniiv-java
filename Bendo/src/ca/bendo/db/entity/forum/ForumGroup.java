/**
 * 
 */
package ca.bendo.db.entity.forum;

import java.util.List;

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
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "parent")
	private ForumGroup parent;

	/**
	 * 
	 */
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "forum_group_tag", joinColumns = { @JoinColumn(name = "id_forum_group") },
			inverseJoinColumns = { @JoinColumn(name = "id_forum_tag") })
	private List<ForumTag> tags;

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
	 * @return the parent
	 */
	public ForumGroup getParent()
	{
		return parent;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(final ForumGroup parent)
	{
		this.parent = parent;
	}

	/**
	 * @return the tags
	 */
	public List<ForumTag> getTags()
	{
		return tags;
	}

	/**
	 * @param tags
	 *            the tags to set
	 */
	public void setTags(final List<ForumTag> tags)
	{
		this.tags = tags;
	}

	/**
	 * 
	 * @return list of all the tags of the group as well as the tags of the
	 *         parents
	 */
	public List<ForumTag> getGeneratedTags()
	{
		List<ForumTag> result = getTags();

		if (parent != null)
		{
			result.addAll(parent.getGeneratedTags());
		}
		return result;
	}

}

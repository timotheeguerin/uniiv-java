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
import javax.persistence.Table;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ForumCenter</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "forum_center")
public class ForumCenter
{

	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_forum_center")
	private long id;

	/**
	 * 
	 */
	@Column(name = "name")
	private String name;

	/**
	 * 
	 */
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "forum_center_group", joinColumns = { @JoinColumn(name = "id_forum_center") },
			inverseJoinColumns = { @JoinColumn(name = "id_forum_group") })
	private List<ForumGroup> groups;

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
	public void setId(long id)
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
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return the groups
	 */
	public List<ForumGroup> getGroups()
	{
		return groups;
	}

	/**
	 * @param groups
	 *            the groups to set
	 */
	public void setGroups(List<ForumGroup> groups)
	{
		this.groups = groups;
	}

}

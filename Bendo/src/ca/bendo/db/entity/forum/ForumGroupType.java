/**
 * 
 */
package ca.bendo.db.entity.forum;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ForumGroupType</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "forum_group_type")
public class ForumGroupType
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_forum_group_type", nullable = false, unique = true)
	private long id;

	/**
	 * 
	 */
	@Column(name = "name")
	private String name;

	/**
	 * 
	 */
	@OneToMany(mappedBy = "type")
	private Set<ForumGroupCategory> categories;

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
	 * @return the categories
	 */
	public Set<ForumGroupCategory> getCategories()
	{
		return categories;
	}

	/**
	 * @param categories
	 *            the categories to set
	 */
	public void setCategories(final Set<ForumGroupCategory> categories)
	{
		this.categories = categories;
	}

}

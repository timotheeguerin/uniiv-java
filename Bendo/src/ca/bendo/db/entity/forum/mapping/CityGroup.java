/**
 * 
 */
package ca.bendo.db.entity.forum.mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ca.bendo.db.entity.forum.ForumGroup;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>CityGroup</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "forum_city_group")
public class CityGroup
{
	/**
	 * 
	 */
	@Id
	@Column(name = "id_loc_city")
	private long cityId;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "group")
	private ForumGroup group;

	/**
	 * @return the cityId
	 */
	public long getCityId()
	{
		return cityId;
	}

	/**
	 * @param cityId
	 *            the cityId to set
	 */
	public void setCityId(final long cityId)
	{
		this.cityId = cityId;
	}

	/**
	 * @return the group
	 */
	public ForumGroup getGroup()
	{
		return group;
	}

	/**
	 * @param group
	 *            the group to set
	 */
	public void setGroup(final ForumGroup group)
	{
		this.group = group;
	}
}

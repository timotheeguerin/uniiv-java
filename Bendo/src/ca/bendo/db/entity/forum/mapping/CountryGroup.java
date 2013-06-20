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
 *          <b>CountryGroupDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "forum_state_group")
public class CountryGroup
{
	/**
	 * 
	 */
	@Id
	@Column(name = "id_loc_country")
	private long countryId;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "group")
	private ForumGroup group;

	/**
	 * @return the countryId
	 */
	public long getCountryId()
	{
		return countryId;
	}

	/**
	 * @param countryId
	 *            the countryId to set
	 */
	public void setCountryId(final long countryId)
	{
		this.countryId = countryId;
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

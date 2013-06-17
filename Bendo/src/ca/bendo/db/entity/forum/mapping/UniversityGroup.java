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
 *          <b>UniversityGroupDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "university_group")
public class UniversityGroup
{
	/**
	 * 
	 */
	@Id
	@Column(name = "id_uni_university")
	private long universityId;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_forum_group")
	private ForumGroup group;

	/**
	 * @return the universityId
	 */
	public long getUniversityId()
	{
		return universityId;
	}

	/**
	 * @param universityId
	 *            the universityId to set
	 */
	public void setUniversityId(final long universityId)
	{
		this.universityId = universityId;
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

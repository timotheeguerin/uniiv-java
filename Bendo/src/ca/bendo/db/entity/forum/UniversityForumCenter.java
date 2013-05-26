/**
 * 
 */
package ca.bendo.db.entity.forum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UniversityForumCenter</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "university_forum_center")
public class UniversityForumCenter
{
	/**
	 * 
	 */
	@Id
	@Column(name = "id_university")
	private long universityId;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_forum_center")
	private ForumCenter center;

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
	 * @return the center
	 */
	public ForumCenter getCenter()
	{
		return center;
	}

	/**
	 * @param center
	 *            the center to set
	 */
	public void setCenter(final ForumCenter center)
	{
		this.center = center;
	}

}

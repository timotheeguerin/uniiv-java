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
 *          <b>StateGroup</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "forum_state_group")
public class StateGroup
{
	/**
	 * 
	 */
	@Id
	@Column(name = "id_loc_state")
	private long stateId;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "group")
	private ForumGroup group;

	/**
	 * @return the stateId
	 */
	public long getStateId()
	{
		return stateId;
	}

	/**
	 * @param stateId
	 *            the stateId to set
	 */
	public void setStateId(final long stateId)
	{
		this.stateId = stateId;
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

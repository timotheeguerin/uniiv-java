/**
 * 
 */
package ca.bendo.form.entity.plugin;

import javax.validation.constraints.NotNull;

import ca.bendo.db.dao.plugin.facebook.FacebookPollDAO;
import ca.bendo.db.dao.plugin.facebook.FacebookPollEntityDAO;
import ca.bendo.form.constaints.annotation.Exist;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>LikeFacebookPollEntityForm</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class LikeFacebookPollEntityForm
{
	/**
	 * 
	 */
	@NotNull
	@Exist(dao = FacebookPollDAO.class)
	private long pollId;

	/**
	 * 
	 */
	@NotNull
	@Exist(dao = FacebookPollEntityDAO.class)
	private long entityId;

	/**
	 * @return the pollId
	 */
	public long getPollId()
	{
		return pollId;
	}

	/**
	 * @param pollId
	 *            the pollId to set
	 */
	public void setPollId(final long pollId)
	{
		this.pollId = pollId;
	}

	/**
	 * @return the entityId
	 */
	public long getEntityId()
	{
		return entityId;
	}

	/**
	 * @param entityId
	 *            the entityId to set
	 */
	public void setEntityId(final long entityId)
	{
		this.entityId = entityId;
	}

}

/**
 * 
 */
package ca.bendo.form.entity.plugin;

import javax.validation.constraints.NotNull;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>InputFacebookPollForm</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class InputFacebookPollForm
{
	/**
	 * 
	 */
	@NotNull
	private long pollId;

	/**
	 * 
	 */
	@NotNull
	private long id;

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

}

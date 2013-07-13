/**
 * 
 */
package ca.bendo.form.entity.plugin;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import ca.bendo.db.dao.plugin.facebook.FacebookPollDAO;
import ca.bendo.form.constaints.annotation.Exist;

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
public class NewEntityFacebookPollForm
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
	private long id;

	/**
	 * 
	 */
	@NotEmpty
	private String name;

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

}

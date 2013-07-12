/**
 * 
 */
package ca.bendo.form.entity.plugin;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import ca.bendo.db.dao.plugin.facebook.FacebookPollTypeDAO;
import ca.bendo.form.constaints.annotation.Exist;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>NewFacebookPollForm</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class NewFacebookPollForm
{
	/**
	 * 
	 */
	private static final int POLL_MIN_TITLE_SIZE = 5;
	/**
	 * 
	 */
	@NotNull
	@Length(min = POLL_MIN_TITLE_SIZE)
	private String title;

	/**
	 * 
	 */
	@NotNull
	@Exist(dao = FacebookPollTypeDAO.class)
	private long type;

	/**
	 * @return the title
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(final String title)
	{
		this.title = title;
	}

	/**
	 * @return the type
	 */
	public long getType()
	{
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(final long type)
	{
		this.type = type;
	}

}

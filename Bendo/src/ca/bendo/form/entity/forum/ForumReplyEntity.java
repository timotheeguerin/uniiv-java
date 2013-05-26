/**
 * 
 */
package ca.bendo.form.entity.forum;

import org.hibernate.validator.constraints.Length;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ForumReplyEntity</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class ForumReplyEntity
{

	/**
	 * 
	 */
	private static final int MIN_CONTENT_SIZE = 30;

	/**
	 * 
	 */
	@Length(min = MIN_CONTENT_SIZE)
	private String content;

	/**
	 * @return the content
	 */
	public String getContent()
	{
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(final String content)
	{
		this.content = content;
	}

}

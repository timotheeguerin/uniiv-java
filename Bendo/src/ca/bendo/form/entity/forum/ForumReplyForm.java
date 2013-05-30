/**
 * 
 */
package ca.bendo.form.entity.forum;

import javax.validation.constraints.Min;

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
public class ForumReplyForm
{

	/**
	 * 
	 */
	private static final int MIN_CONTENT_SIZE = 30;

	/**
	 * 
	 */
	@Min(value = MIN_CONTENT_SIZE, message = "form.error.min")
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

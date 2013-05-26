/**
 * 
 */
package ca.bendo.form.entity.forum;

import ca.bendo.annotation.Input;
import ca.bendo.form.entity.Entity;
import ca.bendo.form.entity.EntityType;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ForumQuestionEntity</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class ForumQuestionEntity extends Entity
{
	/**
	 * 
	 */
	private static final long MIN_TITLE_SIZE = 10;

	/**
	 * 
	 */
	private static final long MAX_TITLE_SIZE = 255;

	/**
	 * 
	 */
	private static final long MIN_CONTENT_SIZE = 30;

	/**
	 * 
	 */
	@Input(name = "title", type = EntityType.TEXT, min = MIN_TITLE_SIZE, max = MAX_TITLE_SIZE)
	private String title;

	/**
	 * 
	 */
	@Input(name = "content", type = EntityType.TEXT, min = MIN_CONTENT_SIZE)
	private String content;

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
	public void setContent(String content)
	{
		this.content = content;
	}

}

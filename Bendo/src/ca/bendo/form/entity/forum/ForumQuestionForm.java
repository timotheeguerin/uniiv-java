/**
 * 
 */
package ca.bendo.form.entity.forum;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import ca.bendo.db.entity.forum.ForumQuestion;
import ca.bendo.form.entity.Entity;

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
public class ForumQuestionForm
{
	/**
	 * 
	 */
	private static final int MIN_TITLE_SIZE = 10;

	/**
	 * 
	 */
	private static final int MAX_TITLE_SIZE = 255;

	/**
	 * 
	 */
	private static final int MIN_CONTENT_SIZE = 30;

	/**
	 * 
	 */
	@NotNull
	@Length(min = MIN_TITLE_SIZE, max = MAX_TITLE_SIZE)
	private String title;

	/**
	 * 
	 */
	@NotNull
	@Length(min = MIN_CONTENT_SIZE)
	private String content;

	/**
	 * 
	 */
	@NotNull
	private String tags;

	/**
	 * Initialise the the form with the databse object.
	 * 
	 * @param question
	 *            Question object
	 */
	public ForumQuestionForm(final ForumQuestion question)
	{
		this.title = question.getTitle();
		this.content = question.getContent().getContent();
		this.tags = question.getTagsString();
	}

	/**
	 * 
	 */
	public ForumQuestionForm()
	{

	}

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
	public void setContent(final String content)
	{
		this.content = content;
	}

	/**
	 * @return the tags
	 */
	public String getTags()
	{
		return tags;
	}

	/**
	 * @param tags
	 *            the tags to set
	 */
	public void setTags(final String tags)
	{
		this.tags = tags;
	}
}

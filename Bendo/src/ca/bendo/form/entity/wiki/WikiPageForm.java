/**
 * 
 */
package ca.bendo.form.entity.wiki;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>WikiPageForm</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class WikiPageForm
{
	/**
	 * 
	 */
	static final int MIN_TITLE_SIZE = 10;

	/**
	 * 
	 */
	static final int MAX_TITLE_SIZE = 255;

	/**
	 * 
	 */
	static final int MIN_CONTENT_SIZE = 30;

	/**
	 * 
	 */
	static final int MIN_COMMENT_SIZE = 10;

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
	@NotBlank
	private String tags;

	/**
	 * 
	 */
	@NotNull
	@Length(min = MIN_COMMENT_SIZE)
	private String comment;

	/**
	 * 
	 */
	public WikiPageForm()
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

	/**
	 * @return the comment
	 */
	public String getComment()
	{
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(final String comment)
	{
		this.comment = comment;
	}

}

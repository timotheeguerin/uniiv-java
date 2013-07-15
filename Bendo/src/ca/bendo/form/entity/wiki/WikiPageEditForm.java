/**
 * 
 */
package ca.bendo.form.entity.wiki;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import ca.bendo.db.entity.wiki.WikiPage;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>WikiPageEditForm</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class WikiPageEditForm
{

	/**
	 * 
	 */
	@NotNull
	@Length(min = WikiPageForm.MIN_CONTENT_SIZE)
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
	@Length(min = WikiPageForm.MIN_COMMENT_SIZE)
	private String comment;

	/**
	 * 
	 */
	public WikiPageEditForm()
	{
	}
	/**
	 * @param page
	 *            page
	 */
	public WikiPageEditForm(final WikiPage page)
	{
		this.content = page.getLastRevision().getContent().getContent();
		this.tags = page.getTagsString();
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

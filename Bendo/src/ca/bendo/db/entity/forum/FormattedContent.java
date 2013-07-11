/**
 * 
 */
package ca.bendo.db.entity.forum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import ca.bendo.db.entity.wiki.ContentDifference;
import ca.bendo.utils.MarkdownUtils;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ForumContent</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "formatted_content")
public class FormattedContent
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_formatted_content")
	private long id;

	/**
	 * 
	 */
	@Column(name = "content")
	private String content;

	/**
	 * 
	 */
	@Column(name = "html")
	private String html;

	/**
	 * 
	 */
	public FormattedContent()
	{

	}

	/**
	 * @param content
	 *            Content to set
	 * 
	 */
	public FormattedContent(final String content)
	{
		setContent(content);
	}

	/**
	 * 
	 * @param oldContent
	 *            OldREvision
	 * @return differences
	 */
	public ContentDifference computeDifference(final FormattedContent oldContent)
	{
		List<String> oldLines = oldContent.listLine();
		List<String> newLines = this.listLine();

		List<String> addition = new ArrayList<String>(newLines);
		addition.removeAll(oldLines);

		List<String> deletion = new ArrayList<String>(oldLines);
		deletion.removeAll(newLines);

		ContentDifference difference = new ContentDifference();
		difference.setAddition(addition.size());
		difference.setDeletion(deletion.size());

		return difference;

	}

	/**
	 * 
	 * @return number of line in the content
	 */
	public List<String> listLine()
	{
		return Arrays.asList(content.split("\r\n|\r|\n"));
	}

	/**
	 * 
	 */
	public void processContent()
	{
		html = MarkdownUtils.process(content);
	}

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
		processContent();
	}

	/**
	 * @return the html
	 */
	public String getHtml()
	{
		return html;
	}

	/**
	 * @param html
	 *            the html to set
	 */
	public void setHtml(final String html)
	{
		this.html = html;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return getHtml();
	}

}

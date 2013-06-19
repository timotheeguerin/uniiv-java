/**
 * 
 */
package ca.bendo.db.entity.forum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.github.rjeschke.txtmark.Processor;

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
	public void processContent()
	{
		html = Processor.process(content);
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

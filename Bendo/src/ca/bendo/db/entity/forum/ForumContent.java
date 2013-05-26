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
 * @author Timoth�e Gu�rin
 * @version Bendo
 * 
 *          <b>ForumContent</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "forum_message")
public class ForumContent
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_forum_message")
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
	public final long getId()
	{
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public final void setId(final long id)
	{
		this.id = id;
	}

	/**
	 * @return the content
	 */
	public final String getContent()
	{
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public final void setContent(final String content)
	{
		this.content = content;
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
	public void setHtml(String html)
	{
		this.html = html;
	}

}

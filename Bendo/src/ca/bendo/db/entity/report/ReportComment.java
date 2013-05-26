/**
 * 
 */
package ca.bendo.db.entity.report;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ca.bendo.db.entity.lang.Language;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>Comment</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "report_comment")
public class ReportComment
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_report_comment")
	private long id;

	/**
	 * 
	 */
	@Column(name = "content")
	private String content;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_uni_language")
	private Language language;

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
	 * @return the language
	 */
	public final Language getLanguage()
	{
		return language;
	}

	/**
	 * @param language
	 *            the language to set
	 */
	public final void setLanguage(final Language language)
	{
		this.language = language;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return getContent();
	}

}

/**
 * 
 */
package ca.bendo.db.entity.wiki;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ca.bendo.db.entity.forum.FormattedContent;
import ca.bendo.db.entity.user.User;
import ca.bendo.utils.DiffTest;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>WikiRevision</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "wiki_revision")
public class WikiRevision
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_wiki_revision", nullable = false)
	private long id;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_wiki_page", nullable = false)
	private WikiPage page;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_formatted_content", nullable = false)
	private FormattedContent content;

	/**
	 * 
	 */
	@Column(name = "comment", nullable = false)
	private String comment;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_user", nullable = false)
	private User user;

	/**
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_parent", nullable = true)
	private WikiRevision parent;

	/**
	 * 
	 */
	@Column(name = "date_created", nullable = false)
	private Date dateCreated;

	/**
	 * 
	 */
	@Column(name = "validated", nullable = false)
	private boolean validated;

	/**
	 * 
	 */
	@Column(name = "line_addition", nullable = false)
	private long lineAddition;

	/**
	 * 
	 */
	@Column(name = "line_deletion", nullable = false)
	private long lineDeletion;

	/**
	 * 
	 */
	public WikiRevision()
	{

	}

	/**
	 * 
	 * @param user
	 *            User
	 * @param content
	 *            Content
	 * @param comment
	 *            User comment
	 * @param page
	 *            Page
	 */
	public WikiRevision(final User user, final FormattedContent content, final String comment, final WikiPage page)
	{
		this.setComment(comment);
		this.setContent(content);
		this.setDateCreated(new Date());
		this.setLineAddition(0);
		this.setLineDeletion(0);
		this.setPage(page);
		this.setUser(user);
		this.setValidated(false);
	}

	/**
	 * 
	 * @param user
	 *            User
	 * @param content
	 *            Content
	 * @param comment
	 *            User comment
	 * @param page
	 *            Page
	 * @param oldRevision
	 *            Old revision
	 */
	public WikiRevision(final User user, final FormattedContent content, final String comment, final WikiPage page,
			final WikiRevision oldRevision)
	{
		this.setComment(comment);
		this.setContent(content);
		this.setDateCreated(new Date());
		ContentDifference difference = content.computeDifference(oldRevision.getContent());
		this.setLineAddition(difference.getAddition());
		this.setLineDeletion(difference.getDeletion());
		this.setPage(page);
		this.setUser(user);
		this.setValidated(false);
		this.setParent(oldRevision);
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
	 * @return the page
	 */
	public WikiPage getPage()
	{
		return page;
	}

	/**
	 * @param page
	 *            the page to set
	 */
	public void setPage(final WikiPage page)
	{
		this.page = page;
	}

	/**
	 * @return the content
	 */
	public FormattedContent getContent()
	{
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(final FormattedContent content)
	{
		this.content = content;
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

	/**
	 * @return the user
	 */
	public User getUser()
	{
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(final User user)
	{
		this.user = user;
	}

	/**
	 * @return the parent
	 */
	public WikiRevision getParent()
	{
		return parent;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(final WikiRevision parent)
	{
		this.parent = parent;
	}

	/**
	 * @return the dateCreated
	 */
	public Date getDateCreated()
	{
		return dateCreated;
	}

	/**
	 * @param dateCreated
	 *            the dateCreated to set
	 */
	public void setDateCreated(final Date dateCreated)
	{
		this.dateCreated = dateCreated;
	}

	/**
	 * @return the validated
	 */
	public boolean isValidated()
	{
		return validated;
	}

	/**
	 * @param validated
	 *            the validated to set
	 */
	public void setValidated(final boolean validated)
	{
		this.validated = validated;
	}

	/**
	 * @return the lineAddition
	 */
	public long getLineAddition()
	{
		return lineAddition;
	}

	/**
	 * @param lineAddition
	 *            the lineAddition to set
	 */
	public void setLineAddition(final long lineAddition)
	{
		this.lineAddition = lineAddition;
	}

	/**
	 * @return the lineDeletion
	 */
	public long getLineDeletion()
	{
		return lineDeletion;
	}

	/**
	 * @param lineDeletion
	 *            the lineDeletion to set
	 */
	public void setLineDeletion(final long lineDeletion)
	{
		this.lineDeletion = lineDeletion;
	}

}

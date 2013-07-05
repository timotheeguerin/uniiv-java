/**
 * 
 */
package ca.bendo.db.entity.wiki;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.apache.commons.lang.StringUtils;

import ca.bendo.db.entity.forum.FormattedContent;
import ca.bendo.db.entity.forum.Tag;
import ca.bendo.db.entity.user.User;

/**
 * @author toby
 * @version Bendo
 * 
 *          <b>Wiki</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "wiki_page")
public class WikiPage
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_wiki_page")
	private long id;

	/**
	 * 
	 */
	@Column(name = "id_user")
	private long user;

	/**
	 * 
	 */
	@Column(name = "date_created")
	private Date dateCreated;

	/**
	 * 
	 */
	@Column(name = "last_edited")
	private Date dateEdited;

	/**
	 * 
	 */
	@Column(name = "title")
	private String title;

	/**
	 * 
	 */
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "revision_latest", nullable = false)
	private WikiRevision lastRevision;

	/**
	 * 
	 */
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "revision_latest_valid", nullable = false)
	private WikiRevision lastValidRevision;

	/**
	 * 
	 */
	@Column(name = "validated")
	private boolean valitated;

	/**
	 * 
	 */
	@OrderBy("dateCreated")
	@OneToMany(mappedBy = "page", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private List<WikiRevision> revisions = new ArrayList<WikiRevision>();

	/**
	 * 
	 */
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "wiki_comment", joinColumns = { @JoinColumn(name = "id_wiki") },
			inverseJoinColumns = { @JoinColumn(name = "id_wiki_comment") })
	private List<WikiComment> comments = new ArrayList<WikiComment>();

	/**
	 * 
	 */
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinTable(name = "wiki_tag", joinColumns = { @JoinColumn(name = "id_wiki") }, inverseJoinColumns = { @JoinColumn(
			name = "id_tag") })
	private List<Tag> tags = new ArrayList<Tag>();

	/**
	 * 
	 * @param revisionUser
	 *            User
	 * @param comment
	 *            User comment
	 * @param content
	 *            Content
	 */
	public void createRevision(final User revisionUser, final String comment, final FormattedContent content)
	{
		WikiRevision revision = new WikiRevision(revisionUser, content, comment, this, lastRevision);
		setLastRevision(revision);
	}

	/**
	 * 
	 */
	public void validateLastRevision()
	{
		setLastValidRevision(lastValidRevision);
		setDateEdited(getLastValidRevision().getDateCreated());
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
	 * @return the user
	 */
	public long getUser()
	{
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(final long user)
	{
		this.user = user;
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
	 * @return the dateEdited
	 */
	public Date getDateEdited()
	{
		return dateEdited;
	}

	/**
	 * @param dateEdited
	 *            the dateEdited to set
	 */
	public void setDateEdited(final Date dateEdited)
	{
		this.dateEdited = dateEdited;
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
	 * @return the lastRevision
	 */
	public WikiRevision getLastRevision()
	{
		return lastRevision;
	}

	/**
	 * @param lastRevision
	 *            the lastRevision to set
	 */
	public void setLastRevision(final WikiRevision lastRevision)
	{
		this.lastRevision = lastRevision;
	}

	/**
	 * @return the valitated
	 */
	public boolean isValitated()
	{
		return valitated;
	}

	/**
	 * @param valitated
	 *            the valitated to set
	 */
	public void setValitated(final boolean valitated)
	{
		this.valitated = valitated;
	}

	/**
	 * @return the revisions
	 */
	public List<WikiRevision> getRevisions()
	{
		return revisions;
	}

	/**
	 * @param revisions
	 *            the revisions to set
	 */
	public void setRevisions(final List<WikiRevision> revisions)
	{
		this.revisions = revisions;
	}

	/**
	 * @return the comments
	 */
	public List<WikiComment> getComments()
	{
		return comments;
	}

	/**
	 * @param comments
	 *            the comments to set
	 */
	public void setComments(final List<WikiComment> comments)
	{
		this.comments = comments;
	}

	/**
	 * @return the tags
	 */
	public List<Tag> getTags()
	{
		return tags;
	}

	/**
	 * @param tags
	 *            the tags to set
	 */
	public void setTags(final List<Tag> tags)
	{
		this.tags = tags;
	}

	/**
	 * @return the lastValidRevision
	 */
	public WikiRevision getLastValidRevision()
	{
		return lastValidRevision;
	}

	/**
	 * @param lastValidRevision
	 *            the lastValidRevision to set
	 */
	public void setLastValidRevision(final WikiRevision lastValidRevision)
	{
		this.lastValidRevision = lastValidRevision;
	}

	/**
	 * @return string of all the tags used for display in the format
	 *         tag1,tag2,tag3
	 */
	public String getTagsString()
	{
		return StringUtils.join(tags, ',');
	}

}
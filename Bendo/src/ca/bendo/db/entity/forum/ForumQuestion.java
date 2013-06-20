/**
 * 
 */
package ca.bendo.db.entity.forum;

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
import javax.persistence.Table;

import org.apache.commons.lang.StringUtils;

import ca.bendo.db.entity.user.User;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ForumThread</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "forum_question")
public class ForumQuestion
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_forum_question")
	private long id;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;

	/**
	 * 
	 */
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinTable(name = "forum_question_tag", joinColumns = { @JoinColumn(name = "id_forum_question") },
			inverseJoinColumns = { @JoinColumn(name = "id_tag") })
	private List<Tag> tags = new ArrayList<Tag>();
	/**
	 * 
	 */
	@Column(name = "date_created")
	private Date dateCreated;

	/**
	 * 
	 */
	@Column(name = "last_edited")
	private Date lastEdited;

	/**
	 * 
	 */
	@Column(name = "title")
	private String title;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_formatted_content")
	private FormattedContent content;

	/**
	 * 
	 */
	@OneToMany(mappedBy = "question")
	private List<ForumReply> replies = new ArrayList<ForumReply>();

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
		this.lastEdited = dateCreated;
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
	 * @return the replies
	 */
	public List<ForumReply> getReplies()
	{
		return replies;
	}

	/**
	 * @param replies
	 *            the replies to set
	 */
	public void setReplies(final List<ForumReply> replies)
	{
		this.replies = replies;
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
	 * 
	 * @param tag
	 *            tag to add to the list of tags
	 */
	public void addTag(final Tag tag)
	{
		this.tags.add(tag);
	}

	/**
	 * @return the lastEdited
	 */
	public Date getLastEdited()
	{
		return lastEdited;
	}

	/**
	 * @param lastEdited
	 *            the lastEdited to set
	 */
	public void setLastEdited(final Date lastEdited)
	{
		this.lastEdited = lastEdited;
	}

	/**
	 * 
	 * @param tagList
	 *            List of tags to add
	 */
	public void addAllTags(final List<Tag> tagList)
	{
		this.tags.addAll(tagList);
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

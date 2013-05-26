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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "forum_question_tag", joinColumns = { @JoinColumn(name = "id_forum_question") },
			inverseJoinColumns = { @JoinColumn(name = "id_forum_tag") })
	private List<ForumTag> tags;
	/**
	 * 
	 */
	@Column(name = "date_created")
	private Date dateCreated;

	/**
	 * 
	 */
	@Column(name = "title")
	private String title;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_forum_message")
	private ForumContent content;

	/**
	 * 
	 */
	@OneToMany(mappedBy = "question")
	private List<ForumReply> replies = new ArrayList<ForumReply>();

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
	 * @return the user
	 */
	public final User getUser()
	{
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public final void setUser(final User user)
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
	 * @return the title
	 */
	public final String getTitle()
	{
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public final void setTitle(final String title)
	{
		this.title = title;
	}

	/**
	 * @return the content
	 */
	public final ForumContent getContent()
	{
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public final void setContent(final ForumContent content)
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
	public List<ForumTag> getTags()
	{
		return tags;
	}

	/**
	 * @param tags
	 *            the tags to set
	 */
	public void setTags(final List<ForumTag> tags)
	{
		this.tags = tags;
	}

	/**
	 * 
	 * @param tag
	 *            tag to add to the list of tags
	 */
	public void addTag(final ForumTag tag)
	{
		this.tags.add(tag);
	}

	/**
	 * 
	 * @param tagList
	 *            List of tags to add
	 */
	public void addAllTags(final List<ForumTag> tagList)
	{
		this.tags.addAll(tagList);
	}
}

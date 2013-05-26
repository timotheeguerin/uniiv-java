/**
 * 
 */
package ca.bendo.db.entity.forum;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ca.bendo.db.entity.user.User;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ForumReply</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "forum_reply")
public class ForumReply
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_forum_reply")
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
	@Column(name = "time_created")
	private Date timeCreated;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_forum_content")
	private ForumContent content;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_forum_question")
	private ForumQuestion question;

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
	 * @return the timeCreated
	 */
	public final Date getTimeCreated()
	{
		return timeCreated;
	}

	/**
	 * @param timeCreated
	 *            the timeCreated to set
	 */
	public final void setTimeCreated(final Date timeCreated)
	{
		this.timeCreated = timeCreated;
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
	 * @return the question
	 */
	public ForumQuestion getQuestion()
	{
		return question;
	}

	/**
	 * @param question
	 *            the question to set
	 */
	public void setQuestion(final ForumQuestion question)
	{
		this.question = question;
	}

}

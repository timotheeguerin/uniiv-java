/**
 * 
 */
package ca.bendo.db.entity.user.bookmark;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ca.bendo.db.entity.wiki.Wiki;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UserWikiBookmark</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "user_bookmark_wiki")
public class UserWikiBookmark
{
	/**
	 *
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_user_bookmark_wiki")
	private long id;

	/**
	 * 
	 */
	@Column(name = "id_user")
	private long userId;

	/**
	 * 
	 */
	@Column(name = "date_created")
	private Date dateCreated;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_wiki")
	private Wiki wiki;

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
	 * @return the userId
	 */
	public long getUserId()
	{
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(final long userId)
	{
		this.userId = userId;
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
	 * @return the wiki
	 */
	public Wiki getWiki()
	{
		return wiki;
	}

	/**
	 * @param wiki
	 *            the wiki to set
	 */
	public void setWiki(final Wiki wiki)
	{
		this.wiki = wiki;
	}

}

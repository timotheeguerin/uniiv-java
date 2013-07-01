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

import ca.bendo.db.entity.university.University;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UserUniversityBookmark</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "user_bookmark_university")
public class UserUniversityBookmark
{
	/**
	 *
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_user_bookmark_university")
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
	@JoinColumn(name = "id_uni_university")
	private University university;

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
	 * @return the university
	 */
	public University getUniversity()
	{
		return university;
	}

	/**
	 * @param university
	 *            the university to set
	 */
	public void setUniversity(final University university)
	{
		this.university = university;
	}
}

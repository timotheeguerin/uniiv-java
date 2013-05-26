/**
 * 
 */
package ca.bendo.db.entity.course;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import ca.bendo.db.entity.comment.Comment;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>CourseReview</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "course_review")
public class CourseReview
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_course_review")
	private long id;

	/**
	 * 
	 */
	@OneToOne
	@JoinColumn(name = "id_comment")
	private Comment comment;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_course")
	private Course course;

	/**
	 * 
	 */
	@OneToMany(mappedBy = "review", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<CourseRating> ratings;

	/**
	 * 
	 */
	@Column(name = "date")
	private Date date;

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
	 * @return the comment
	 */
	public final Comment getComment()
	{
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public final void setComment(final Comment comment)
	{
		this.comment = comment;
	}

	/**
	 * @return the course
	 */
	public final Course getCourse()
	{
		return course;
	}

	/**
	 * @param course
	 *            the course to set
	 */
	public final void setCourse(final Course course)
	{
		this.course = course;
	}

	/**
	 * @return the ratings
	 */
	public final List<CourseRating> getRatings()
	{
		return ratings;
	}

	/**
	 * @param ratings
	 *            the ratings to set
	 */
	public final void setRatings(final List<CourseRating> ratings)
	{
		this.ratings = ratings;
	}

	/**
	 * @return the date
	 */
	public final Date getDate()
	{
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public final void setDate(final Date date)
	{
		this.date = date;
	}

}

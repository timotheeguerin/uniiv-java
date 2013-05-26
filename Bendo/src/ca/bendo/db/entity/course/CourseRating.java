/**
 * 
 */
package ca.bendo.db.entity.course;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>CourseRating</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "course_rating")
public class CourseRating
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_course_rating")
	private long id;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_course_rating_type")
	private CourseRatingType type;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_course_review")
	private CourseReview review;

	/**
	 * 
	 */
	@Column(name = "value")
	private int value;

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
	 * @return the type
	 */
	public final CourseRatingType getType()
	{
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public final void setType(final CourseRatingType type)
	{
		this.type = type;
	}

	/**
	 * @return the review
	 */
	public final CourseReview getReview()
	{
		return review;
	}

	/**
	 * @param review
	 *            the review to set
	 */
	public final void setReview(final CourseReview review)
	{
		this.review = review;
	}

	/**
	 * @return the value
	 */
	public final int getValue()
	{
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public final void setValue(final int value)
	{
		this.value = value;
	}

}

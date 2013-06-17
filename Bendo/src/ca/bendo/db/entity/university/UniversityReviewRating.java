/**
 * 
 */
package ca.bendo.db.entity.university;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ca.bendo.db.entity.rating.UniversityRating;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UniversityReviewRating</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "uni_review_rating")
public class UniversityReviewRating
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_uni_review_rating")
	private long id;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_uni_rating")
	private UniversityRating type;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_uni_review")
	private UniversityReview review;

	/**
	 * 
	 */
	@Column(name = "value")
	private int value;

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
	 * @return the type
	 */
	public UniversityRating getType()
	{
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(final UniversityRating type)
	{
		this.type = type;
	}

	/**
	 * @return the review
	 */
	public UniversityReview getReview()
	{
		return review;
	}

	/**
	 * @param review
	 *            the review to set
	 */
	public void setReview(final UniversityReview review)
	{
		this.review = review;
	}

	/**
	 * @return the value
	 */
	public int getValue()
	{
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(final int value)
	{
		this.value = value;
	}

}

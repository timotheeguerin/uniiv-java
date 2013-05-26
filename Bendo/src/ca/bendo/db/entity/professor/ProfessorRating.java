/**
 * 
 */
package ca.bendo.db.entity.professor;

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
 *          <b>ProfessorRating</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "professor_rating")
public class ProfessorRating
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_professor_rating")
	private long id;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_professor_rating_type")
	private ProfessorRatingType type;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_professor_review")
	private ProfessorReview review;

	/**
	 * 
	 */
	@Column(name = "value")
	private double value;

	

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
	public final ProfessorRatingType getType()
	{
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public final void setType(final ProfessorRatingType type)
	{
		this.type = type;
	}

	/**
	 * @return the review
	 */
	public final ProfessorReview getReview()
	{
		return review;
	}

	/**
	 * @param review
	 *            the review to set
	 */
	public final void setReview(final ProfessorReview review)
	{
		this.review = review;
	}

	/**
	 * @return the value
	 */
	public final double getValue()
	{
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public final void setValue(final double value)
	{
		this.value = value;
	}
}

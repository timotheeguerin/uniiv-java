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
	public ProfessorRatingType getType()
	{
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(final ProfessorRatingType type)
	{
		this.type = type;
	}

	/**
	 * @return the review
	 */
	public ProfessorReview getReview()
	{
		return review;
	}

	/**
	 * @param review
	 *            the review to set
	 */
	public void setReview(final ProfessorReview review)
	{
		this.review = review;
	}

	/**
	 * @return the value
	 */
	public double getValue()
	{
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(final double value)
	{
		this.value = value;
	}
}

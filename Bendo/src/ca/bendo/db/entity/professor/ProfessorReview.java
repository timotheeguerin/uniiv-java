/**
 * 
 */
package ca.bendo.db.entity.professor;

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
 *          <b>ProfessorReview</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "professor_review")
public class ProfessorReview
{
	/**
	 * 
	 */
	private static final double ONE_DECIMAL = 10;

	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_professor_review")
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
	@JoinColumn(name = "id_professor")
	private Professor professor;

	/**
	 * 
	 */
	@OneToMany(mappedBy = "review", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<ProfessorRating> ratings;

	/***
	 * 
	 */
	@Column(name = "date")
	private Date date;

	/**
	 * 
	 * @param t
	 *            type of the rating to get
	 * @return return the rating with the given type
	 */
	public double getRating(final String t)
	{
		for (ProfessorRating rating : ratings)
		{
			if (t.equalsIgnoreCase(rating.getType().getName()))
			{
				return roundOneDecimal(rating.getValue());
			}
		}
		return 1D;
	}

	/**
	 * 
	 * @return return the average rating with the given type
	 */
	public double getAverage()
	{
		double sum = 0;

		for (ProfessorRating rating : ratings)
		{

			sum += rating.getValue();

		}
		if (ratings.size() > 0)
		{
			return roundOneDecimal(sum / ratings.size());
		} else
		{
			return 1D;
		}
	}

	/**
	 * 
	 * @param d
	 *            double to round
	 * @return the given double rounded with one decimal
	 */
	private double roundOneDecimal(final double d)
	{

		long tmp = Math.round(d * ONE_DECIMAL);
		return (double) tmp / ONE_DECIMAL;
	}

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
	 * @return the comment
	 */
	public Comment getComment()
	{
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(final Comment comment)
	{
		this.comment = comment;
	}

	/**
	 * @return the professor
	 */
	public Professor getProfessor()
	{
		return professor;
	}

	/**
	 * @param professor
	 *            the professor to set
	 */
	public void setProfessor(final Professor professor)
	{
		this.professor = professor;
	}

	/**
	 * @return the ratings
	 */
	public List<ProfessorRating> getRatings()
	{
		return ratings;
	}

	/**
	 * @param ratings
	 *            the ratings to set
	 */
	public void setRatings(final List<ProfessorRating> ratings)
	{
		this.ratings = ratings;
	}

	/**
	 * @return the date
	 */
	public Date getDate()
	{
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(final Date date)
	{
		this.date = date;
	}

}

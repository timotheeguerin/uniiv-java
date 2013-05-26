/**
 * 
 */
package ca.bendo.db.entity.university;

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
 *          <b>UniversityReview</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "uni_review")
public class UniversityReview
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
	@Column(name = "id_uni_review", nullable = false, unique = true)
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
	@JoinColumn(name = "id_uni_university")
	private University university;

	/**
	 * 
	 */
	@OneToMany(mappedBy = "review", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<UniversityReviewRating> ratings;

	/**
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
		for (UniversityReviewRating rating : ratings)
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

		for (UniversityReviewRating rating : ratings)
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
	 * @return the university
	 */
	public final University getUniversity()
	{
		return university;
	}

	/**
	 * @param university
	 *            the university to set
	 */
	public final void setUniversity(final University university)
	{
		this.university = university;
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
	 * @return the ratings
	 */
	public final List<UniversityReviewRating> getRatings()
	{
		return ratings;
	}

	/**
	 * @param ratings
	 *            the ratings to set
	 */
	public final void setRatings(final List<UniversityReviewRating> ratings)
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

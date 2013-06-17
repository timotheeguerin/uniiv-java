/**
 * 
 */
package ca.bendo.db.entity.rating;

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
 *          <b>UniversityRating</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "uni_university_rating")
public class UniversityGrade
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_uni_university_rating", unique = true, nullable = false)
	private long id;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_rating")
	private UniversityRating softRating;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_uni_university")
	private University university;

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
	 * @return the softRating
	 */
	public UniversityRating getSoftRating()
	{
		return softRating;
	}

	/**
	 * @param softRating
	 *            the softRating to set
	 */
	public void setSoftRating(final UniversityRating softRating)
	{
		this.softRating = softRating;
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

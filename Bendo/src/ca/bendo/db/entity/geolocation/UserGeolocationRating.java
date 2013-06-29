/**
 * 
 */
package ca.bendo.db.entity.geolocation;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.persistence.Entity;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UserGeolocationRating</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "user_geolocation_rating")
public class UserGeolocationRating
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_user_geolocation_rating")
	private long id;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_user_geolocation_review")
	private UserGeolocationReview review;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_geolocation_rating_criteria")
	private GeolocationRatingCriteria criteria;

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
	 * @return the review
	 */
	public UserGeolocationReview getReview()
	{
		return review;
	}

	/**
	 * @param review
	 *            the review to set
	 */
	public void setReview(final UserGeolocationReview review)
	{
		this.review = review;
	}

	/**
	 * @return the criteria
	 */
	public GeolocationRatingCriteria getCriteria()
	{
		return criteria;
	}

	/**
	 * @param criteria
	 *            the criteria to set
	 */
	public void setCriteria(final GeolocationRatingCriteria criteria)
	{
		this.criteria = criteria;
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

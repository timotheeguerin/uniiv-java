/**
 * 
 */
package ca.bendo.db.entity.geolocation;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import ca.bendo.db.entity.user.User;

import com.vividsolutions.jts.geom.Point;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UserGeoLocationReview</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "user_geolocation_review")
public class UserGeolocationReview
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_user_geolocation_review")
	private long id;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;

	/**
	 * 
	 */
	@Column(name = "id_uni_university")
	private long universityId;
	/**
	 * 
	 */
	@Type(type = "org.hibernate.spatial.GeometryType")
	@Column(name = "location", columnDefinition = "Geometry")
	private Point location;

	/**
	 * 
	 */
	@OneToMany(mappedBy = "review")
	private Set<UserGeolocationRating> ratings = new HashSet<UserGeolocationRating>();

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
	 * @return the user
	 */
	public User getUser()
	{
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(final User user)
	{
		this.user = user;
	}

	/**
	 * @return the location
	 */
	public Point getLocation()
	{
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(final Point location)
	{
		this.location = location;
	}

	/**
	 * @return the ratings
	 */
	public Set<UserGeolocationRating> getRatings()
	{
		return ratings;
	}

	/**
	 * @param ratings
	 *            the ratings to set
	 */
	public void setRatings(final Set<UserGeolocationRating> ratings)
	{
		this.ratings = ratings;
	}

	/**
	 * @return the universityId
	 */
	public long getUniversityId()
	{
		return universityId;
	}

	/**
	 * @param universityId
	 *            the universityId to set
	 */
	public void setUniversityId(final long universityId)
	{
		this.universityId = universityId;
	}

}

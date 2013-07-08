/**
 * 
 */
package ca.bendo.db.entity.user;

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
 *          <b>UserEmail</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "user_email")
public class UserEmail
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_user_email")
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
	@Column(name = "email")
	private String email;

	/**
	 * 
	 */
	@Column(name = "validated")
	private boolean validated;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_uni_university")
	private University university;

	/**
	 * 
	 */
	@Column(name = "default")
	private boolean defaultEmail;

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
	 * @return the email
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(final String email)
	{
		this.email = email;
	}

	/**
	 * @return the validated
	 */
	public boolean isValidated()
	{
		return validated;
	}

	/**
	 * @param validated
	 *            the validated to set
	 */
	public void setValidated(final boolean validated)
	{
		this.validated = validated;
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
	 * @return the defaultEmail
	 */
	public boolean isDefaultEmail()
	{
		return defaultEmail;
	}

	/**
	 * @param defaultEmail
	 *            the defaultEmail to set
	 */
	public void setDefaultEmail(final boolean defaultEmail)
	{
		this.defaultEmail = defaultEmail;
	}

}

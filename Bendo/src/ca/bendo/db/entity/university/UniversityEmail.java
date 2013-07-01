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


/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UniversityEmail</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "university_email")
public class UniversityEmail
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_university_email", nullable = false, unique = true)
	private long id;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_uni_university")
	private University university;

	/**
	 * 
	 */
	@Column(name = "email_domain")
	private String emailDomain;

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
	 * @return the emailDomain
	 */
	public String getEmailDomain()
	{
		return emailDomain;
	}

	/**
	 * @param emailDomain
	 *            the emailDomain to set
	 */
	public void setEmailDomain(final String emailDomain)
	{
		this.emailDomain = emailDomain;
	}

}

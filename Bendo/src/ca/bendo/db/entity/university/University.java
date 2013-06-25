/**
 * 
 */
package ca.bendo.db.entity.university;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import ca.bendo.db.entity.location.Location;
import ca.bendo.db.entity.program.Program;
import ca.bendo.db.entity.rating.UniversityGrade;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>University</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "uni_university")
public class University
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_uni_university")
	private long id;

	/**
	 * 
	 */
	@Column(name = "key")
	private String key;

	/**
	 * 
	 */
	@Column(name = "name")
	private String name;

	/**
	 * 
	 */
	@Column(name = "website")
	private String website;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_uni_location")
	private Location location;

	/**
	 * 
	 */
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinTable(name = "uni_university_program", joinColumns = { @JoinColumn(name = "id_uni_university") },
			inverseJoinColumns = { @JoinColumn(name = "id_uni_program") })
	private List<Program> programs;
	/**
	 * 
	 */
	@OneToMany(mappedBy = "university", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(FetchMode.JOIN)
	private List<UniversityGrade> softRatings;

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
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(final String name)
	{
		this.name = name;
	}

	/**
	 * @return the website
	 */
	public String getWebsite()
	{
		return website;
	}

	/**
	 * @param website
	 *            the website to set
	 */
	public void setWebsite(final String website)
	{
		this.website = website;
	}

	/**
	 * @return the location
	 */
	public Location getLocation()
	{
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(final Location location)
	{
		this.location = location;
	}

	/**
	 * @return the softRatings
	 */
	public List<UniversityGrade> getSoftRatings()
	{
		return softRatings;
	}

	/**
	 * @param softRatings
	 *            the softRatings to set
	 */
	public void setSoftRatings(final List<UniversityGrade> softRatings)
	{
		this.softRatings = softRatings;
	}

	/**
	 * @return the key
	 */
	public String getKey()
	{
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(final String key)
	{
		this.key = key;
	}

}

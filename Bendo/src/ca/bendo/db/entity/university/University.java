/**
 * 
 */
package ca.bendo.db.entity.university;

import java.util.List;
import java.util.SortedSet;

import javax.persistence.CascadeType;
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
import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortType;

import ca.bendo.db.entity.fees.UniversityFees;
import ca.bendo.db.entity.location.Location;
import ca.bendo.db.entity.program.UniversityPrograms;
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
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_uni_fees")
	private UniversityFees fees;

	/**
	 * 
	 */
	@OneToMany(mappedBy = "university", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@Sort(type = SortType.COMPARATOR, comparator = UniversityPrograms.UniversityProgramsComparator.class)
	private SortedSet<UniversityPrograms> programs;

	/**
	 * 
	 */
	@OneToMany(mappedBy = "university", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	private List<UniversityGrade> softRatings;

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
	 * @return the name
	 */
	public final String getName()
	{
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public final void setName(final String name)
	{
		this.name = name;
	}

	/**
	 * @return the website
	 */
	public final String getWebsite()
	{
		return website;
	}

	/**
	 * @param website
	 *            the website to set
	 */
	public final void setWebsite(final String website)
	{
		this.website = website;
	}

	/**
	 * @return the location
	 */
	public final Location getLocation()
	{
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public final void setLocation(final Location location)
	{
		this.location = location;
	}

	/**
	 * @return the fees
	 */
	public final UniversityFees getFees()
	{
		return fees;
	}

	/**
	 * @param fees
	 *            the fees to set
	 */
	public final void setFees(final UniversityFees fees)
	{
		this.fees = fees;
	}

	/**
	 * @return the key
	 */
	public final String getKey()
	{
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public final void setKey(final String key)
	{
		this.key = key;
	}

	/**
	 * @return the programs
	 */
	public final SortedSet<UniversityPrograms> getPrograms()
	{
		return programs;
	}

	/**
	 * @param programs
	 *            the programs to set
	 */
	public final void setPrograms(final SortedSet<UniversityPrograms> programs)
	{
		this.programs = programs;
	}

	/**
	 * @return the softRatings
	 */
	public final List<UniversityGrade> getSoftRatings()
	{
		return softRatings;
	}

	/**
	 * @param softRatings
	 *            the softRatings to set
	 */
	public final void setSoftRatings(final List<UniversityGrade> softRatings)
	{
		this.softRatings = softRatings;
	}

}

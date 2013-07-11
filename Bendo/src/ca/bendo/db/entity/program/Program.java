/**
 * 
 */
package ca.bendo.db.entity.program;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

import ca.bendo.db.entity.lang.Translation;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UniProgram</b>
 *          <p>
 *          </p>
 * 
 * 
 */

@Entity
@Table(name = "uni_program")
public class Program implements Comparable<Program>
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_uni_program", unique = true, nullable = false)
	private long id;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_uni_faculty")
	private UniversityFaculty faculty;
	/**
	 * 
	 */
	@Column(name = "name")
	private String name;

	/**
	 * 
	 */

	@Formula(Translation.FORMULA)
	private String translation;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return getTranslation();
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
	 * @return the translation
	 */
	public String getTranslation()
	{
		if (translation != null)
		{
			return translation;
		} else
		{
			return name;
		}

	}

	/**
	 * @param translation
	 *            the translation to set
	 */
	public void setTranslation(final String translation)
	{
		this.translation = translation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(final Program o)
	{
		if (getTranslation() == null)
		{
			return -1;
		} else if (o.getTranslation() == null)
		{
			return 1;
		}

		return getTranslation().compareTo(o.getTranslation());
	}
}

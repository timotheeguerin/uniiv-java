/**
 * 
 */
package ca.bendo.db.entity.program;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UniversityFaculty</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "uni_faculty")
public class UniversityFaculty
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_uni_faculty")
	private long id;

	/**
	 * 
	 */
	@Column(name = "name")
	private String name;

	/**
	 * 
	 */
	@OneToMany(mappedBy = "faculty")
	private List<UniversityProgram> programs = new ArrayList<UniversityProgram>();

	/**
	 * 
	 */
	@Formula("(SELECT t.translation FROM lang_translation t "
			+ "WHERE (t.key = name) AND t.id_lang_language = :languageId.param)")
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

	/**
	 * @return the programs
	 */
	public List<UniversityProgram> getPrograms()
	{
		return programs;
	}

	/**
	 * @param programs
	 *            the programs to set
	 */
	public void setPrograms(final List<UniversityProgram> programs)
	{
		this.programs = programs;
	}

	/**
	 * @param program
	 *            add the given program to the list of programs
	 */
	public void addProgram(final UniversityProgram program)
	{
		programs.add(program);
	}

	/**
	 * @return if there are programs
	 */
	public boolean hasPrograms()
	{
		return !programs.isEmpty();
	}

}

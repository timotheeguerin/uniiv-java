/**
 * 
 */
package ca.bendo.db.entity.course;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ca.bendo.db.entity.program.UniversityProgram;
import ca.bendo.db.entity.university.University;

/**
 * @author Timoth�e Gu�rin
 * @version Bendo
 * 
 *          <b>Course</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "course")
public class Course
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_course")
	private long id;

	/**
	 * 
	 */
	@Column(name = "name")
	private String name;

	/**
	 * 
	 */
	@Column(name = "code")
	private String code;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_uni_university")
	private University university;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_uni_program")
	private UniversityProgram program;

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
	 * @return the code
	 */
	public final String getCode()
	{
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public final void setCode(final String code)
	{
		this.code = code;
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
	 * @return the program
	 */
	public final UniversityProgram getProgram()
	{
		return program;
	}

	/**
	 * @param program
	 *            the program to set
	 */
	public final void setProgram(final UniversityProgram program)
	{
		this.program = program;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return code + " " + name;
	}
}

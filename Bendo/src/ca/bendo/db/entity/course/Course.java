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

import ca.bendo.db.entity.program.Program;
import ca.bendo.db.entity.university.University;

/**
 * @author Timothée Guérin
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
	private Program program;

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
	 * @return the code
	 */
	public String getCode()
	{
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(final String code)
	{
		this.code = code;
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
	 * @return the program
	 */
	public Program getProgram()
	{
		return program;
	}

	/**
	 * @param program
	 *            the program to set
	 */
	public void setProgram(final Program program)
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

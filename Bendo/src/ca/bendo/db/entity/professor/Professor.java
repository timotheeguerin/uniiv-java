/**
 * 
 */
package ca.bendo.db.entity.professor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ca.bendo.db.entity.program.UniversityProgram;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>Professor</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "professor")
public class Professor
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_professor")
	private long id;

	/**
	 * 
	 */
	@Column(name = "first_name")
	private String firstName;

	/**
	 * 
	 */
	@Column(name = "last_name")
	private String lastName;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_uni_program")
	private UniversityProgram program;

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
	 * @return the firstName
	 */
	public String getFirstName()
	{
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(final String firstName)
	{
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName()
	{
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(final String lastName)
	{
		this.lastName = lastName;
	}

	/**
	 * @return the program
	 */
	public UniversityProgram getProgram()
	{
		return program;
	}

	/**
	 * @param program
	 *            the program to set
	 */
	public void setProgram(final UniversityProgram program)
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
		return firstName + " " + lastName;
	}

}

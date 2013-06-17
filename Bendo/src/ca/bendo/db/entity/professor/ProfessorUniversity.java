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

import ca.bendo.db.entity.university.University;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ProfessorUniveristy</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "uni_professor")
public class ProfessorUniversity
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_uni_professor", nullable = false, unique = true)
	private long id;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_uni_university", nullable = false)
	private University university;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_professor", nullable = false)
	private Professor professor;

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
	 * @return the professor
	 */
	public Professor getProfessor()
	{
		return professor;
	}

	/**
	 * @param professor
	 *            the professor to set
	 */
	public void setProfessor(final Professor professor)
	{
		this.professor = professor;
	}

}

/**
 * 
 */
package ca.bendo.db.entity.course;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import ca.bendo.db.entity.professor.Professor;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ProfessorCourse</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "course_professor")
public class CourseProfessor
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_course_professor", unique = true, nullable = false)
	private long id;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_professor")
	private Professor professor;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_course")
	private Course course;
	/**
	 * 
	 */

	@OneToMany(mappedBy = "courseProfessor", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	private List<CourseProfessorPeriod> periods = new ArrayList<CourseProfessorPeriod>();

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
	 * @return the professor
	 */
	public final Professor getProfessor()
	{
		return professor;
	}

	/**
	 * @param professor
	 *            the professor to set
	 */
	public final void setProfessor(final Professor professor)
	{
		this.professor = professor;
	}

	/**
	 * @return the course
	 */
	public final Course getCourse()
	{
		return course;
	}

	/**
	 * @param course
	 *            the course to set
	 */
	public final void setCourse(final Course course)
	{
		this.course = course;
	}

	/**
	 * @return the periods
	 */
	public final List<CourseProfessorPeriod> getPeriods()
	{
		return periods;
	}

	/**
	 * @param periods
	 *            the periods to set
	 */
	public final void setPeriods(final List<CourseProfessorPeriod> periods)
	{
		this.periods = periods;
	}

}

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

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>CourseProfessorPeriod</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "course_professor_period")
public class CourseProfessorPeriod
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_course_professor_period")
	private long id;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_semester")
	private Semester semester;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_course_professor")
	private CourseProfessor courseProfessor;

	/**
	 * 
	 */
	@Column(name = "year")
	private int year;

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
	 * @return the semester
	 */
	public final Semester getSemester()
	{
		return semester;
	}

	/**
	 * @param semester
	 *            the semester to set
	 */
	public final void setSemester(final Semester semester)
	{
		this.semester = semester;
	}

	/**
	 * @return the year
	 */
	public final int getYear()
	{
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public final void setYear(final int year)
	{
		this.year = year;
	}

	/**
	 * @return the courseProfessor
	 */
	public final CourseProfessor getCourseProfessor()
	{
		return courseProfessor;
	}

	/**
	 * @param courseProfessor
	 *            the courseProfessor to set
	 */
	public final void setCourseProfessor(final CourseProfessor courseProfessor)
	{
		this.courseProfessor = courseProfessor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return semester + " " + year;
	}

}

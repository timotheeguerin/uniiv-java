/**
 * 
 */
package ca.bendo.form.entity.course;

import ca.bendo.annotation.Input;
import ca.bendo.form.entity.Entity;
import ca.bendo.form.entity.EntityType;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>NewProfessorUniversityEntity</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class NewCourseProfessorEntity extends Entity
{
	/**
	 * 
	 */
	@Input(name = "professorId", type = EntityType.NUMERIC)
	private String professorId;

	/**
	 * 
	 */
	@Input(name = "semesterId", type = EntityType.NUMERIC)
	private String semesterId;

	/**
	 * 
	 */
	@Input(name = "year", type = EntityType.NUMERIC)
	private String year;

	/**
	 * @return the professorId
	 */
	public final String getProfessorId()
	{
		return professorId;
	}

	/**
	 * @param professorId
	 *            the professorId to set
	 */
	public final void setProfessorId(final String professorId)
	{
		this.professorId = professorId;
	}

	/**
	 * @return the semesterId
	 */
	public final String getSemesterId()
	{
		return semesterId;
	}

	/**
	 * @param semesterId
	 *            the semesterId to set
	 */
	public final void setSemesterId(final String semesterId)
	{
		this.semesterId = semesterId;
	}

	/**
	 * @return the year
	 */
	public final String getYear()
	{
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public final void setYear(final String year)
	{
		this.year = year;
	}

}

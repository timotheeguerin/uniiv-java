/**
 * 
 */
package ca.bendo.form.entity.professor;

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
public class NewProfessorUniversityEntity extends Entity
{
	/**
	 * 
	 */
	@Input(name = "universityId", type = EntityType.NUMERIC)
	private String universityId;

	/**
	 * @return the universityId
	 */
	public String getUniversityId()
	{
		return universityId;
	}

	/**
	 * @param universityId
	 *            the universityId to set
	 */
	public void setUniversityId(final String universityId)
	{
		this.universityId = universityId;
	}

}

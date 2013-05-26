/**
 * 
 */
package ca.bendo.form.entity.course;

import ca.bendo.annotation.Input;
import ca.bendo.form.entity.Entity;
import ca.bendo.form.entity.EntityType;

/**
 * @author Timoth�e Gu�rin
 * @version Bendo
 * 
 *          <b>NewProfessorReviewEntity</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class NewCourseReviewEntity extends Entity
{

	/**
	 * 
	 */
	@Input(name = "languageId", type = EntityType.NUMERIC)
	private String languageId;
	/**
	 * 
	 */
	@Input(name = "languageId", type = EntityType.COMMENT)
	private String comment;

	/**
	 * @return the languageId
	 */
	public final String getLanguageId()
	{
		return languageId;
	}

	/**
	 * @param languageId
	 *            the languageId to set
	 */
	public final void setLanguageId(final String languageId)
	{
		this.languageId = languageId;
	}

	/**
	 * @return the comment
	 */
	public final String getComment()
	{
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public final void setComment(final String comment)
	{
		this.comment = comment;
	}

}

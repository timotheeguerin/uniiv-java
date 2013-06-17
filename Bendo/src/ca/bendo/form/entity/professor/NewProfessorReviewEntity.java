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
 *          <b>NewProfessorReviewEntity</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class NewProfessorReviewEntity extends Entity
{

	/**
	 * 
	 */
	@Input(name = "languageId", type = EntityType.NUMERIC)
	private String languageId;
	/**
	 * 
	 */
	@Input(name = "comment", type = EntityType.COMMENT)
	private String comment;

	/**
	 * @return the languageId
	 */
	public String getLanguageId()
	{
		return languageId;
	}

	/**
	 * @param languageId
	 *            the languageId to set
	 */
	public void setLanguageId(final String languageId)
	{
		this.languageId = languageId;
	}

	/**
	 * @return the comment
	 */
	public String getComment()
	{
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(final String comment)
	{
		this.comment = comment;
	}

}

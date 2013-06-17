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
 *          <b>NewCourseEntity</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class NewCourseEntity extends Entity
{
	/**
	 * 
	 */
	@Input(name = "course_name", type = EntityType.ALPHANUMERIC)
	private String courseName;

	/**
	 * 
	 */
	@Input(name = "course_code", type = EntityType.CODE)
	private String courseCode;

	/**
	 * 
	 */
	@Input(name = "programId", type = EntityType.NUMERIC)
	private String programId;

	/**
	 * 
	 */
	@Input(name = "recaptcha", type = EntityType.CAPTCHA)
	private String captcha;

	/**
	 * @return the courseName
	 */
	public String getCourseName()
	{
		return courseName;
	}

	/**
	 * @param courseName
	 *            the courseName to set
	 */
	public void setCourseName(final String courseName)
	{
		this.courseName = courseName;
	}

	/**
	 * @return the courseCode
	 */
	public String getCourseCode()
	{
		return courseCode;
	}

	/**
	 * @param courseCode
	 *            the courseCode to set
	 */
	public void setCourseCode(final String courseCode)
	{
		this.courseCode = courseCode;
	}

	/**
	 * @return the programId
	 */
	public String getProgramId()
	{
		return programId;
	}

	/**
	 * @param programId
	 *            the programId to set
	 */
	public void setProgramId(final String programId)
	{
		this.programId = programId;
	}

	/**
	 * @return the captcha
	 */
	public String getCaptcha()
	{
		return captcha;
	}

	/**
	 * @param captcha
	 *            the captcha to set
	 */
	public void setCaptcha(final String captcha)
	{
		this.captcha = captcha;
	}

}

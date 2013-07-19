/**
 * 
 */
package ca.bendo.db.entity.course;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import ca.bendo.db.entity.course.logical.CourseExpression;

/**
 * @author Timothée Guérin
 * @version Uniiv
 * 
 *          <b>CourseRequirements</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Embeddable
public class CourseRequirements
{
	@ManyToOne
	@JoinColumn(name = "prerequisite", nullable = true)
	private CourseExpression prerequisite;

	@ManyToOne
	@JoinColumn(name = "corequisite", nullable = true)
	private CourseExpression corequisite;

	@ManyToMany(cascade = { CascadeType.ALL })
	@Fetch(FetchMode.SELECT)
	@JoinTable(name = "course_restrictions", joinColumns = { @JoinColumn(name = "id_course") },
			inverseJoinColumns = { @JoinColumn(name = "id_course_restriction") })
	private List<Course> restrictions;

	/**
	 * @return the prerequisite
	 */
	public CourseExpression getPrerequisite()
	{
		return prerequisite;
	}

	/**
	 * @param prerequisite the prerequisite to set
	 */
	public void setPrerequisite(final CourseExpression prerequisite)
	{
		this.prerequisite = prerequisite;
	}

	/**
	 * @return the corequisite
	 */
	public CourseExpression getCorequisite()
	{
		return corequisite;
	}

	/**
	 * @param corequisite the corequisite to set
	 */
	public void setCorequisite(final CourseExpression corequisite)
	{
		this.corequisite = corequisite;
	}

	/**
	 * @return the restrictions
	 */
	public List<Course> getRestrictions()
	{
		return restrictions;
	}

	/**
	 * @param restrictions the restrictions to set
	 */
	public void setRestrictions(final List<Course> restrictions)
	{
		this.restrictions = restrictions;
	}
	
	
	
}

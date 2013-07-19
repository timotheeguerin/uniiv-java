/**
 * 
 */
package ca.bendo.db.entity.course.logical;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ca.bendo.db.entity.course.Course;

/**
 * @author Timothée Guérin
 * @version Uniiv
 * 
 *          <b>CourseExpression</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "course_expr")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "node", discriminatorType = DiscriminatorType.INTEGER)
public class CourseExpression
{
	@Id
	@GeneratedValue
	@Column(name = "id_course_expr")
	private long id;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_parent")
	private CourseExpression parent;

	/**
	 * 
	 */
	@OneToMany(mappedBy = "parent")
	private List<CourseExpression> childs = new ArrayList<CourseExpression>();

	@Column(name = "operation")
	private OperationType operation;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_course")
	private Course course;

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
	 * @return the parent
	 */
	public CourseExpression getParent()
	{
		return parent;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(final CourseExpression parent)
	{
		this.parent = parent;
	}

	/**
	 * @return the childs
	 */
	public List<CourseExpression> getChilds()
	{
		return childs;
	}

	/**
	 * @param childs
	 *            the childs to set
	 */
	public void setChilds(final List<CourseExpression> childs)
	{
		this.childs = childs;
	}

	/**
	 * @return the operation
	 */
	public OperationType getOperation()
	{
		return operation;
	}

	/**
	 * @param operation
	 *            the operation to set
	 */
	public void setOperation(final OperationType operation)
	{
		this.operation = operation;
	}

	/**
	 * @return the course
	 */
	public Course getCourse()
	{
		return course;
	}

	/**
	 * @param course
	 *            the course to set
	 */
	public void setCourse(final Course course)
	{
		this.course = course;
	}

}

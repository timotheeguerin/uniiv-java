/**
 * 
 */
package ca.bendo.views.list;

import java.util.HashMap;
import java.util.Map;

import ca.bendo.db.entity.course.Course;
import ca.bendo.db.entity.course.CourseRatingAverage;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>CourseListElement</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class CourseListElement
{
	/**
	 * 
	 */
	private Course course;

	/**
	 * 
	 */
	private String link;

	/**
	 * 
	 */
	private Map<String, AdditionalColumn> columns = new HashMap<String, AdditionalColumn>();

	/**
	 * 
	 */
	private CourseRatingAverage ratings;

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
	 * @return the columns
	 */
	public final Map<String, AdditionalColumn> getColumns()
	{
		return columns;
	}

	/**
	 * @param addColumns
	 *            the columns to set
	 */
	public final void setColumns(final Map<String, AdditionalColumn> addColumns)
	{
		this.columns = addColumns;
	}

	/**
	 * @return the link
	 */
	public String getLink()
	{
		return link;
	}

	/**
	 * @param link
	 *            the link to set
	 */
	public void setLink(final String link)
	{
		this.link = link;
	}

	/**
	 * @return the ratings
	 */
	public final CourseRatingAverage getRatings()
	{
		return ratings;
	}

	/**
	 * @param ratings
	 *            the ratings to set
	 */
	public final void setRatings(final CourseRatingAverage ratings)
	{
		this.ratings = ratings;
	}

}

/**
 * 
 */
package ca.bendo.views.table.course;

import java.util.List;

import ca.bendo.db.entity.course.Course;
import ca.bendo.db.entity.course.CourseRatingAverage;
import ca.bendo.db.entity.course.CourseRatingType;
import ca.bendo.views.table.TableCell;
import ca.bendo.views.table.TableRow;
import ca.bendo.views.table.TableTopCell;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>CourseTableRow</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class CourseTableRow extends TableRow
{
	/**
	 * 
	 */
	public CourseTableRow()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param course
	 *            Course
	 * @param ratings
	 *            Ratings
	 * @param types
	 *            Rating types
	 */
	public void setup(final Course course, final CourseRatingAverage ratings, final List<CourseRatingType> types)
	{

		for (CourseRatingType type : types)
		{
			TableTopCell ratingHeaderCell = getTable().getHeader().get(type.toString());
			TableCell cell = new TableCell(ratings.getRating(type.getName()));
			this.add(ratingHeaderCell, cell);
		}
		this.add(getTable().getHeader().get("rating"), new TableCell(ratings.getAverage()));
		this.add(getTable().getHeader().get("name"), new TableCell(course.getName()));
		this.add(getTable().getHeader().get("code"), new TableCell(course.getCode()));
		this.add(getTable().getHeader().get("departement"), new TableCell(course.getProgram()));
	}
}

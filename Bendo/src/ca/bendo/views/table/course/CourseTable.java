/**
 * 
 */
package ca.bendo.views.table.course;

import java.util.List;

import ca.bendo.db.entity.course.CourseRatingType;
import ca.bendo.views.table.CellSize;
import ca.bendo.views.table.Table;
import ca.bendo.views.table.TableTopCell;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>CourseTable</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class CourseTable extends Table
{
	/**
	 * 
	 * @param types
	 *            ratings types
	 */
	public CourseTable(final List<CourseRatingType> types)
	{

		// Setup header row
		TableTopCell code = new TableTopCell("code", CellSize.SMALL);
		this.getHeader().add(code);
		TableTopCell name = new TableTopCell("name", CellSize.LARGE);
		this.getHeader().add(name);
		TableTopCell department = new TableTopCell("departement");
		this.getHeader().add(department);
		TableTopCell ovrealRating = new TableTopCell("rating", CellSize.SMALL);
		this.getHeader().add(ovrealRating);
		for (CourseRatingType type : types)
		{
			TableTopCell ratingCell = new TableTopCell(type.toString(), CellSize.SMALL);
			this.getHeader().add(ratingCell);
		}
	}

}

/**
 * 
 */
package ca.bendo.views.table.professor;

import java.util.List;

import ca.bendo.db.entity.professor.Professor;
import ca.bendo.db.entity.professor.ProfessorRatingAverage;
import ca.bendo.db.entity.professor.ProfessorRatingType;
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
public class ProfessorTableRow extends TableRow
{
	/**
	 * 
	 */
	public ProfessorTableRow()
	{

	}

	/**
	 * @param professor
	 *            Professor
	 * @param ratings
	 *            Ratings
	 * @param types
	 *            Rating types
	 */
	public void setup(final Professor professor, final ProfessorRatingAverage ratings,
			final List<ProfessorRatingType> types)
	{

		for (ProfessorRatingType type : types)
		{
			TableTopCell ratingHeaderCell = getTable().getHeader().get(type.toString());
			TableCell cell = new TableCell(ratings.getRating(type.getName()));
			this.add(ratingHeaderCell, cell);
		}
		this.add(getTable().getHeader().get("rating"), new TableCell(ratings.getAverage()));
		this.add(getTable().getHeader().get("name"), new TableCell(professor));
		this.add(getTable().getHeader().get("departement"), new TableCell(professor.getProgram()));
	}
}

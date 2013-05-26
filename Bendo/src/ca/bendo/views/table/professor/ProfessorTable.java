/**
 * 
 */
package ca.bendo.views.table.professor;

import java.util.List;

import ca.bendo.db.entity.professor.ProfessorRatingType;
import ca.bendo.views.table.CellSize;
import ca.bendo.views.table.Table;
import ca.bendo.views.table.TableTopCell;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>Professor</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class ProfessorTable extends Table
{

	/**
	 * 
	 * @param types
	 *            ratings types
	 */
	public ProfessorTable(final List<ProfessorRatingType> types)
	{

		// Setup header row
		TableTopCell name = new TableTopCell("name", CellSize.LARGE);
		this.getHeader().add(name);
		TableTopCell department = new TableTopCell("departement");
		this.getHeader().add(department);
		TableTopCell ovrealRating = new TableTopCell("rating", CellSize.SMALL);
		this.getHeader().add(ovrealRating);
		for (ProfessorRatingType type : types)
		{
			TableTopCell ratingCell = new TableTopCell(type.toString(), CellSize.SMALL);
			this.getHeader().add(ratingCell);
		}
	}
}

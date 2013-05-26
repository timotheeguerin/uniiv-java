/**
 * 
 */
package ca.bendo.views.table;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TableHeaderRow</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class TableHeaderRow
{
	/**
	 * 
	 */
	private List<TableTopCell> cells = new ArrayList<TableTopCell>();

	/**
	 * 
	 * @param top
	 *            Top cell to add
	 */
	public final void add(final TableTopCell top)
	{
		cells.add(top);
	}

	/**
	 * 
	 * @param value
	 *            Top cell value
	 * @return top cell with the given value
	 */
	public final TableTopCell get(final String value)
	{
		for (TableTopCell cell : cells)
		{
			if (ObjectUtils.equals(cell.getValue(), value))
			{
				return cell;
			}
		}
		return null;
	}

	/**
	 * @return the cells
	 */
	public final List<TableTopCell> getCells()
	{
		return cells;
	}

	/**
	 * @param cells
	 *            the cells to set
	 */
	public final void setCells(final List<TableTopCell> cells)
	{
		this.cells = cells;
	}
}

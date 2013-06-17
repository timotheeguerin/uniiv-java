/**
 * 
 */
package ca.bendo.views.table;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TableRow</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class TableRow
{
	/**
	 * 
	 */
	private Table table;

	/**
	 * 
	 */
	private String link;

	/**
	 * 
	 */
	private Map<TableTopCell, TableCell> cells = new HashMap<TableTopCell, TableCell>();

	/**
	 * 
	 */
	public TableRow()
	{
		// 
	}

	/**
	 * @param table
	 *            table
	 * @param link
	 *            Link
	 */
	public TableRow(final Table table, final String link)
	{
		setLink(link);
		setTable(table);
	}

	/**
	 * 
	 * @param top
	 *            Top cell
	 * @return the cell with the given top cell
	 */
	public TableCell getCell(final TableTopCell top)
	{
		return cells.get(top);
	}

	/**
	 * 
	 * @param cell
	 *            cell
	 * @return the header cell for the given cell
	 */
	public TableTopCell getHeader(final TableCell cell)
	{
		for (Entry<TableTopCell, TableCell> entry : cells.entrySet())
		{
			if (entry.getValue().equals(cell))
			{
				return entry.getKey();
			}
		}
		return null;
	}

	/**
	 * @return the cells
	 */
	public Map<TableTopCell, TableCell> getCells()
	{
		return cells;
	}

	/**
	 * @param cells
	 *            the cells to set
	 */
	public void setCells(final Map<TableTopCell, TableCell> cells)
	{
		this.cells = cells;
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
	 * @param headerCell
	 *            Header cell
	 * @param cell
	 *            Cell
	 */
	public void add(final TableTopCell headerCell, final TableCell cell)
	{
		cells.put(headerCell, cell);
	}

	/**
	 * @return the table
	 */
	public Table getTable()
	{
		return table;
	}

	/**
	 * @param table
	 *            the table to set
	 */
	public void setTable(final Table table)
	{
		this.table = table;
	}

}

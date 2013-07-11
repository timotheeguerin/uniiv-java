/**
 * 
 */
package ca.bendo.views.table;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>Table</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class Table
{

	/**
	 * 
	 */
	private TableHeaderRow header = new TableHeaderRow();
	/**
	 * 
	 */
	private List<TableRow> rows = new ArrayList<TableRow>();

	/**
	 * @param <T>
	 *            Classs type
	 * @param clazz
	 *            Class
	 * @param link
	 *            link of the row
	 * @return Table row
	 */
	public <T> TableRow createRow(final Class<T> clazz, final String link)
	{

		try
		{
			TableRow row = (TableRow) clazz.newInstance();
			row.setTable(this);
			row.setLink(link);
			addRow(row);
			return row;
		} catch (InstantiationException e)
		{
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{

			e.printStackTrace();
		}

		return null;
	}

	/**
	 * @return the header
	 */
	public TableHeaderRow getHeader()
	{
		return header;
	}

	/**
	 * @param header
	 *            the header to set
	 */
	public void setHeader(final TableHeaderRow header)
	{
		this.header = header;
	}

	/**
	 * @return the rows
	 */
	public List<TableRow> getRows()
	{
		return rows;
	}

	/**
	 * @param rows
	 *            the rows to set
	 */
	public void setRows(final List<TableRow> rows)
	{
		this.rows = rows;
	}

	/**
	 * @param row
	 *            row to add
	 */
	public void addRow(final TableRow row)
	{
		rows.add(row);
	}

}

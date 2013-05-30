/**
 * 
 */
package ca.bendo.views.table;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TableCell</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class TableCell
{
	/**
	 * 
	 */
	private Object value;

	/**
	 * 
	 */
	public TableCell()
	{
		// 
	}

	/**
	 * @param value
	 *            value to set
	 */
	public TableCell(final Object value)
	{
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public final Object getValue()
	{
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public final void setValue(final Object value)
	{
		this.value = value;
	}

}

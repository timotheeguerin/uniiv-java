/**
 * 
 */
package ca.bendo.views.list;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>AdditionalColumn</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class AdditionalColumn
{
	/**
	 * 
	 */
	private AdditionalColumnType type = AdditionalColumnType.TEXT;

	/**
	 * File if the value need a view to be display.
	 */
	private String file;

	/**
	 * 
	 */
	private Object value;

	/**
	 * @return the type
	 */
	public final AdditionalColumnType getType()
	{
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public final void setType(final AdditionalColumnType type)
	{
		this.type = type;
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

	/**
	 * @return the file
	 */
	public final String getFile()
	{
		return file;
	}

	/**
	 * @param file
	 *            the file to set
	 */
	public final void setFile(final String file)
	{
		this.file = file;
	}

}

/**
 * 
 */
package ca.bendo.views.table;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TableTopCell</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class TableTopCell extends TableCell
{
	/**
	 * 
	 */
	private CellType type;

	/**
	 * 
	 */
	private String file;

	/**
	 * 
	 */
	private CellSize size;

	/**
	 * 
	 */
	public TableTopCell()
	{
		setType(CellType.TEXT);
		setSize(CellSize.NORMAL);
	}

	/**
	 * @param value
	 *            value to set
	 */
	public TableTopCell(final String value)
	{
		this();
		setValue(value);

	}

	/**
	 * @param value
	 *            value to set
	 * @param size
	 *            size of the cell
	 */
	public TableTopCell(final String value, final CellSize size)
	{
		this();
		setValue(value);
		setSize(size);
	}

	/**
	 * @param value
	 *            value to set
	 * @param file
	 *            file to set
	 */
	public TableTopCell(final String value, final String file)
	{
		this(value);
		setType(CellType.VIEW);
		setFile(file);
	}

	/**
	 * @param value
	 *            value to set
	 * @param file
	 *            file to set
	 * @param size
	 *            size of the cell
	 */
	public TableTopCell(final String value, final String file, final CellSize size)
	{
		this(value, size);
		setType(CellType.VIEW);
		setFile(file);
	}

	/**
	 * @return the type
	 */
	public final CellType getType()
	{
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public final void setType(final CellType type)
	{
		this.type = type;
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

	/**
	 * @return the size
	 */
	public final CellSize getSize()
	{
		return size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public final void setSize(CellSize size)
	{
		this.size = size;
	}

}

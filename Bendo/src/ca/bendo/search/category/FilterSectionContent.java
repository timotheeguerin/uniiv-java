/**
 * 
 */
package ca.bendo.search.category;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>IFilterCategoryContent</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public abstract class FilterSectionContent
{
	/**
	 * Name of the jsp file displaying this category.
	 */
	private String filename;

	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	public FilterSectionContent()
	{
		init();
	}

	/**
	 * 
	 */
	protected abstract void init();

	/**
	 * @return the filename
	 */
	public String getFilename()
	{
		return filename;
	}

	/**
	 * @param filename
	 *            the filename to set
	 */
	public void setFilename(final String filename)
	{
		this.filename = filename;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(final String name)
	{
		this.name = name;
	}

}

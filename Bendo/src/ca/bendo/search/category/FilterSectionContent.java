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

}

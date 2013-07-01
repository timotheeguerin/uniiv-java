/**
 * 
 */
package ca.bendo.search.category;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>FilterCategory</b>
 *          <p>
 *          Class containg a filter category. The content is an abstract class.
 * 
 *          </p>
 * 
 * 
 */
public class FilterSection
{

	/**
	 * 
	 */
	private FilterSectionContent content;
	
	/**
	 * 
	 */
	private String name;

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

	/**
	 * @return the content
	 */
	public FilterSectionContent getContent()
	{
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(final FilterSectionContent content)
	{
		this.content = content;
	}

}

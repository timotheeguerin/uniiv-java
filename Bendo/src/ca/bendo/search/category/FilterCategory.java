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
public class FilterCategory
{

	/**
	 * 
	 */
	private FilterCategoryContent content;
	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	private String image;

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
	public FilterCategoryContent getContent()
	{
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(final FilterCategoryContent content)
	{
		this.content = content;
	}

	/**
	 * @return the image
	 */
	public String getImage()
	{
		return image;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(final String image)
	{
		this.image = image;
	}

}

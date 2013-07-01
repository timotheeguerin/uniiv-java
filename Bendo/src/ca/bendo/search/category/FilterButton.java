/**
 * 
 */
package ca.bendo.search.category;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>FilterButton</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class FilterButton
{
	/**
	 * 
	 */
	private long value;

	/**
	 * 
	 */
	private String image;

	/**
	 * 
	 */
	private String text;

	/**
	 * @return the value
	 */
	public long getValue()
	{
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(final long value)
	{
		this.value = value;
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

	/**
	 * @return the text
	 */
	public String getText()
	{
		return text;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(final String text)
	{
		this.text = text;
	}

}

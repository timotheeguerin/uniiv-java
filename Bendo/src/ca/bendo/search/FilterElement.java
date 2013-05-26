/**
 * 
 */
package ca.bendo.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>FilterElement</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class FilterElement
{
	/**
	 * 
	 */
	private static final int DEFAULT_LINE_LENGHT = 3;

	/**
	 * 
	 */
	private List<List<FilterElement>> subElements = new ArrayList<List<FilterElement>>();

	/**
	 * 
	 */
	private String customClass;

	/**
	 * 
	 */
	private int lineLenght = DEFAULT_LINE_LENGHT;

	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	private long id;

	/**
	 * 
	 */
	private String image;

	/**
	 * @param e
	 *            Filter element to add.
	 */
	public void addSubElement(final FilterElement e)
	{
		List<FilterElement> line = getFirstEmptyLine();
		if (line == null)
		{
			line = new ArrayList<FilterElement>();
			subElements.add(line);
		}
		line.add(e);
	}

	/**
	 * @return the first empty line(If there are no empty line return null)
	 */
	public List<FilterElement> getFirstEmptyLine()
	{
		for (List<FilterElement> line : subElements)
		{
			if (line.size() < lineLenght)
			{
				return line;
			}
		}
		return null;
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

	/**
	 * @return the subElement
	 */
	public List<List<FilterElement>> getSubElements()
	{
		return subElements;
	}

	/**
	 * @param subElements
	 *            the subElement to set
	 */
	public void setSubElements(final List<List<FilterElement>> subElements)
	{
		this.subElements = subElements;
	}

	/**
	 * @return the customClass
	 */
	public String getCustomClass()
	{
		return customClass;
	}

	/**
	 * @param customClass
	 *            the customClass to set
	 */
	public void setCustomClass(final String customClass)
	{
		this.customClass = customClass;
	}

	/**
	 * @return the ligneLenght
	 */
	public int getLineLenght()
	{
		return lineLenght;
	}

	/**
	 * @param ligneLenght
	 *            the ligneLenght to set
	 */
	public void setLineLenght(final int ligneLenght)
	{
		this.lineLenght = ligneLenght;
	}

	/**
	 * @return the id
	 */
	public long getId()
	{
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final long id)
	{
		this.id = id;
	}

	/**
	 * @return the image
	 */
	public final String getImage()
	{
		return image;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	public final void setImage(String image)
	{
		this.image = image;
	}

}

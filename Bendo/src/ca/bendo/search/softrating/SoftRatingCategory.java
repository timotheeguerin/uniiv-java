/**
 * 
 */
package ca.bendo.search.softrating;

import java.util.ArrayList;
import java.util.List;

import ca.bendo.db.entity.rating.UniversityRatingMethodElement;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>SoftRatingCategory</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class SoftRatingCategory
{
	/**
	 * 
	 */
	private int id;

	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	private List<UniversityRatingMethodElement> elements = new ArrayList<UniversityRatingMethodElement>();

	/**
	 * 
	 */
	public SoftRatingCategory()
	{

	}

	/**
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final int id)
	{
		this.id = id;
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
	 * 
	 * @param e
	 *            Add an element
	 */
	public void addElement(final UniversityRatingMethodElement e)
	{
		this.elements.add(e);
	}

	/**
	 * @return the elements
	 */
	public List<UniversityRatingMethodElement> getElements()
	{
		return elements;
	}

	/**
	 * @param elements
	 *            the elements to set
	 */
	public void setElements(final List<UniversityRatingMethodElement> elements)
	{
		this.elements = elements;
	}

}

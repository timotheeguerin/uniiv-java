/**
 * 
 */
package ca.bendo.search;

import java.util.ArrayList;
import java.util.List;

import ca.bendo.search.category.FilterSection;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>FilterSystem</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class FilterSystem
{
	/**
	 * 
	 */
	private List<FilterSection> categories = new ArrayList<FilterSection>();

	/**
	 * 
	 */
	private FilterSection softrating;

	/**
	 * 
	 * @param category
	 *            Category to add
	 */
	public void addCategory(final FilterSection category)
	{
		categories.add(category);
	}

	/**
	 * @return the categories
	 */
	public List<FilterSection> getCategories()
	{
		return categories;
	}

	/**
	 * @param categories
	 *            the categories to set
	 */
	public void setCategories(final List<FilterSection> categories)
	{
		this.categories = categories;
	}

	/**
	 * @return the softrating
	 */
	public FilterSection getSoftrating()
	{
		return softrating;
	}

	/**
	 * @param softRatingFilterCategory
	 *            the softrating to set
	 */
	public void setSoftrating(final FilterSection softRatingFilterCategory)
	{
		this.softrating = softRatingFilterCategory;
	}
}

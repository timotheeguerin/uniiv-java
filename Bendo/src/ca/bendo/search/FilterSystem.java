/**
 * 
 */
package ca.bendo.search;

import java.util.ArrayList;
import java.util.List;

import ca.bendo.search.category.FilterCategory;

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
	private List<FilterCategory> categories = new ArrayList<FilterCategory>();

	
	/**
	 * 
	 */
	private FilterCategory softrating;
	
	/**
	 * 
	 * @param category Category to add
	 */
	public void addCategory(final FilterCategory category)
	{
		categories.add(category);
	}

	/**
	 * @return the categories
	 */
	public List<FilterCategory> getCategories()
	{
		return categories;
	}

	/**
	 * @param categories
	 *            the categories to set
	 */
	public void setCategories(final List<FilterCategory> categories)
	{
		this.categories = categories;
	}

	/**
	 * @return the softrating
	 */
	public FilterCategory getSoftrating()
	{
		return softrating;
	}

	/**
	 * @param softRatingFilterCategory the softrating to set
	 */
	public void setSoftrating(final FilterCategory softRatingFilterCategory)
	{
		this.softrating = softRatingFilterCategory;
	}
}

/**
 * 
 */
package ca.bendo.search.softrating;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.bendo.db.entity.rating.UniversityRating;
import ca.bendo.search.category.FilterCategoryContent;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>SoftRatingCategoryContent</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class SoftRatingCategoryContent extends FilterCategoryContent
{
	/**
	 * 
	 */
	private Map<Integer, SoftRatingCategory> categories = new HashMap<Integer, SoftRatingCategory>();

	/**
	 * 
	 */
	private List<UniversityRating> stdRatings = new ArrayList<UniversityRating>();

	/**
	 * 
	 */
	private List<UniversityRating> officialRatings = new ArrayList<UniversityRating>();

	/**
	 * Constructor.
	 */
	public SoftRatingCategoryContent()
	{
		setFilename("views/search/filter/category/softrating.jsp");
	}

	/**
	 * 
	 * @param category
	 *            Category
	 */
	public void addCategory(final SoftRatingCategory category)
	{
		this.categories.put(category.getId(), category);
	}

	/**
	 * @return the categories
	 */
	public Map<Integer, SoftRatingCategory> getCategories()
	{
		return categories;
	}

	/**
	 * @param categories
	 *            the categories to set
	 */
	public void setCategories(final Map<Integer, SoftRatingCategory> categories)
	{
		this.categories = categories;
	}

	/**
	 * 
	 * @param id
	 *            Category id
	 * @return the category with the id given
	 */
	public SoftRatingCategory getCategory(final int id)
	{
		return this.categories.get(id);
	}

	/**
	 * @return the stdRatings
	 */
	public List<UniversityRating> getStdRatings()
	{
		return stdRatings;
	}

	/**
	 * @param stdRatings the stdRatings to set
	 */
	public void setStdRatings(final List<UniversityRating> stdRatings)
	{
		this.stdRatings = stdRatings;
	}

	/**
	 * @return the officialRatings
	 */
	public List<UniversityRating> getOfficialRatings()
	{
		return officialRatings;
	}

	/**
	 * @param officialRatings the officialRatings to set
	 */
	public void setOfficialRatings(final List<UniversityRating> officialRatings)
	{
		this.officialRatings = officialRatings;
	}

	
}

/**
 * 
 */
package ca.bendo.search.softrating;

import java.util.HashMap;
import java.util.Map;

import ca.bendo.search.category.FilterSectionContent;

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
public class SectionContentSimpleCheckBox extends FilterSectionContent
{
	/**
	 * 
	 */
	private Map<Integer, String> boxes = new HashMap<Integer, String>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.bendo.search.category.FilterSectionContent#init()
	 */
	@Override
	protected void init()
	{
		setFilename("views/search/filter/category/simpleCheckBox.jsp");
	}

	/**
	 * @return the boxes
	 */
	public Map<Integer, String> getBoxes()
	{
		return boxes;
	}

	/**
	 * @param boxes2
	 *            the boxes to set
	 */
	public void setBoxes(final Map<Integer, String> boxes2)
	{
		this.boxes = boxes2;
	}

}

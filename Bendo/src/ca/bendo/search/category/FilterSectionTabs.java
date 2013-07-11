/**
 * 
 */
package ca.bendo.search.category;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>FilterSectionTabs</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class FilterSectionTabs extends FilterSectionContent
{
	/**
	 * 
	 */
	private Map<String, FilterSectionContent> tabs = new HashMap<String, FilterSectionContent>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.bendo.search.category.FilterSectionContent#init()
	 */
	@Override
	protected void init()
	{
		setFilename("views/search/filter/category/tabs.jsp");
	}

	/**
	 * @return the tabs
	 */
	public Map<String, FilterSectionContent> getTabs()
	{
		return tabs;
	}

	/**
	 * @param tabs
	 *            the tabs to set
	 */
	public void setTabs(final Map<String, FilterSectionContent> tabs)
	{
		this.tabs = tabs;
	}

}

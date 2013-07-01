/**
 * 
 */
package ca.bendo.search.category;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>FilterSectionSubSection</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class FilterSectionSubSection extends FilterSectionContent
{
	/**
	 * 
	 */
	private List<FilterSectionContent> sections = new ArrayList<FilterSectionContent>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.bendo.search.category.FilterSectionContent#init()
	 */
	@Override
	protected void init()
	{
		setFilename("views/search/filter/category/subSections.jsp");
	}

	/**
	 * @return the sections
	 */
	public List<FilterSectionContent> getSections()
	{
		return sections;
	}

	/**
	 * @param sections
	 *            the sections to set
	 */
	public void setSections(final List<FilterSectionContent> sections)
	{
		this.sections = sections;
	}

}

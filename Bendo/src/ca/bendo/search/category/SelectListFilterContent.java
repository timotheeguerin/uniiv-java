/**
 * 
 */
package ca.bendo.search.category;


import ca.bendo.search.FilterElement;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>SelectListFilterContent</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class SelectListFilterContent extends FilterCategoryContent
{

	/**
	 * 
	 */
	private FilterElement content = new FilterElement();
	/**
	 * Constructor.
	 */
	public SelectListFilterContent()
	{
		setFilename("views/search/filter/category/selectlist.jsp");
	}
	/**
	 * @return the content
	 */
	public FilterElement getContent()
	{
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(final FilterElement content)
	{
		this.content = content;
	}
	/**
	 * @param e element to add
	 */
	public void addSubElement(final FilterElement e)
	{
		content.addSubElement(e);
		
	}




}

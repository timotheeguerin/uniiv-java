/**
 * 
 */
package ca.bendo.views.table;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TableUtils</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class FilterForm
{
	/**
	 * 
	 */
	private static final int NUM_PAGE_LINK = 4;

	/**
	 * 
	 */
	private int page;

	/**
	 * 
	 */
	private int numPage;

	/**
	 * 
	 */
	private String query;

	/**
 * 
 */
	public FilterForm()
	{
	}

	/**
	 * @param page
	 *            Page to set
	 * @param numPage
	 *            numPage to set
	 * @param query
	 *            Quesry to set
	 */
	public FilterForm(final int page, final int numPage, final String query)
	{
		super();
		this.page = page;
		this.numPage = numPage;
		this.query = query;
	}

	/**
	 * @return the page
	 */
	public int getPage()
	{
		return page;
	}

	/**
	 * @param page
	 *            the page to set
	 */
	public void setPage(final int page)
	{
		this.page = page;
	}

	/**
	 * @return the numPage
	 */
	public int getNumPage()
	{
		return numPage;
	}

	/**
	 * @param numPage
	 *            the numPage to set
	 */
	public void setNumPage(final int numPage)
	{
		this.numPage = numPage;
	}

	/**
	 * @return the query
	 */
	public String getQuery()
	{
		return query;
	}

	/**
	 * @param query
	 *            the query to set
	 */
	public void setQuery(final String query)
	{
		this.query = query;
	}

	/**
	 * @return first page choice for the filter views
	 */
	public int getFirstPageChoice()
	{
		if (page < NUM_PAGE_LINK)
		{
			return 0;
		}
		int result = 2 * NUM_PAGE_LINK + 1;
		if (page > numPage - result)
		{
			if (numPage - result < 0)
			{
				return 0;
			} else
			{
				return numPage - result;
			}
		} else
		{
			return page - NUM_PAGE_LINK;
		}
	}

	/**
	 * @return first page choice for the filter views
	 */
	public int getLastPageChoice()
	{
		int result = getFirstPageChoice() + 2 * NUM_PAGE_LINK + 1;
		if (result > numPage)
		{
			result = numPage;
		}
		return result;
	}
}

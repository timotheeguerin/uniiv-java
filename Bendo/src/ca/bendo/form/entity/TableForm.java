/**
 * 
 */
package ca.bendo.form.entity;

import javax.servlet.http.HttpServletRequest;

import ca.bendo.form.FieldValidator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TableForm</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class TableForm
{
	/**
	 * 
	 */
	private static final int DEFAULT_RESULT_PER_PAGE = 20;

	/**
	 * 
	 */
	private int page;

	/**
	 * 
	 */
	private int resultPerPage;

	/**
	 * 
	 */
	private String query;

	/**
	 * 
	 */
	public TableForm()
	{
		page = 0;
		resultPerPage = DEFAULT_RESULT_PER_PAGE;
		query = "";
	}

	/**
	 * @param defaultResultPerPage
	 *            Default value for the number of result per page
	 */
	public TableForm(final int defaultResultPerPage)
	{
		this();
		resultPerPage = defaultResultPerPage;
	}

	/**
	 * 
	 * @param request
	 *            Request
	 */
	public void load(final HttpServletRequest request)
	{
		String p = (String) request.getParameter("page");
		if (p != null && FieldValidator.isInt(p))
		{
			page = Integer.parseInt(p);
		}

		String q = (String) request.getParameter("query");
		if (q != null)
		{
			query = q;
		}
	}

	/**
	 * 
	 * @return the first result calculated with the page and result number per
	 *         page
	 */
	public int getFirstResult()
	{
		return page * resultPerPage;
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
	 * @return the resultPerPage
	 */
	public int getResultPerPage()
	{
		return resultPerPage;
	}

	/**
	 * @param resultPerPage
	 *            the resultPerPage to set
	 */
	public void setResultPerPage(final int resultPerPage)
	{
		this.resultPerPage = resultPerPage;
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

}

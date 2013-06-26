/**
 * 
 */
package ca.bendo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.bendo.db.dao.program.ProgramDAO;
import ca.bendo.search.FilterSystemLoader;
import ca.bendo.search.handler.SearchQueryHandler;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>SearchController</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Controller
@RequestMapping("/search")
public class SearchController
{
	/**
	 * 
	 */
	@Autowired
	private ProgramDAO programDAO;

	/**
	 * 
	 */
	@Autowired
	private SearchQueryHandler handler;
	/**
	 * 
	 */
	@Autowired
	private FilterSystemLoader filterSystemLoader;

	/**
	 * Method handling filter search page page.
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return JSP page
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String filterSearch(final HttpServletRequest request, final HttpServletResponse response)
	{
		filterSystemLoader.loadFilters(request);
		System.out.println("HomeController: Passing through...");

		request.getAttribute("translator");

		return "views/search/searchFilter";
	}

	/**
	 * Method handling filter search page page.
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return JSP page
	 */
	@RequestMapping(value = "/handle", method = RequestMethod.GET)
	public String filterSearchHandle(final HttpServletRequest request, final HttpServletResponse response)
	{
		System.out.println("HomeController: Passing through...");

		request.getAttribute("translator");

		handler.handle(request);

		// Parse programs
		return "views/universityResult";
	}

}

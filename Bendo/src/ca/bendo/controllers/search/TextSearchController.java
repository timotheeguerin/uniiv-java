/**
 * 
 */
package ca.bendo.controllers.search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.bendo.form.handler.search.TextSearchHandler;
import ca.bendo.json.AutoCompleteJson;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TextSearchController</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Controller
@RequestMapping(value = "/search/")
public class TextSearchController
{
	/**
	 * 
	 */
	@Autowired
	private TextSearchHandler searchHandler;

	/**
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return Jsp page
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public final String searchAll(final HttpServletRequest request, final HttpServletResponse response)
	{
		searchHandler.searchAll(request);
		return "views/university/search/searchAll";
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return Jsp page
	 */
	@RequestMapping(value = "/university", method = RequestMethod.GET)
	public final String searchUniversity(final HttpServletRequest request, final HttpServletResponse response)
	{
		searchHandler.searchUniversity(request);
		return "views/university/search/searchUniversity";
	}

	/**
	 * Get the request after filling inputs and submit of login.
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return Jsp page
	 */
	@RequestMapping(value = "/university/ajaxlist", method = RequestMethod.GET)
	@ResponseBody
	public final AutoCompleteJson universityListAjax(final HttpServletRequest request,
			final HttpServletResponse response)
	{
		return searchHandler.setupUniversityAjaxList(request);
	}
	
	/**
	 * Get the request after filling inputs and submit of login.
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return Jsp page
	 */
	@RequestMapping(value = "/all/ajaxlist", method = RequestMethod.GET)
	@ResponseBody
	public final AutoCompleteJson allListAjax(final HttpServletRequest request,
			final HttpServletResponse response)
	{
		return searchHandler.setupAjaxList(request);
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return Jsp page
	 */
	@RequestMapping(value = "/professor", method = RequestMethod.GET)
	public final String searchProfessor(final HttpServletRequest request, final HttpServletResponse response)
	{
		searchHandler.searchProfessor(request);
		return "views/university/search/searchProfessor";
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return Jsp page
	 */
	@RequestMapping(value = "/course", method = RequestMethod.GET)
	public final String searchCourse(final HttpServletRequest request, final HttpServletResponse response)
	{
		searchHandler.searchCourse(request);
		return "views/university/search/searchCourse";
	}
}

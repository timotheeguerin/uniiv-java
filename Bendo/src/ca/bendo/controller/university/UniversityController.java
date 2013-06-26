/**
 * 
 */
package ca.bendo.controller.university;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.bendo.db.entity.lang.Language;
import ca.bendo.db.entity.university.University;
import ca.bendo.json.AutoCompleteJson;
import ca.bendo.page.handler.UniversityTDS;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UniversityController</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Controller
public class UniversityController
{
	/**
	 * 
	 */
	@Autowired
	private UniversityTDS universityHandler;

	/**
	 * Get the request from the signup page.
	 * 
	 * @param universityId
	 *            university Id
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return Jsp page
	 */
	@RequestMapping(value = "/university/{uniId}", method = RequestMethod.GET)
	public String universityPage(@PathVariable(value = "uniId") final long universityId,
			final HttpServletRequest request, final HttpServletResponse response)
	{
		request.getAttribute("translator");
		Long languageId = Language.loadId(request);
		universityHandler.setLanguageId(languageId);
		University university = universityHandler.setupUniversityPage(universityId, request);
		if (university == null)
		{
			return "views/errors/error404";
		}
		return "views/university/university";
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
	public AutoCompleteJson professorNewUniversityListAjax(final HttpServletRequest request,
			final HttpServletResponse response)
	{

		return universityHandler.setupAjaxList(request);
	}

	/**
	 * @return the universityHandler
	 */
	public UniversityTDS getUniversityHandler()
	{
		return universityHandler;
	}

	/**
	 * @param universityHandler
	 *            the universityHandler to set
	 */
	public void setUniversityHandler(final UniversityTDS universityHandler)
	{
		this.universityHandler = universityHandler;
	}

}

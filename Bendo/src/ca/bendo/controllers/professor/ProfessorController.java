/**
 * 
 */
package ca.bendo.controllers.professor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.bendo.alert.UserWarning;
import ca.bendo.db.entity.lang.Language;
import ca.bendo.db.entity.professor.Professor;
import ca.bendo.form.handler.professor.ProfessorHandler;
import ca.bendo.json.AutoCompleteJson;
import ca.bendo.session.UserSession;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ProfessorController</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Controller
public class ProfessorController
{
	/**
	 * 
	 */
	@Autowired
	private ProfessorHandler professorHandler;

	/**
	 * Get the request after filling inputs and submit of login.
	 * 
	 * @param professorId
	 *            Professor id
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return Jsp page
	 */
	@RequestMapping(value = "/professor/{profId}", method = RequestMethod.GET)
	public final String professorUniversity(@PathVariable("profId") final long professorId,
			final HttpServletRequest request, final HttpServletResponse response)
	{
		Translator translator = (Translator) request.getAttribute("translator");
		Long languageId = Language.load(request);

		if (professorHandler.setupProfessorPage(professorId, request))
		{
			return "views/university/professor/professorHomePage";
		} else
		{
			return "redirect:" + translator.getLink("new_professor", languageId);
		}

	}

	/**
	 * New professor page.
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return Jsp page
	 */
	@RequestMapping(value = "/professor/new", method = RequestMethod.GET)
	public final String newProfessor(final HttpServletRequest request, final HttpServletResponse response)
	{
		request.setAttribute("form_error", false);
		return newProfessorJsp(request, response);
	}

	/**
	 * Call when user submit a new professor.
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return Jsp page
	 */
	@RequestMapping(value = "/professor/new", method = RequestMethod.POST)
	public final String submitNewProfessor(final HttpServletRequest request, final HttpServletResponse response)
	{
		Translator translator = (Translator) request.getAttribute("translator");
		Long languageId = Language.load(request);
		if (UserSession.getSession(request).hasPermission("user"))
		{

			Professor professor = professorHandler.handleNewProfessor(request);

			if (professor != null)
			{
				String url = "/professor/" + professor.getId() + "/university/add";
				String param = "?alertmsg=alert_info_professor_added";
				return "redirect:" + translator.translateUrl(url + param, languageId);
			}

			request.setAttribute("form_error", true);
		}
		return newProfessorJsp(request, response);
	}

	/**
	 * Manage the new Professor form page.
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return Jsp page
	 */
	private String newProfessorJsp(final HttpServletRequest request, final HttpServletResponse response)
	{
		UserWarning.needValidUser(request);
		professorHandler.setupNewProfessorPage(request);
		return "views/university/professor/newProfessor";
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
	@RequestMapping(value = "/professor/ajaxlist", method = RequestMethod.GET)
	@ResponseBody
	public final AutoCompleteJson professorNewUniversityListAjax(final HttpServletRequest request,
			final HttpServletResponse response)
	{

		return professorHandler.setupAjaxList(request);
	}

}

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

import ca.bendo.db.entity.lang.Language;
import ca.bendo.form.handler.professor.ProfessorUniversityHandler;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>NewProfessorUniversityController</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Controller
public class ProfessorUniversityController
{
	/**
	 * 
	 */
	@Autowired
	private ProfessorUniversityHandler professorUniversityHandler;

	/**
	 * Get the request after filling inputs and submit of login.
	 * 
	 * @param universityId
	 *            University id
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return Jsp page
	 */
	@RequestMapping(value = "/university/{uniId}/professors/", method = RequestMethod.GET)
	public final String professorInUniversity(@PathVariable("uniId") final int universityId,
			final HttpServletRequest request, final HttpServletResponse response)
	{
		if (professorUniversityHandler.setupProfessorInUniversityPage(universityId, request))
		{
			return "views/university/professor/UniversityProfessorList";
		} else
		{
			return "redirect:/university/univeristyerror";
		}

	}

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
	@RequestMapping(value = "/professor/{profId}/universities/", method = RequestMethod.GET)
	public final String professorUniversity(@PathVariable("profId") final int professorId,
			final HttpServletRequest request, final HttpServletResponse response)
	{
		// Translator translator = (Translator)
		// request.getAttribute("translator");
		/**
		 * 
		 */
		if (professorUniversityHandler.setupProfessorUniversityPage(professorId, request))
		{
			return "views/university/professor/ProfessorUniversityList";
		} else
		{
			return "redirect:/university/univeristyerror";
		}

	}



	/**
	 * Get the request after filling inputs and submit of login.
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @param professorId
	 *            Id of the professor
	 * @return Jsp page
	 */
	@RequestMapping(value = "/professor/{profId}/university/add", method = RequestMethod.GET)
	public final String newProfessorUniversity(@PathVariable("profId") final long professorId,
			final HttpServletRequest request, final HttpServletResponse response)
	{
		return newProfessorUniversityPage(professorId, request, response);
	}

	/**
	 * Get the request after filling inputs and submit of login.
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @param professorId
	 *            Id of the professor
	 * @return Jsp page
	 */
	@RequestMapping(value = "/professor/{profId}/university/add", method = RequestMethod.POST)
	public final String handleNewProfessorUniversity(@PathVariable("profId") final long professorId,
			final HttpServletRequest request, final HttpServletResponse response)
	{
		Translator translator = (Translator) request.getAttribute("translator");
		Long languageId = Language.loadId(request);
		if (professorUniversityHandler.handle(String.valueOf(professorId), request))
		{
			String url = "/professor/" + professorId;
			String param = "?alertmsg=alert_info_professor_university_added";
			return "redirect:" + translator.translateUrl(url + param, languageId);
		} else
		{
			request.setAttribute("new_prof_uni_form_error", true);
		}
		return newProfessorUniversityPage(professorId, request, response);
	}

	/**
	 * Get the request after filling inputs and submit of login.
	 * 
	 * @param professorId
	 *            professor id
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return Jsp page
	 */
	public final String newProfessorUniversityPage(final long professorId, final HttpServletRequest request,
			final HttpServletResponse response)
	{
		Translator translator = (Translator) request.getAttribute("translator");
		Long languageId = Language.loadId(request);
		if (!professorUniversityHandler.setupNewProfessorUniversityPage(professorId, request))
		{
			return "redirect:" + translator.getLink("new_professor", languageId);
		} else
		{
			return "views/university/professor/newProfessorUniversity";
		}
	}
}

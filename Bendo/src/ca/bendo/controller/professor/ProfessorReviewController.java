/**
 * 
 */
package ca.bendo.controller.professor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.bendo.alert.UserWarning;
import ca.bendo.db.entity.lang.Language;
import ca.bendo.form.handler.professor.NewProfessorReviewHandler;
import ca.bendo.session.UserSession;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ProfessorReview</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Controller
public class ProfessorReviewController
{
	/**
	 * 
	 */
	@Autowired
	private NewProfessorReviewHandler reviewHandler;

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
	@RequestMapping(value = "/professor/{profId}/review/new", method = RequestMethod.GET)
	public String professorReview(@PathVariable("profId") final long professorId,
			final HttpServletRequest request, final HttpServletResponse response)
	{
		return newProfessorReviewPage(professorId, request, response);
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
	@RequestMapping(value = "/professor/{profId}/review/new", method = RequestMethod.POST)
	public String handleNewProfessorReview(@PathVariable("profId") final long professorId,
			final HttpServletRequest request, final HttpServletResponse response)
	{
		Translator translator = (Translator) request.getAttribute("translator");
		Long languageId = Language.loadId(request);
		if (UserSession.getSession(request).hasPermission("user"))
		{

			if (reviewHandler.newProfessorReview(String.valueOf(professorId), request))
			{
				String url = "/professor/" + professorId;
				String param = "?alertmsg=alert_info_review_added";
				return "redirect:" + translator.translateUrl(url + param, languageId);
			} else
			{
				request.setAttribute("new_review_form_error", true);
			}
		}
		return newProfessorReviewPage(professorId, request, response);
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
	public String newProfessorReviewPage(final long professorId, final HttpServletRequest request,
			final HttpServletResponse response)
	{
		UserWarning.needValidUser(request);
		Translator translator = (Translator) request.getAttribute("translator");
		Long languageId = Language.loadId(request);
		if (!reviewHandler.setupNewReviewPage(professorId, request))
		{
			return "redirect:" + translator.getLink("new_professor", languageId);
		} else
		{
			return "views/university/professor/newProfReview";
		}
	}

}

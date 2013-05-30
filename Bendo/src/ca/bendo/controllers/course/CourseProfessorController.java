/**
 * 
 */
package ca.bendo.controllers.course;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.bendo.alert.UserWarning;
import ca.bendo.db.entity.lang.Language;
import ca.bendo.form.handler.course.CourseProfessorHandler;
import ca.bendo.session.UserSession;
import ca.bendo.translation.RequestTranslator;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>CourseProfessorController</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Controller
public class CourseProfessorController
{
	/**
	 * 
	 */
	@Autowired
	private CourseProfessorHandler courseProfessorHandler;

	/**
	 * Get the request after filling inputs and submit of login.
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @param universityId
	 *            University id
	 * 
	 * @param courseId
	 *            Course id
	 * @return Jsp page
	 */
	@RequestMapping(value = "/university/{uniId}/course/{courseId}/professors", method = RequestMethod.GET)
	public final String courseTeachedByProfessor(@PathVariable("uniId") final long universityId,
			@PathVariable("courseId") final long courseId, final HttpServletRequest request,
			final HttpServletResponse response)
	{
		// Translator translator = (Translator)
		// request.getAttribute("translator");
		/**
		 * 
		 */
		if (courseProfessorHandler.setupCourseProfessorPage(universityId, courseId, request))
		{
			return "views/university/course/CourseProfessorList";
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
	@RequestMapping(value = "/professor/{profId}/courses/", method = RequestMethod.GET)
	public final String professorUniversity(@PathVariable("profId") final int professorId,
			final HttpServletRequest request, final HttpServletResponse response)
	{
		// Translator translator = (Translator)
		// request.getAttribute("translator");
		/**
		 * 
		 */
		if (courseProfessorHandler.setupProfessorCoursePage(professorId, request))
		{
			return "views/university/course/ProfessorCourseList";
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
	 * @param universityId
	 *            University id
	 * 
	 * @param courseId
	 *            Course id
	 * @return Jsp page
	 */
	@RequestMapping(value = "/university/{uniId}/course/{courseId}/professor/new", method = RequestMethod.GET)
	public final String professorReview(@PathVariable("uniId") final long universityId,
			@PathVariable("courseId") final long courseId, final HttpServletRequest request,
			final HttpServletResponse response)
	{
		return newCourseProfessorPage(universityId, courseId, request, response);
	}

	/**
	 * Get the request after filling inputs and submit of login.
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @param universityId
	 *            University id
	 * 
	 * @param courseId
	 *            Course id
	 * @return Jsp page
	 */
	@RequestMapping(value = "/university/{uniId}/course/{courseId}/professor/new", method = RequestMethod.POST)
	public final String handleNewProfessorReview(@PathVariable("uniId") final long universityId,
			@PathVariable("courseId") final long courseId, final HttpServletRequest request,
			final HttpServletResponse response)
	{
		Translator translator = (Translator) request.getAttribute("translator");
		Long languageId = Language.loadId(request);
		if (UserSession.getSession(request).hasPermission("user"))
		{

			if (courseProfessorHandler.handle(universityId, courseId, request))
			{
				String url = "/university/" + universityId + "/course/" + courseId;
				String param = "?alertmsg=alert_info_course_professor_added";

				return "redirect:" + translator.translateUrl(url + param, languageId);
			} else
			{
				request.setAttribute("new_review_form_error", true);
			}
		}
		return newCourseProfessorPage(universityId, courseId, request, response);

	}

	/**
	 * Get the request after filling inputs and submit of login.
	 * 
	 * @param universityId
	 *            University id
	 * @param courseId
	 *            Course id
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return Jsp page
	 */
	public final String newCourseProfessorPage(final long universityId, final long courseId,
			final HttpServletRequest request, final HttpServletResponse response)
	{
		UserWarning.needValidUser(request);
		RequestTranslator translator = RequestTranslator.load(request);
		if (!courseProfessorHandler.setupNewCourseProfessorPage(universityId, courseId, request))
		{
			return "redirect:" + translator.getTranslator().getLink("new_course", translator.getLanguage().getId())
					+ "?err_no_course_with_id=" + courseId;
		} else
		{
			return "views/university/course/newCourseProfessor";
		}
	}
}

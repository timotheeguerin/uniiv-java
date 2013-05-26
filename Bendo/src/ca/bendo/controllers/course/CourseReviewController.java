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
import ca.bendo.form.handler.course.CourseReviewHandler;
import ca.bendo.session.UserSession;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>CourseReviewController</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Controller
public class CourseReviewController
{
	/**
	 * 
	 */
	@Autowired
	private CourseReviewHandler reviewHandler;

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
	@RequestMapping(value = "/university/{uniId}/course/{courseId}/review/new", method = RequestMethod.GET)
	public final String professorReview(@PathVariable("uniId") final long universityId,
			@PathVariable("courseId") final long courseId, final HttpServletRequest request,
			final HttpServletResponse response)
	{
		return newCourseReviewPage(universityId, courseId, request, response);
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
	@RequestMapping(value = "/university/{uniId}/course/{courseId}/review/new", method = RequestMethod.POST)
	public final String handleNewProfessorReview(@PathVariable("uniId") final long universityId,
			@PathVariable("courseId") final long courseId, final HttpServletRequest request,
			final HttpServletResponse response)
	{
		Translator translator = (Translator) request.getAttribute("translator");
		Long languageId = Language.load(request);
		if (UserSession.getSession(request).hasPermission("user"))
		{

			if (reviewHandler.handleNewCourseReview(universityId, courseId, request))
			{
				String url = "/university/" + universityId + "/course/" + courseId;
				String param = "?alertmsg=alert_info_review_added";
				return "redirect:" + translator.translateUrl(url + param, languageId);
			} else
			{
				request.setAttribute("new_review_form_error", true);
			}
		}
		return newCourseReviewPage(universityId, courseId, request, response);

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
	public final String newCourseReviewPage(final long universityId, final long courseId,
			final HttpServletRequest request, final HttpServletResponse response)
	{
		UserWarning.needValidUser(request);
		Translator translator = (Translator) request.getAttribute("translator");
		Long languageId = Language.load(request);
		if (!reviewHandler.setupNewReviewPage(universityId, courseId, request))
		{
			return "redirect:" + translator.getLink("new_course", languageId) + "?err_no_course_with_id=" + courseId;
		} else
		{
			return "views/university/course/newCourseReview";
		}
	}

}

/**
 * 
 */
package ca.bendo.controller.course;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.bendo.alert.UserWarning;
import ca.bendo.db.entity.course.Course;
import ca.bendo.db.entity.lang.Language;
import ca.bendo.db.entity.university.University;
import ca.bendo.form.handler.course.CourseHandler;
import ca.bendo.session.UserSession;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>CourseController</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Controller
public class CourseController
{
	/**
	 * 
	 */
	@Autowired
	private CourseHandler courseHandler;

	/**
	 * Get the request after filling inputs and submit of login.
	 * 
	 * @param universityId
	 *            University id
	 * 
	 * @param courseId
	 *            Course id
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return Jsp page
	 */
	@RequestMapping(value = "university/{uniId}/course/{courseId}", method = RequestMethod.GET)
	public String professorUniversity(@PathVariable("uniId") final long universityId,
			@PathVariable("courseId") final long courseId, final HttpServletRequest request,
			final HttpServletResponse response)
	{
		Translator translator = (Translator) request.getAttribute("translator");
		Long languageId = Language.loadId(request);
		/**
		 * 
		 */
		if (courseHandler.setupCoursePage(universityId, courseId, request))
		{
			return "views/university/course/courseHomePage";
		} else
		{
			return "redirect:" + translator.getLink("error_404", languageId);
		}

	}

	/**
	 * New professor page.
	 * 
	 * @param universityId
	 *            University id
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return Jsp page
	 */
	@RequestMapping(value = "university/{uniId}/course/new", method = RequestMethod.GET)
	public String newCourse(@PathVariable("uniId") final long universityId, final HttpServletRequest request,
			final HttpServletResponse response)
	{
		request.setAttribute("form_error", false);
		return newCourseJsp(universityId, request, response);
	}

	/**
	 * Call when user submit a new professor.
	 * 
	 * @param universityId
	 *            University id
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return Jsp page
	 */
	@RequestMapping(value = "university/{uniId}/course/new", method = RequestMethod.POST)
	public String submitNewProfessor(@PathVariable("uniId") final long universityId,
			final HttpServletRequest request, final HttpServletResponse response)
	{
		Translator translator = (Translator) request.getAttribute("translator");
		Long languageId = Language.loadId(request);
		if (UserSession.getSession(request).hasPermission("user"))
		{

			Course course = courseHandler.handle(universityId, request);
			if (course != null)
			{
				String url = "/university/" + universityId + "/course/" + course.getId();
				String param = "?alertmsg=alert_info_course_added";
				return "redirect:" + translator.translateUrl(url + param, languageId);
			} else
			{
				request.setAttribute("form_error", true);
			}
		}
		return newCourseJsp(universityId, request, response);

	}

	/**
	 * Manage the new Professor form page.
	 * 
	 * @param universityId
	 *            University id
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return Jsp page
	 */
	private String newCourseJsp(final long universityId, final HttpServletRequest request,
			final HttpServletResponse response)
	{
		UserWarning.needValidUser(request);
		Translator translator = (Translator) request.getAttribute("translator");
		Long languageId = Language.loadId(request);
		if (courseHandler.setupNewCoursePage(universityId, request))
		{
			return "views/university/course/newCourse";
		} else
		{
			return "redirect:" + translator.getLink("error_404", languageId);
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
	@RequestMapping(value = "/course/new", method = RequestMethod.GET)
	public String newCourseSelectUniversity(final HttpServletRequest request, final HttpServletResponse response)
	{
		return newCourseSelectUniversityPage(request, response);
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
	@RequestMapping(value = "/course/new", method = RequestMethod.POST)
	public String handleNewCourseSelectUniversity(final HttpServletRequest request,
			final HttpServletResponse response)
	{
		Translator translator = (Translator) request.getAttribute("translator");
		Long languageId = Language.loadId(request);
		if (UserSession.getSession(request).hasPermission("user"))
		{

			University university = courseHandler.handleNewCourseSelectUniversity(request);
			if (university != null)
			{
				String url = "/university/" + university.getId() + "/course/new";
				String param = "";
				return "redirect:" + translator.translateUrl(url + param, languageId);
			} else
			{
				request.setAttribute("form_error", true);
			}
		}
		return newCourseSelectUniversityPage(request, response);
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
	private String newCourseSelectUniversityPage(final HttpServletRequest request, final HttpServletResponse response)
	{
		UserWarning.needValidUser(request);

		return "views/university/course/NewCourseSelectUniversity";

	}

}

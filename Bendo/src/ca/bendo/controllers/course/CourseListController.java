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

import ca.bendo.db.entity.lang.Language;
import ca.bendo.form.handler.course.CourseHandler;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>CourseListController</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Controller
public class CourseListController
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
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return Jsp page
	 */
	@RequestMapping(value = "university/{uniId}/courses/", method = RequestMethod.GET)
	public final String professorUniversity(@PathVariable("uniId") final long universityId,
			final HttpServletRequest request, final HttpServletResponse response)
	{
		Translator translator = (Translator) request.getAttribute("translator");
		Long languageId = Language.loadId(request);
		/**
		 * 
		 */
		if (courseHandler.setupUniversityCourseListPage(universityId, request))
		{
			return "views/university/course/UniversityCourseList";
		} else
		{
			return "redirect:" + translator.getLink("error_404", languageId);
		}

	}
}

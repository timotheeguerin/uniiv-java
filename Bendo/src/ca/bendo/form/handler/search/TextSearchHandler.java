/**
 * 
 */
package ca.bendo.form.handler.search;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.course.CourseDAO;
import ca.bendo.db.dao.professor.ProfessorDAO;
import ca.bendo.db.dao.university.UniversityDAO;
import ca.bendo.db.entity.course.Course;
import ca.bendo.db.entity.lang.Language;
import ca.bendo.db.entity.professor.Professor;
import ca.bendo.db.entity.university.University;
import ca.bendo.form.entity.search.TextSearchEntity;
import ca.bendo.json.AutoCompleteJson;
import ca.bendo.json.Suggestion;
import ca.bendo.translation.translation.Translator;
import ca.bendo.utils.url.UrlFactory;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TextSearchHandler</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class TextSearchHandler
{

	/**
	 * 
	 */
	private static final int AJAX_MAX_RESULT = 5;

	/**
	 * 
	 */
	private static final int PAGE_MAX_RESULTS = 20;

	/**
	 * 
	 */
	@Autowired
	private UniversityDAO universityDAO;

	/**
	 * 
	 */
	@Autowired
	private ProfessorDAO professorDAO;

	/**
	 * 
	 */
	@Autowired
	private CourseDAO courseDAO;

	/**
	 * 
	 * @param request
	 *            Request
	 * @return request
	 */
	public boolean searchAll(final HttpServletRequest request)
	{

		TextSearchEntity entity = new TextSearchEntity();
		entity.setup(request);
		if (!entity.isValid())
		{
			System.out.println("Search invalid");
			return false;
		}

		List<University> universities = universityDAO
				.listUniversityLikeMaxResults(entity.getQuery(), PAGE_MAX_RESULTS);
		request.setAttribute("universities", universities);
		List<Professor> professors = professorDAO.listProfessorLikeMaxResults(entity.getQuery(), PAGE_MAX_RESULTS);
		request.setAttribute("professors", professors);
		List<Course> courses = courseDAO.listCourseLikeMaxResults(entity.getQuery(), PAGE_MAX_RESULTS);
		request.setAttribute("courses", courses);
		request.setAttribute("query", entity.getQuery());
		return true;
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @return request
	 */
	public boolean searchUniversity(final HttpServletRequest request)
	{
		TextSearchEntity entity = new TextSearchEntity();
		entity.setup(request);
		if (!entity.isValid())
		{
			System.out.println("Search invalid");
			return false;
		}

		List<University> universities = universityDAO
				.listUniversityLikeMaxResults(entity.getQuery(), PAGE_MAX_RESULTS);
		request.setAttribute("universities", universities);
		request.setAttribute("query", entity.getQuery());
		return true;
	}

	/**
	 * @param request
	 *            Request
	 * @return university list in json format
	 */
	public AutoCompleteJson setupAjaxList(final HttpServletRequest request)
	{
		String query = request.getParameter("query");
		Translator translator = Translator.getTranslator(request);
		Long languageId = Language.loadId(request);
		List<University> universities;
		List<Professor> professors;
		List<Course> courses;
		if (query == null)
		{
			universities = universityDAO.listN(AJAX_MAX_RESULT);
			professors = professorDAO.listN(AJAX_MAX_RESULT);
			courses = courseDAO.listN(AJAX_MAX_RESULT);
			query = "";
		} else
		{
			universities = universityDAO.listUniversityLikeMaxResults(query, AJAX_MAX_RESULT);
			professors = professorDAO.listProfessorLikeMaxResults(query, AJAX_MAX_RESULT);
			courses = courseDAO.listCourseLikeMaxResults(query, AJAX_MAX_RESULT);
		}
		AutoCompleteJson autoCompleteJson = new AutoCompleteJson();
		autoCompleteJson.setQuery(query);

		for (University university : universities)
		{
			String url = translator.translateUrl("/university/" + university.getId(), languageId);

			String value = university.getName();
			Suggestion sug = new Suggestion(value, UrlFactory.getUrl(url, request), "university");
			autoCompleteJson.getSuggestions().add(sug);
		}

		for (Professor professor : professors)
		{
			String url = translator.translateUrl("/professor/" + professor.getId(), languageId);

			String value = professor.toString();
			Suggestion sug = new Suggestion(value, UrlFactory.getUrl(url, request), "professor");
			autoCompleteJson.getSuggestions().add(sug);
		}

		for (Course course : courses)
		{
			String url = translator.translateUrl(
					"/university/" + course.getUniversity().getId() + "/course/" + course.getId(), languageId);
			String name = course.getName() + " (" + course.getCode() + ")";
			String value = name;
			Suggestion sug = new Suggestion(value, UrlFactory.getUrl(url, request), "course");
			autoCompleteJson.getSuggestions().add(sug);
		}
		return autoCompleteJson;

	}

	/**
	 * @param request
	 *            Request
	 * @return university list in json format
	 */
	public AutoCompleteJson setupUniversityAjaxList(final HttpServletRequest request)
	{
		String universityName = request.getParameter("query");
		Translator translator = Translator.getTranslator(request);
		Long languageId = Language.loadId(request);
		List<University> universities;
		if (universityName == null)
		{
			universities = universityDAO.listUniversities();
			universityName = "";
		} else
		{

			universities = universityDAO.listUniversityLike(universityName);
		}
		AutoCompleteJson autoCompleteJson = new AutoCompleteJson();
		autoCompleteJson.setQuery(universityName);

		for (University university : universities)
		{
			String url = translator.translateUrl("/university/" + university.getId(), languageId);

			Suggestion sug = new Suggestion(university.getName(), UrlFactory.getUrl(url, request));
			autoCompleteJson.getSuggestions().add(sug);
		}

		return autoCompleteJson;

	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @return request
	 */

	public boolean searchProfessor(final HttpServletRequest request)
	{

		TextSearchEntity entity = new TextSearchEntity();
		entity.setup(request);
		if (!entity.isValid())
		{
			System.out.println("Search invalid");
			return false;
		}
		List<Professor> professors = professorDAO.listProfessorLikeMaxResults(entity.getQuery(), PAGE_MAX_RESULTS);
		request.setAttribute("professors", professors);
		request.setAttribute("query", entity.getQuery());
		return true;

	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @return request
	 */

	public boolean searchCourse(final HttpServletRequest request)
	{

		TextSearchEntity entity = new TextSearchEntity();
		entity.setup(request);
		if (!entity.isValid())
		{
			System.out.println("Search invalid");
			return false;
		}
		List<Course> courses = courseDAO.listCourseLikeMaxResults(entity.getQuery(), PAGE_MAX_RESULTS);
		request.setAttribute("courses", courses);
		request.setAttribute("query", entity.getQuery());
		return true;

	}
}

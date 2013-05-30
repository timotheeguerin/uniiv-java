/**
 * 
 */
package ca.bendo.form.handler.course;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.course.CourseDAO;
import ca.bendo.db.dao.course.CourseRatingDAO;
import ca.bendo.db.dao.course.CourseRatingTypeDAO;
import ca.bendo.db.dao.course.CourseReviewDAO;
import ca.bendo.db.dao.program.UniversityProgramDAO;
import ca.bendo.db.dao.university.UniversityDAO;
import ca.bendo.db.entity.course.Course;
import ca.bendo.db.entity.course.CourseRatingAverage;
import ca.bendo.db.entity.course.CourseRatingType;
import ca.bendo.db.entity.course.CourseReview;
import ca.bendo.db.entity.lang.Language;
import ca.bendo.db.entity.program.UniversityProgram;
import ca.bendo.db.entity.university.University;
import ca.bendo.form.FieldValidator;
import ca.bendo.form.entity.course.NewCourseEntity;
import ca.bendo.translation.translation.Translator;
import ca.bendo.views.table.course.CourseTable;
import ca.bendo.views.table.course.CourseTableRow;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>NewCourseHandler</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class CourseHandler
{
	/**
	 * 
	 */
	private static final int COURSE_PAGE_MAX_REVIEW = 5;

	/**
	 * 
	 */
	@Autowired
	private UniversityDAO universityDAO;

	/**
	 * 
	 */
	@Autowired
	private CourseDAO courseDAO;

	/**
	 * 
	 */
	@Autowired
	private UniversityProgramDAO programDAO;

	/**
	 * 
	 */
	@Autowired
	private CourseRatingDAO courseRatingDAO;

	/**
	 * 
	 */
	@Autowired
	private CourseReviewDAO courseReviewDAO;

	/**
	 * 
	 */
	@Autowired
	private CourseRatingTypeDAO courseRatingTypeDAO;

	/**
	 * 
	 * @param universityId
	 *            University id
	 * @param request
	 *            Request
	 * @return if the request was succesful
	 */
	public Course handle(final long universityId, final HttpServletRequest request)
	{
		NewCourseEntity entity = new NewCourseEntity();
		entity.setup(request);

		if (!entity.isValid())
		{
			entity.setupErrorsDisplay(request);

			request.setAttribute("newCourseEntity", entity);
			return null;
		}

		University university = universityDAO.getById(universityId);
		if (university == null)
		{
			return null;
		}

		UniversityProgram program = programDAO.getById(Long.parseLong(entity.getProgramId()));
		if (program == null)
		{
			return null;
		}
		Course course = new Course();
		course.setName(entity.getCourseName());
		course.setCode(entity.getCourseCode().toUpperCase());
		course.setUniversity(university);
		course.setProgram(program);
		courseDAO.add(course);
		return course;
	}

	/**
	 * 
	 * @param universityId
	 *            University id
	 * @param request
	 *            request
	 * @return if the setup could be completed succesfuly
	 */
	public boolean setupNewCoursePage(final long universityId, final HttpServletRequest request)
	{
		request.getAttribute("translator");
		Long languageId = Language.loadId(request);
		programDAO.enableTranslation(languageId);
		universityDAO.setLanguageId(languageId);
		University university = universityDAO.getById(universityId);
		if (university == null)
		{
			return false;
		}

		request.setAttribute("programs", university.getPrograms());
		return true;
	}

	/**
	 * @param universityId
	 *            Univerity id
	 * @param courseId
	 *            Course id
	 * @param request
	 *            request
	 * @return return if the page could be loaded succesfully
	 */
	public boolean setupCoursePage(final long universityId, final long courseId, final HttpServletRequest request)
	{
		University university = universityDAO.getById(universityId);
		if (university == null)
		{
			return false;
		}

		Course course = courseDAO.getById(courseId);
		if (course == null)
		{
			return false;
		}
		CourseRatingAverage courseRatings = courseRatingDAO.getCourseRatingsMean(course.getId());
		request.setAttribute("courseRatings", courseRatings);
		request.setAttribute("course", course);
		request.setAttribute("university", university);

		List<CourseRatingType> types = courseRatingTypeDAO.list();
		request.setAttribute("types", types);

		// Load the last 5 reviews
		List<CourseReview> reviews = courseReviewDAO.listLastCourseReview(courseId, COURSE_PAGE_MAX_REVIEW);
		request.setAttribute("reviews", reviews);
		return true;
	}

	/**
	 * @param universityId
	 *            Univerity id
	 * @param request
	 *            request
	 * @return return if the page could be loaded succesfully
	 */
	public boolean setupUniversityCourseListPage(final long universityId, final HttpServletRequest request)
	{
		Translator translator = (Translator) request.getAttribute("translator");
		Long languageId = Language.loadId(request);
		University university = universityDAO.getById(universityId);
		if (university == null)
		{
			return false;
		}

		List<Course> courses = courseDAO.listCourseInUniversity(universityId);

		List<CourseRatingType> types = courseRatingTypeDAO.list();
		CourseTable table = new CourseTable(types);
		for (Course course : courses)
		{
			String link = translator.translateUrl("/university/" + universityId + "/course/" + course.getId(),
					languageId);

			CourseRatingAverage ratings = courseRatingDAO.getCourseRatingsMean(course.getId());

			CourseTableRow row = (CourseTableRow) table.createRow(CourseTableRow.class, link);
			row.setup(course, ratings, types);
		}

		request.setAttribute("coursesTable", table);

		request.setAttribute("university", university);
		request.setAttribute("types", types);
		return true;
	}

	/**
	 * @param request
	 *            Request
	 * @return Univeersity
	 */
	public University handleNewCourseSelectUniversity(final HttpServletRequest request)
	{
		String uniString = request.getParameter("universityid");
		if (!FieldValidator.isInt(uniString))
		{
			return null;
		}
		long universityId = Long.parseLong(uniString);

		University university = universityDAO.getById(universityId);

		return university;
	}
}

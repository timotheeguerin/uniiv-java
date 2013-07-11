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
import ca.bendo.db.dao.course.CourseProfessorDAO;
import ca.bendo.db.dao.course.CourseProfessorPeriodDAO;
import ca.bendo.db.dao.course.CourseRatingDAO;
import ca.bendo.db.dao.course.CourseRatingTypeDAO;
import ca.bendo.db.dao.course.SemesterDAO;
import ca.bendo.db.dao.professor.ProfessorDAO;
import ca.bendo.db.dao.professor.ProfessorRatingDAO;
import ca.bendo.db.dao.professor.ProfessorRatingTypeDAO;
import ca.bendo.db.dao.professor.ProfessorUniversityDAO;
import ca.bendo.db.dao.university.UniversityDAO;
import ca.bendo.db.entity.course.Course;
import ca.bendo.db.entity.course.CourseProfessor;
import ca.bendo.db.entity.course.CourseProfessorPeriod;
import ca.bendo.db.entity.course.CourseRatingAverage;
import ca.bendo.db.entity.course.CourseRatingType;
import ca.bendo.db.entity.course.Semester;
import ca.bendo.db.entity.lang.Language;
import ca.bendo.db.entity.professor.Professor;
import ca.bendo.db.entity.professor.ProfessorRatingAverage;
import ca.bendo.db.entity.professor.ProfessorRatingType;
import ca.bendo.db.entity.university.University;
import ca.bendo.form.FormErrorHandler;
import ca.bendo.form.entity.course.NewCourseProfessorEntity;
import ca.bendo.translation.translation.Translator;
import ca.bendo.views.table.TableCell;
import ca.bendo.views.table.TableTopCell;
import ca.bendo.views.table.course.CourseTable;
import ca.bendo.views.table.course.CourseTableRow;
import ca.bendo.views.table.professor.ProfessorTable;
import ca.bendo.views.table.professor.ProfessorTableRow;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>CourseProfessorHandler</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class CourseProfessorHandler
{
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
	 */
	@Autowired
	private CourseProfessorDAO courseProfessorDAO;

	/**
	 * 
	 */
	@Autowired
	private CourseRatingDAO courseRatingDAO;

	/**
	 * 
	 */
	@Autowired
	private CourseRatingTypeDAO courseRatingTypeDAO;

	/**
	 * 
	 */
	@Autowired
	private CourseProfessorPeriodDAO courseProfessorPeriodDAO;

	/**
	 * 
	 */
	@Autowired
	private SemesterDAO semesterDAO;

	/**
	 * 
	 */
	@Autowired
	private ProfessorUniversityDAO professorUniversityDAO;

	/**
	 * 
	 */
	@Autowired
	private ProfessorRatingDAO professorRatingDAO;

	/**
	 * 
	 */
	@Autowired
	private ProfessorRatingTypeDAO professorRatingTypeDAO;

	/**
	 * @param universityId
	 *            university id
	 * @param courseId
	 *            university id
	 * @param request
	 *            request
	 * @return if the setup was successful
	 */
	public boolean setupCourseProfessorPage(final long universityId, final long courseId,
			final HttpServletRequest request)
	{
		Translator translator = (Translator) request.getAttribute("translator");
		Long languageId = Language.loadId(request);
		University university = universityDAO.getById(universityId);
		if (university == null)
		{
			return false;
		}
		Course course = courseDAO.getById(courseId);
		if (course == null)
		{
			System.out.println("Course doesn't exist");
			return false;
		}

		List<CourseProfessor> professors = courseProfessorDAO.listCourseProfessor(courseId);
		List<ProfessorRatingType> types = professorRatingTypeDAO.listProfessorRatingType();

		// Setup Table
		ProfessorTable table = new ProfessorTable(types);
		TableTopCell periodHeaderCell = new TableTopCell("period", "views/university/course/semesterSentence.jsp");
		table.getHeader().add(periodHeaderCell);

		for (CourseProfessor professor : professors)
		{
			String link = translator.translateUrl("/professor/" + professor.getProfessor().getId(), languageId);
			ProfessorRatingAverage ratings = professorRatingDAO.getProfessorRatingsMean(professor.getProfessor()
					.getId());
			ProfessorTableRow row = (ProfessorTableRow) table.createRow(ProfessorTableRow.class, link);
			row.setup(professor.getProfessor(), ratings, types);
			TableCell periodCell = new TableCell(professor.getPeriods());
			row.add(periodHeaderCell, periodCell);
		}

		request.setAttribute("professorsTable", table);

		request.setAttribute("course", course);
		request.setAttribute("types", types);
		return true;
	}

	/**
	 * @param professorId
	 *            professor id
	 * @param request
	 *            request
	 * @return if the setup was successful
	 */
	public boolean setupProfessorCoursePage(final long professorId, final HttpServletRequest request)
	{
		Translator translator = (Translator) request.getAttribute("translator");
		Long languageId = Language.loadId(request);

		Professor professor = professorDAO.getById(professorId);
		if (professor == null)
		{
			return false;
		}

		List<CourseProfessor> courses = courseProfessorDAO.listProfessorCourse(professorId);
		List<CourseRatingType> types = courseRatingTypeDAO.list();

		CourseTable table = new CourseTable(types);

		TableTopCell periodHeaderCell = new TableTopCell("period", "views/university/course/semesterSentence.jsp");
		table.getHeader().add(periodHeaderCell);

		for (CourseProfessor course : courses)
		{
			long universityId = course.getCourse().getUniversity().getId();
			String link = translator.translateUrl("/university/" + universityId + "/course/" + course.getId(),
					languageId);

			CourseRatingAverage ratings = courseRatingDAO.getCourseRatingsMean(course.getId());

			CourseTableRow row = (CourseTableRow) table.createRow(CourseTableRow.class, link);
			row.setup(course.getCourse(), ratings, types);
			TableCell periodCell = new TableCell(course.getPeriods());
			row.add(periodHeaderCell, periodCell);
		}

		request.setAttribute("coursesTable", table);
		request.setAttribute("professor", professor);
		request.setAttribute("types", types);
		return true;
	}

	/**
	 * @param universityId
	 *            university id
	 * @param courseId
	 *            university id
	 * @param request
	 *            request
	 * @return if the setup was successful
	 */
	public boolean handle(final long universityId, final long courseId, final HttpServletRequest request)
	{

		Course course = courseDAO.getById(courseId);
		if (course == null)
		{
			System.out.println("Course doesn't exist");
			return false;
		}

		NewCourseProfessorEntity entity = new NewCourseProfessorEntity();
		entity.setup(request);
		if (!entity.isValid())
		{
			entity.setupErrorsDisplay(request);
			entity.setupForDisplay(request);
			return false;
		}
		long professorId = Long.parseLong(entity.getProfessorId());
		int year = Integer.parseInt(entity.getYear());
		long semesterId = Long.parseLong(entity.getSemesterId());

		Semester semester = semesterDAO.getById(Long.parseLong(entity.getSemesterId()));
		Professor professor = professorDAO.getById(professorId);
		if (semester == null)
		{
			FormErrorHandler.getFormErrorHandler(request).addError(NewCourseProfessorEntity.class, "err_semester");
			return false;
		}

		if (professor == null)
		{
			FormErrorHandler.getFormErrorHandler(request).addError(NewCourseProfessorEntity.class, "err_professor");

			return false;
		}
		CourseProfessor courseProfessor = courseProfessorDAO.getByProfessorAndCourse(courseId, professorId);
		if (courseProfessor == null)
		{
			courseProfessor = new CourseProfessor();
			courseProfessor.setProfessor(professor);
			courseProfessor.setCourse(course);
			courseProfessorDAO.add(courseProfessor);
		} else
		{

			if (courseProfessorPeriodDAO.periodExist(courseProfessor, semesterId, year))
			{
				FormErrorHandler.getFormErrorHandler(request).addError(NewCourseProfessorEntity.class,
						"err_prof_already_doing_course_period");
				return false;
			}
		}
		CourseProfessorPeriod period = new CourseProfessorPeriod();
		period.setCourseProfessor(courseProfessor);
		period.setYear(year);
		period.setSemester(semester);
		courseProfessor.getPeriods().add(period);
		courseProfessorDAO.saveOrUpdate(courseProfessor);
		return true;
	}

	/**
	 * @param universityId
	 *            university id
	 * @param courseId
	 *            university id
	 * @param request
	 *            request
	 * @return if the setup was successful
	 */
	public boolean setupNewCourseProfessorPage(final long universityId, final long courseId,
			final HttpServletRequest request)
	{
		University university = universityDAO.getById(courseId);
		if (university == null)
		{
			System.out.println("University doesn't exist");
			return false;
		}

		Course course = courseDAO.getById(courseId);
		if (course == null)
		{
			System.out.println("Course doesn't exist");
			return false;
		}

		request.setAttribute("course", course);

		List<Semester> semesters = semesterDAO.list();
		request.setAttribute("semesters", semesters);
		return true;
	}

}

/**
 * 
 */
package ca.bendo.taglib.tag.card.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.course.CourseProfessorDAO;
import ca.bendo.db.dao.professor.ProfessorDAO;
import ca.bendo.db.dao.professor.ProfessorUniversityDAO;
import ca.bendo.db.entity.course.CourseProfessor;
import ca.bendo.db.entity.professor.Professor;
import ca.bendo.db.entity.professor.ProfessorUniversity;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ProfessorCardHandler</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class ProfessorCardHandler implements CardHandler
{
	/**
	 * 
	 */
	@Autowired
	private ProfessorDAO professorDAO;

	/**
	 * 
	 */
	@Autowired
	private ProfessorUniversityDAO professorUniversityDAO;

	/**
	 * 
	 */
	@Autowired
	private CourseProfessorDAO courseProfessorDAO;

	/**
	 * 
	 * @param request
	 *            request
	 * 
	 * @param professorId
	 *            ProfessorId
	 */
	public void setup(final HttpServletRequest request, final long professorId)
	{
		Professor professor = professorDAO.getById(professorId);
		List<ProfessorUniversity> universities = professorUniversityDAO.listProfessorUniversity(professor.getId());
		List<CourseProfessor> courses = courseProfessorDAO.listProfessorCourse(professor.getId());

		request.setAttribute("profcard_professor", professor);
		request.setAttribute("profcard_universities", universities);
		request.setAttribute("profcard_courses", courses);
	}
}

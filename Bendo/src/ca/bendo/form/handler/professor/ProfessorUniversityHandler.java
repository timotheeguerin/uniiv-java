/**
 * 
 */
package ca.bendo.form.handler.professor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.professor.ProfessorDAO;
import ca.bendo.db.dao.professor.ProfessorRatingDAO;
import ca.bendo.db.dao.professor.ProfessorRatingTypeDAO;
import ca.bendo.db.dao.professor.ProfessorUniversityDAO;
import ca.bendo.db.dao.university.UniversityDAO;
import ca.bendo.db.entity.lang.Language;
import ca.bendo.db.entity.professor.Professor;
import ca.bendo.db.entity.professor.ProfessorRatingAverage;
import ca.bendo.db.entity.professor.ProfessorRatingType;
import ca.bendo.db.entity.professor.ProfessorUniversity;
import ca.bendo.db.entity.university.University;
import ca.bendo.form.FieldValidator;
import ca.bendo.form.entity.professor.NewProfessorUniversityEntity;
import ca.bendo.translation.translation.Translator;
import ca.bendo.views.list.ProfessorListElement;
import ca.bendo.views.table.professor.ProfessorTable;
import ca.bendo.views.table.professor.ProfessorTableRow;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ProfessorUniversityHandler</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class ProfessorUniversityHandler
{

	/**
	 * 
	 */
	private static final int MAX_PROF_RESULT = 20;

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
	private ProfessorRatingTypeDAO professorRatingTypeDAO;

	/**
	 * 
	 */
	@Autowired
	private ProfessorRatingDAO professorRatingDAO;

	/**
	 * 
	 */
	@Autowired
	private ProfessorUniversityDAO professorUniversityDAO;

	/**
	 * @param universityId
	 *            university id
	 * @param request
	 *            request
	 * @return if the setup was successful
	 */
	public boolean setupProfessorInUniversityPage(final long universityId, final HttpServletRequest request)
	{
		Translator translator = (Translator) request.getAttribute("translator");
		Long languageId = Language.load(request);
		University university = universityDAO.getById(universityId);
		if (university == null)
		{
			return false;
		}

		String pageStr = request.getParameter("page");
		int page = 0;
		if (FieldValidator.isInt(pageStr))
		{
			page = Integer.parseInt(pageStr);
		}

		List<ProfessorUniversity> professors = professorUniversityDAO.listProfessorAtUniversity(universityId, page
				* MAX_PROF_RESULT, MAX_PROF_RESULT);

		List<ProfessorRatingType> types = professorRatingTypeDAO.listProfessorRatingType();
		ProfessorTable table = new ProfessorTable(types);

		for (ProfessorUniversity professor : professors)
		{
			String link = translator.translateUrl("/professor/" + professor.getProfessor().getId(), languageId);
			ProfessorListElement element = new ProfessorListElement();
			ProfessorRatingAverage ratings = professorRatingDAO.getProfessorRatingsMean(professor.getProfessor()
					.getId());
			ProfessorTableRow row = (ProfessorTableRow) table.createRow(ProfessorTableRow.class, link);
			row.setup(professor.getProfessor(), ratings, types);

		}

		request.setAttribute("professorsTable", table);
		request.setAttribute("university", university);
		request.setAttribute("types", types);
		return true;
	}

	/**
	 * @param professorId
	 *            university id
	 * @param request
	 *            request
	 * @return if the setup was successful
	 */
	public boolean setupProfessorUniversityPage(final long professorId, final HttpServletRequest request)
	{
		Professor professor = professorDAO.getById(professorId);
		if (professor == null)
		{
			return false;
		}

		List<ProfessorUniversity> universities = professorUniversityDAO.listProfessorUniversity(professorId);
		List<University> universityList = new ArrayList<University>();
		for (ProfessorUniversity uni : universities)
		{
			universityList.add(uni.getUniversity());
		}
		request.setAttribute("universities", universityList);
		request.setAttribute("professor", professor);
		return true;
	}

	/**
	 * @param professorId
	 *            Professor Id
	 * @param request
	 *            request
	 * @return boolean if the request was successful
	 */
	public boolean handle(final String professorId, final HttpServletRequest request)
	{
		System.out.println("UNIID: " + request.getParameter("universityId"));
		NewProfessorUniversityEntity entity = new NewProfessorUniversityEntity();
		entity.setup(request);
		if (!entity.isValid())
		{
			entity.setupErrorsDisplay(request);
			return false;
		}

		// Check the parameters are good
		if (!(FieldValidator.isInt(professorId)))
		{
			return false;
		}
		long universityId = Long.parseLong(entity.getUniversityId());
		if (professorUniversityDAO.professorIsAtUniversity(Long.parseLong(professorId), universityId))
		{
			return false;
		}
		University university = universityDAO.getById(universityId);
		Professor professor = professorDAO.getById(Long.parseLong(professorId));
		if (university == null || professor == null)
		{
			return false;
		}

		ProfessorUniversity professorUniversity = new ProfessorUniversity();
		professorUniversity.setProfessor(professor);
		professorUniversity.setUniversity(university);

		professorUniversityDAO.add(professorUniversity);
		return true;
	}

	/**
	 * @param professorId
	 *            university id
	 * @param request
	 *            request
	 * @return if the setup was successful
	 */
	public boolean setupNewProfessorUniversityPage(final long professorId, final HttpServletRequest request)
	{
		Professor professor = professorDAO.getById(professorId);
		if (professor == null)
		{
			System.out.println("Professor doesn't exist");
			return false;
		}

		request.setAttribute("professor", professor);
		if (professorUniversityDAO.listProfessorUniversity(professorId).size() > 0)
		{
			System.out.println("Prof already has a university!");
			request.setAttribute("newProfUniCaptcha", true);
		}
		List<University> universities = universityDAO.listUniversities();
		request.setAttribute("universities", universities);
		return true;
	}
}

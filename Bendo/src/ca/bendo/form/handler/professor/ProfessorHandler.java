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
import ca.bendo.db.dao.professor.ProfessorReviewDAO;
import ca.bendo.db.dao.professor.ProfessorUniversityDAO;
import ca.bendo.db.dao.program.UniversityProgramDAO;
import ca.bendo.db.entity.lang.Language;
import ca.bendo.db.entity.professor.Professor;
import ca.bendo.db.entity.professor.ProfessorRatingAverage;
import ca.bendo.db.entity.professor.ProfessorRatingType;
import ca.bendo.db.entity.professor.ProfessorReview;
import ca.bendo.db.entity.professor.ProfessorUniversity;
import ca.bendo.db.entity.program.UniversityProgram;
import ca.bendo.db.entity.university.University;
import ca.bendo.form.FieldValidator;
import ca.bendo.form.entity.professor.NewProfessorEntity;
import ca.bendo.json.AutoCompleteJson;
import ca.bendo.json.Suggestion;
import ca.bendo.translation.translation.Translator;
import ca.bendo.views.Link;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ProfessorNewHandler</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class ProfessorHandler
{
	/**
	 * The maximum number of reviews on the professor page.
	 */
	private static final int PROF_PAGE_MAX_REVIEW = 5;

	/**
	 * Maximum number of university to display on the professor page.
	 */
	private static final int PROF_PAGE_MAX_UNI = 3;

	/**
	 * 
	 */
	private static final int MAX_PROF_AUTOCOMPLETE = 10;

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
	private ProfessorReviewDAO professorReviewDAO;
	/**
	 * 
	 */
	@Autowired
	private UniversityProgramDAO programDAO;

	/**
	 * 
	 */
	@Autowired
	private ProfessorUniversityDAO professorUniversityDAO;

	/**
	 * 
	 * @param request
	 *            request
	 * @return boolean if the professor could be added
	 */
	public Professor handleNewProfessor(final HttpServletRequest request)
	{
		NewProfessorEntity entity = new NewProfessorEntity();
		entity.setup(request);
		if (!entity.isValid())
		{
			entity.setupErrorsDisplay(request);
			entity.setupForDisplay(request);
			request.setAttribute("newProfEntity", entity);
			return null;
		}

		Professor professor = new Professor();
		professor.setFirstName(entity.getFirstName());
		professor.setLastName(entity.getLastName());

		long programId = Long.parseLong(entity.getProgramId());
		UniversityProgram program = programDAO.getById(programId);
		professor.setProgram(program);
		professorDAO.add(professor);
		System.out.println(professor.getId() + ": " + professor.getFirstName() + " " + professor.getLastName());
		return professor;
	}

	/**
	 * @param request
	 *            request
	 */
	public void setupNewProfessorPage(final HttpServletRequest request)
	{
		Translator translator = (Translator) request.getAttribute("translator");
		Long languageId = Language.load(request);
		programDAO.setLanguageId(languageId);
		List<UniversityProgram> programs = programDAO.listPrograms();
		request.setAttribute("programs", programs);

	}

	/**
	 * @param professorId
	 *            Professor id
	 * @param request
	 *            Request
	 * @return boolean
	 */
	public boolean setupProfessorPage(final long professorId, final HttpServletRequest request)
	{

		Translator translator = (Translator) request.getAttribute("translator");
		Long languageId = Language.load(request);
		professorDAO.setLanguageId(languageId);
		Professor professor = professorDAO.getById(professorId);

		if (professor == null)
		{
			return false;
		}

		ProfessorRatingAverage profRating = professorRatingDAO.getProfessorRatingsMean(professor.getId());

		request.setAttribute("professor", professor);
		request.setAttribute("profRatings", profRating);
		professorRatingTypeDAO.setLanguageId(languageId);
		List<ProfessorRatingType> types = professorRatingTypeDAO.listProfessorRatingType();
		request.setAttribute("types", types);

		List<ProfessorUniversity> universities = professorUniversityDAO.listProfessorUniversity(professorId,
				PROF_PAGE_MAX_UNI);

		List<University> universityList = new ArrayList<University>();
		for (ProfessorUniversity uni : universities)
		{
			universityList.add(uni.getUniversity());
		}
		request.setAttribute("universities", universityList);

		//Load the last 5 reviews
		List<ProfessorReview> reviews = professorReviewDAO.listLastProfessorReview(professorId, PROF_PAGE_MAX_REVIEW);
		request.setAttribute("reviews", reviews);
		setupProfessorLinks(professorId, request);

		return true;
	}

	/**
	 * @param professorId
	 *            Professor id
	 * @param request
	 *            Request
	 */
	private void setupProfessorLinks(final long professorId, final HttpServletRequest request)
	{
		Translator translator = (Translator) request.getAttribute("translator");
		List<Link> links = new ArrayList<Link>();

		String url = "";
		// Professor at univeristies
		url = "/professor/" + professorId + "/universities";
		links.add(new Link(request, "prof_at_universities", url));

		// Add a new university to prof
		url = "/professor/" + professorId + "/university/add";
		links.add(new Link(request, "prof_add_new_university", url));
		request.setAttribute("links", links);

	}

	/**
	 * @param request
	 *            request
	 * @return json object
	 */
	public AutoCompleteJson setupAjaxList(final HttpServletRequest request)
	{
		String query = request.getParameter("query");
		String universityId = request.getParameter("universityId");

		AutoCompleteJson autoCompleteJson = new AutoCompleteJson();
		autoCompleteJson.setQuery(query);
		if (universityId == null || universityId.equals(""))
		{
			List<Professor> professors = professorDAO.listProfessorLikeMaxResults(query, MAX_PROF_AUTOCOMPLETE);
			for (Professor professor : professors)
			{
				String name = professor.getFirstName() + " " + professor.getLastName();
				String id = String.valueOf(professor.getId());
				Suggestion sug = new Suggestion(name, id);
				autoCompleteJson.getSuggestions().add(sug);
			}
		} else if (FieldValidator.isInt(universityId))
		{
			List<ProfessorUniversity> professors = professorUniversityDAO.listProfessorInUniversityLikeMaxResults(
					Long.parseLong(universityId), query, MAX_PROF_AUTOCOMPLETE);
			for (ProfessorUniversity professor : professors)
			{
				String name = professor.getProfessor().getFirstName() + " " + professor.getProfessor().getLastName();
				String id = String.valueOf(professor.getProfessor().getId());
				Suggestion sug = new Suggestion(name, id);
				autoCompleteJson.getSuggestions().add(sug);
			}

		}
		return autoCompleteJson;
	}
}

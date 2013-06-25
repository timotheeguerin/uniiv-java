/**
 * 
 */
package ca.bendo.page.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.university.UniversityDAO;
import ca.bendo.db.dao.university.UniversityQuery;
import ca.bendo.db.dao.university.UniversityReviewDAO;
import ca.bendo.db.entity.university.University;
import ca.bendo.db.entity.university.UniversityReview;
import ca.bendo.json.AutoCompleteJson;
import ca.bendo.json.Suggestion;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UniversityPageHandler</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class UniversityTDS
{
	/**
	 * 
	 */
	private static final int MAX_UNI_REVIEW = 5;

	/**
	 * 
	 */
	@Autowired
	private UniversityDAO universityDAO;

	/**
	 * 
	 */
	@Autowired
	private UniversityReviewDAO universityReviewDAO;

	/**
	 * 
	 */
	private long languageId;

	/**
	 * 
	 * @param universityId
	 *            Parameter string with the university id;
	 * @return the university with the given id
	 */
	public University loadUniversity(final long universityId)
	{
		universityDAO.setLanguageId(languageId);

		return universityDAO.getById(universityId);

	}

	/**
	 * 
	 * @param universityId
	 *            Parameter string with the university id;
	 * @param request
	 *            Request
	 * @return the university with the given id
	 */
	public University setupUniversityPage(final long universityId, final HttpServletRequest request)
	{
		universityDAO.setLanguageId(languageId);
		List<UniversityReview> reviews = universityReviewDAO.listLastUniversityReview(universityId, MAX_UNI_REVIEW);
		University university = universityDAO.getById(universityId);
		request.setAttribute("university", university);
		request.setAttribute("reviews", reviews);
		return university;

	}

	/**
	 * 
	 * @param query
	 *            University Query
	 * @return list of university satifying
	 */
	public List<University> searchUniversity(final UniversityQuery query)
	{
		universityDAO.setLanguageId(languageId);

		return universityDAO.filter(query);
	}

	/**
	 * @param request
	 *            Request
	 * @return university list in json format
	 */
	public AutoCompleteJson setupAjaxList(final HttpServletRequest request)
	{
		String universityName = request.getParameter("query");
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
			Suggestion sug = new Suggestion(university.getName(), String.valueOf(university.getId()));
			autoCompleteJson.getSuggestions().add(sug);
		}

		return autoCompleteJson;

	}

	/**
	 * @return the languageId
	 */
	public long getLanguageId()
	{
		return languageId;
	}

	/**
	 * @param l
	 *            the languageId to set
	 */
	public void setLanguageId(final long l)
	{
		this.languageId = l;
	}

}

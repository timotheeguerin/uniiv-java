/**
 * 
 */
package ca.bendo.search.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.rating.SoftRatingDAO;
import ca.bendo.db.dao.university.UniversityDAO;
import ca.bendo.db.dao.university.UniversityQuery;
import ca.bendo.db.entity.lang.Language;
import ca.bendo.db.entity.university.University;
import ca.bendo.search.handler.parser.LocationParser;
import ca.bendo.search.handler.parser.ProgramParser;
import ca.bendo.search.handler.parser.SoftRatingParser;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>SearchQueryHandler</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class SearchQueryHandler
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
	private SoftRatingDAO softRatingDAO;

	/**
	 * 
	 * @param request
	 *            Request object
	 */
	public void handle(final HttpServletRequest request)
	{
		Translator translator = (Translator) request.getAttribute("translator");
		Long languageId = Language.load(request);
		UniversityQuery query = new UniversityQuery();

		// Parse location
		String countriesParam = request.getParameter("location");
		LocationParser locationParser = new LocationParser();
		locationParser.parse(countriesParam);
		query.setCountries(locationParser.getCountries());

		// Parse programs
		String programParam = request.getParameter("program");
		ProgramParser programParser = new ProgramParser();
		programParser.parse(programParam);
		query.setFaculties(programParser.getFaculties());

		// Parse softRatings
		String ratingParam = request.getParameter("ratings");
		SoftRatingParser softRatingParser = new SoftRatingParser();
		softRatingParser.parse(ratingParam);
		// //Map<Integer, Integer> ratingIdsMap =
		// softRatingParser.getSoftRatings();
		//
		// List<SoftRating> ratingsList =
		// softRatingDAO.listSoftRatingsWithIds(ratingIdsMap.keySet());
		// Map<SoftRating, Integer> ratingsMap = new HashMap<SoftRating,
		// Integer>();
		// for (SoftRating rating : ratingsList)
		// {
		// ratingsMap.put(rating, ratingIdsMap.get(rating.getId()));
		// }
		// query.setSoftRatings(ratingsMap);

		universityDAO.setLanguageId(languageId);
		List<University> universities = universityDAO.search(query);
		request.setAttribute("universities", universities);
		System.out.println("UNI SIZE: " + universities.size());
	}
}

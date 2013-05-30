/**
 * 
 */
package ca.bendo.search;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.fees.UniFeesDAO;
import ca.bendo.db.dao.location.CountryDAO;
import ca.bendo.db.dao.location.StateDAO;
import ca.bendo.db.dao.program.UniversityFacultyDAO;
import ca.bendo.db.dao.rating.SoftRatingDAO;
import ca.bendo.db.entity.lang.Language;
import ca.bendo.db.entity.location.Country;
import ca.bendo.db.entity.location.State;
import ca.bendo.db.entity.program.UniversityFaculty;
import ca.bendo.db.entity.program.UniversityProgram;
import ca.bendo.db.entity.rating.UniversityRating;
import ca.bendo.search.category.FeesCategoryContent;
import ca.bendo.search.category.FilterCategory;
import ca.bendo.search.category.SelectListFilterContent;
import ca.bendo.search.softrating.SoftRatingCategoryContent;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>FilterSystemFilter</b>
 *          <p>
 *          Load all the filters
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class FilterSystemLoader
{
	/**
	 * 
	 */
	@Autowired
	private Translator translator;

	/**
	 * 
	 */
	private FilterSystem sys;

	/**
	 * 
	 */
	@Autowired
	private CountryDAO countryDAO;

	/**
	 * 
	 */
	@Autowired
	private UniversityFacultyDAO facultyDAO;

	/**
	 * 
	 */
	@Autowired
	private UniFeesDAO feesDAO;

	/**
	 * 
	 */
	@Autowired
	private SoftRatingDAO softRatingDAO;

	/**
	 * 
	 */
	@Autowired
	private StateDAO stateDAO;

	/**
	 * @param request
	 *            Request
	 */
	public void loadFilters(final HttpServletRequest request)
	{
		sys = new FilterSystem();
		translator = (Translator) request.getAttribute("translator");

		loadCountries(request);
		loadFees(request);
		loadPrograms(request);

		loadSoftRatings(request);
		request.setAttribute("filters", sys);
	}

	/**
	 * Load the countries.
	 * 
	 * @param request
	 *            Request
	 */
	private void loadCountries(final HttpServletRequest request)
	{
		Long languageId = Language.loadId(request);
		FilterCategory countryCategory = new FilterCategory();

		SelectListFilterContent countryCategoryContent = new SelectListFilterContent();

		countryCategory.setContent(countryCategoryContent);

		// Load all the countries
		countryDAO.setLanguageId(languageId);
		List<Country> countries = countryDAO.listCountries();
		// Cycle through
		for (Country country : countries)
		{
			// Set the filter element to be the country
			FilterElement countryElement = new FilterElement();
			countryElement.setCustomClass("Country");
			countryElement.setName(country.toString());
			countryElement.setId(country.getId());
			countryElement.setImage("/images/category/country/flag/" + country.getCountry() + ".png");

			// Load the state of the country and cycle through
			for (State state : country.getStates())
			{
				// Add a sub element to be the state.
				FilterElement stateElement = new FilterElement();
				stateElement.setCustomClass("State");
				stateElement.setName(state.toString());
				stateElement.setId(state.getId());
				stateElement.setImage("/images/category/country/flag/" + country.getCountry() + ".png");

				countryElement.addSubElement(stateElement);
			}
			countryCategoryContent.addSubElement(countryElement);

		}
		countryCategory.setName(translator.translate("location", languageId));
		countryCategory.setImage("/images/category/location.png");

		sys.addCategory(countryCategory);

	}

	/**
	 * Load the fees.
	 * 
	 * @param request
	 *            request
	 */
	private void loadFees(final HttpServletRequest request)
	{
		Long languageId = Language.loadId(request);
		FilterCategory feesCategory = new FilterCategory();
		FeesCategoryContent feesContent = new FeesCategoryContent();
		feesContent.setCurrencies(feesDAO.listCurrencies());

		feesCategory.setName(translator.translate("fees", languageId));
		feesCategory.setImage("/images/category/uniFees.png");
		feesCategory.setContent(feesContent);
		sys.addCategory(feesCategory);
	}

	/**
	 * Load the programs.
	 * 
	 * @param request
	 *            request
	 */
	private void loadPrograms(final HttpServletRequest request)
	{
		Long languageId = Language.loadId(request);
		FilterCategory programCategory = new FilterCategory();
		SelectListFilterContent programCategoryContent = new SelectListFilterContent();
		programCategory.setContent(programCategoryContent);
		// Load all the programs
		facultyDAO.setLanguageId(languageId);
		List<UniversityFaculty> faculties = facultyDAO.list();
		// Cycle through
		for (UniversityFaculty faculty : faculties)
		{
			// Set the filter element to be the country
			FilterElement facultyElement = new FilterElement();
			facultyElement.setName(faculty.toString());
			facultyElement.setCustomClass("Faculty");
			facultyElement.setId(faculty.getId());

			// Load the state of the country and cycle through
			for (UniversityProgram program : faculty.getPrograms())
			{
				// Add a sub element to be the state.
				FilterElement programElement = new FilterElement();
				programElement.setCustomClass("Program");
				programElement.setName(program.toString());
				programElement.setId(program.getId());

				facultyElement.addSubElement(programElement);
			}

			programCategoryContent.addSubElement(facultyElement);
		}
		programCategory.setName(translator.translate("programs", languageId));
		programCategory.setImage("/images/category/programs.png");

		sys.addCategory(programCategory);

	}

	/**
	 * Load all the soft filters.
	 * 
	 * @param request
	 *            request
	 */
	private void loadSoftRatings(final HttpServletRequest request)
	{
		Long languageId = Language.loadId(request);
		FilterCategory softRatingFilterCategory = new FilterCategory();
		SoftRatingCategoryContent content = new SoftRatingCategoryContent();
		softRatingDAO.setLanguageId(languageId);

		// Load all the ratings
		List<UniversityRating> ratings = softRatingDAO.listSoftRatings();
		List<UniversityRating> stdRatings = new ArrayList<UniversityRating>();
		List<UniversityRating> officialRatings = new ArrayList<UniversityRating>();

		for (UniversityRating rating : ratings)
		{
			if (rating.getType().getName().equalsIgnoreCase("standard"))
			{
				stdRatings.add(rating);
			} else
			{
				officialRatings.add(rating);
			}
		}

		content.setStdRatings(stdRatings);
		content.setOfficialRatings(officialRatings);

		softRatingFilterCategory.setName(translator.translate("softfilters", languageId));

		softRatingFilterCategory.setContent(content);
		sys.setSoftrating(softRatingFilterCategory);

	}

}

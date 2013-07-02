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
import ca.bendo.db.entity.program.Program;
import ca.bendo.db.entity.program.UniversityFaculty;
import ca.bendo.db.entity.rating.UniversityRating;
import ca.bendo.db.entity.rating.UniversityRatingMethodElement;
import ca.bendo.search.category.FeesCategoryContent;
import ca.bendo.search.category.FilterButton;
import ca.bendo.search.category.FilterSection;
import ca.bendo.search.category.FilterSectionSubSection;
import ca.bendo.search.category.FilterSectionTabs;
import ca.bendo.search.category.SelectListFilterContent;
import ca.bendo.search.softrating.SectionContentRadioButton;
import ca.bendo.search.softrating.SectionContentSimpleCheckBox;
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
		FilterSystem sys = new FilterSystem();
		translator = (Translator) request.getAttribute("translator");

		sys.addCategory(loadTopSection(request));
		sys.addCategory(loadCampus(request));
		sys.addCategory(loadWeather(request));
		sys.addCategory(loadSoftRatings(request));

		loadSoftRatings(request);
		request.setAttribute("filters", sys);
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @return bullshit
	 */
	public FilterSection loadTopSection(final HttpServletRequest request)
	{
		Long languageId = Language.loadId(request);
		FilterSection filterSection = new FilterSection();
		filterSection.setName(translator.translate("big_search_filter", languageId));
		FilterSectionTabs content = new FilterSectionTabs();
		content.getTabs().put("location", loadCountries(request));
		content.getTabs().put("fees", loadFees(request));
		content.getTabs().put("field_study", loadPrograms(request));
		filterSection.setContent(content);
		return filterSection;
	}

	/**
	 * Load the countries.
	 * 
	 * @param request
	 *            Request
	 * @return content
	 */
	private SelectListFilterContent loadCountries(final HttpServletRequest request)
	{
		Long languageId = Language.loadId(request);

		SelectListFilterContent countryCategoryContent = new SelectListFilterContent();
		countryCategoryContent.setName("location");
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

		return countryCategoryContent;

	}

	/**
	 * Load the fees.
	 * 
	 * @param request
	 *            request
	 * @return content
	 */
	private FeesCategoryContent loadFees(final HttpServletRequest request)
	{
		Long languageId = Language.loadId(request);
		FeesCategoryContent feesContent = new FeesCategoryContent();
		feesContent.setCurrencies(feesDAO.listCurrencies());

		return feesContent;
	}

	/**
	 * Load the programs.
	 * 
	 * @param request
	 *            request
	 * @return content
	 */
	private SelectListFilterContent loadPrograms(final HttpServletRequest request)
	{
		Long languageId = Language.loadId(request);
		FilterSection programCategory = new FilterSection();
		SelectListFilterContent programCategoryContent = new SelectListFilterContent();
		programCategoryContent.setName("program");
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
			for (Program program : faculty.getPrograms())
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
		return programCategoryContent;

	}

	/**
	 * Load all the soft filters.
	 * 
	 * @param request
	 *            request
	 * @return section
	 */
	private FilterSection loadCampus(final HttpServletRequest request)
	{
		Long languageId = Language.loadId(request);
		FilterSection section = new FilterSection();
		SectionContentRadioButton sizeContent = new SectionContentRadioButton();
		sizeContent.setName("campus_size");
		SectionContentRadioButton envContent = new SectionContentRadioButton();
		envContent.setName("campus_env");
		softRatingDAO.setLanguageId(languageId);

		// Load all the ratings
		List<UniversityRating> ratings = softRatingDAO.list();

		List<FilterButton> sizeBoxes = new ArrayList<FilterButton>();
		List<FilterButton> envBoxes = new ArrayList<FilterButton>();

		for (UniversityRating rating : ratings)
		{
			if (rating.getType().getName().equalsIgnoreCase("size"))
			{
				for (UniversityRatingMethodElement element : rating.getType().getElements())
				{
					FilterButton box = new FilterButton();
					box.setValue(element.getId());
					box.setText(element.getTranslation());
					box.setImage("");
					sizeBoxes.add(box);
				}
			} else if (rating.getType().getName().equalsIgnoreCase("environment"))
			{
				for (UniversityRatingMethodElement element : rating.getType().getElements())
				{
					FilterButton box = new FilterButton();
					box.setValue(element.getId());
					box.setText(element.getTranslation());
					box.setImage("");
					envBoxes.add(box);
				}
			}
		}

		sizeContent.setBoxes(sizeBoxes);
		envContent.setBoxes(envBoxes);
		FilterSectionSubSection content = new FilterSectionSubSection();
		content.getSections().add(sizeContent);
		content.getSections().add(envContent);

		section.setName(translator.translate("campus", languageId));

		section.setContent(content);
		return section;

	}

	/**
	 * Load all the soft filters.
	 * 
	 * @param request
	 *            request
	 * @return section
	 */
	private FilterSection loadWeather(final HttpServletRequest request)
	{
		Long languageId = Language.loadId(request);
		FilterSection section = new FilterSection();
		SectionContentRadioButton content = new SectionContentRadioButton();
		content.setName("weather");
		softRatingDAO.setLanguageId(languageId);

		// Load all the ratings
		List<UniversityRating> ratings = softRatingDAO.list();
		List<FilterButton> boxes = new ArrayList<FilterButton>();

		for (UniversityRating rating : ratings)
		{
			if (rating.getType().getName().equalsIgnoreCase("weather"))
			{
				for (UniversityRatingMethodElement element : rating.getType().getElements())
				{
					FilterButton box = new FilterButton();
					box.setValue(element.getId());
					box.setText(element.getTranslation());
					box.setImage("");
					boxes.add(box);
				}
			}
		}

		content.setBoxes(boxes);

		section.setName(translator.translate("weather", languageId));

		section.setContent(content);
		return section;

	}

	/**
	 * Load all the soft filters.
	 * 
	 * @param request
	 *            request
	 * @return section
	 */
	private FilterSection loadSoftRatings(final HttpServletRequest request)
	{
		Long languageId = Language.loadId(request);
		FilterSection softRatingFilterCategory = new FilterSection();
		SectionContentSimpleCheckBox content = new SectionContentSimpleCheckBox();
		content.setName("rating");
		softRatingDAO.setLanguageId(languageId);

		// Load all the ratings
		List<UniversityRating> ratings = softRatingDAO.list();
		List<FilterButton> boxes = new ArrayList<FilterButton>();

		for (UniversityRating rating : ratings)
		{
			if (rating.getType().getName().equalsIgnoreCase("standard"))
			{
				FilterButton box = new FilterButton();
				box.setValue(rating.getId());
				box.setText(rating.getTranslation());
				box.setImage("");
				boxes.add(box);
			}
		}

		content.setBoxes(boxes);

		softRatingFilterCategory.setName(translator.translate("softfilters", languageId));

		softRatingFilterCategory.setContent(content);
		return softRatingFilterCategory;

	}

}

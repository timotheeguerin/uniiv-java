/**
 * 
 */
package ca.bendo.forum;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.forum.ForumGroupDAO;
import ca.bendo.db.dao.forum.TagDAO;
import ca.bendo.db.dao.forum.mapping.CityGroupDAO;
import ca.bendo.db.dao.forum.mapping.CountryGroupDAO;
import ca.bendo.db.dao.forum.mapping.UniversityGroupDAO;
import ca.bendo.db.dao.location.CityDAO;
import ca.bendo.db.dao.location.CountryDAO;
import ca.bendo.db.dao.university.UniversityDAO;
import ca.bendo.db.entity.forum.ForumGroup;
import ca.bendo.db.entity.forum.mapping.CityGroup;
import ca.bendo.db.entity.forum.mapping.CountryGroup;
import ca.bendo.db.entity.forum.mapping.UniversityGroup;
import ca.bendo.db.entity.location.City;
import ca.bendo.db.entity.location.Country;
import ca.bendo.db.entity.university.University;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ForumGroupCleaner</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class ForumGroupCleaner
{
	/**
	 * 
	 */
	@Autowired
	private ForumGroupDAO groupDAO;

	/**
	 * 
	 */
	@Autowired
	private TagDAO tagDAO;

	/**
	 * 
	 */
	@Autowired
	private UniversityDAO universityDAO;

	/**
	 * 
	 */
	@Autowired
	private CityDAO cityDAO;

	/**
	 * 
	 */
	@Autowired
	private CountryDAO countryDAO;

	/**
	 * 
	 */
	@Autowired
	private UniversityGroupDAO universityGroupDAO;

	/**
	 * 
	 */
	@Autowired
	private CityGroupDAO cityGroupDAO;

	/**
	 * 
	 */
	@Autowired
	private CountryGroupDAO countryGroupDAO;

	/**
	 * 
	 */
	public void setupRootGroups()
	{
		setupGroup("location", "location");
	}

	/**
	 * @param groupName
	 *            GroupName
	 * @param tagName
	 *            tags
	 */
	public void setupGroup(final String groupName, final String tagName)
	{
		ForumGroup group = groupDAO.getByName(groupName);
		if (group == null)
		{
			group = new ForumGroup();
			group.setName(groupName);
			group.getTags().add(tagDAO.getTag(tagName));
			groupDAO.saveOrUpdate(group);
		}
	}

	/**
	 * Check all the university groups.
	 * 
	 * @return return if there was a modification to make
	 */
	public boolean checkAllUniversityGroup()
	{
		List<University> universities = universityDAO.list();
		boolean result = false;
		for (University university : universities)
		{
			if (checkUniversityGroup(university))
			{
				result = true;
			}
		}
		return result;
	}

	/**
	 * 
	 * @param university
	 *            University
	 * @return return if the university group was missing or needed to be
	 *         modified
	 */
	public boolean checkUniversityGroup(final University university)
	{
		boolean modified = false;
		UniversityGroup groupLink = universityGroupDAO.getById(university.getId());
		if (groupLink == null)
		{
			modified = true;
			groupLink = new UniversityGroup();
			groupLink.setUniversityId(university.getId());
		}

		if (groupLink.getGroup() == null)
		{
			modified = true;
			ForumGroup group = new ForumGroup();
			group.setName(university.getName());
		}

		if (modified)
		{
			universityGroupDAO.saveOrUpdate(groupLink);
		}

		return modified;

	}

	/**
	 * 
	 * @param cityId
	 *            Id of the city
	 * @return return the city group with the given id
	 */
	public CityGroup getCityGroup(final long cityId)
	{
		CityGroup cityGroup = cityGroupDAO.getById(cityId);
		City city = cityDAO.getById(cityId);
		boolean modified = false;
		if (cityGroup == null)
		{
			modified = true;
			cityGroup = new CityGroup();
		}

		if (cityGroup.getGroup() == null)
		{
			ForumGroup group = new ForumGroup();
			group.setName(city.getName());
		}

		return cityGroup;
	}

	/**
	 * Create the group if its missing.
	 * 
	 * @param countryId
	 *            Id of the country
	 * @return return the ciuntry group with the given id
	 */
	public CountryGroup getCountryGroup(final long countryId)
	{
		CountryGroup countryGroup = countryGroupDAO.getById(countryId);
		Country country = countryDAO.getById(countryId);
		boolean modified = false;
		if (countryGroup == null)
		{
			modified = true;
			countryGroup = new CountryGroup();
		}

		if (countryGroup.getGroup() == null)
		{
			ForumGroup group = new ForumGroup();
			group.setName(country.getCountry());
			ForumGroup parent = groupDAO.getByName("location");
		}

		return countryGroup;
	}
}

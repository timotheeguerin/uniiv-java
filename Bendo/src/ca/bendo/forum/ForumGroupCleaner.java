/**
 * 
 */
package ca.bendo.forum;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.forum.mapping.UniversityGroupDAO;
import ca.bendo.db.dao.university.UniversityDAO;
import ca.bendo.db.entity.forum.ForumGroup;
import ca.bendo.db.entity.forum.mapping.UniversityGroup;
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
	private UniversityDAO universityDAO;

	/**
	 * 
	 */
	@Autowired
	private UniversityGroupDAO universityGroupDAO;

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
}

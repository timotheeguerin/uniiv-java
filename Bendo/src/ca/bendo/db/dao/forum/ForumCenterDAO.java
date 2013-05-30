/**
 * 
 */
package ca.bendo.db.dao.forum;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.forum.ForumCenter;
import ca.bendo.db.entity.forum.UniversityForumCenter;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ForumCenterDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class ForumCenterDAO extends HibernateDAO<ForumCenter>
{
	/**
	 * 
	 */
	public ForumCenterDAO()
	{
		setType(ForumCenter.class);
	}

	/**
	 * 
	 * @param universityId
	 *            Id of the university
	 * @return the forum center mapped to the given university
	 */
	public ForumCenter getUniversityForumCenter(final long universityId)
	{
		UniversityForumCenter link = (UniversityForumCenter) getSession().createCriteria(UniversityForumCenter.class)
				.add(Restrictions.eq("universsityId", universityId)).uniqueResult();
		return link.getCenter();
	}
}

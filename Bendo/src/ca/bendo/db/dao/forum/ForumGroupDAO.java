/**
 * 
 */
package ca.bendo.db.dao.forum;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.forum.ForumGroup;

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
public class ForumGroupDAO extends HibernateDAO<ForumGroup>
{
	/**
	 * Number of group to load for quick display.
	 */
	private static final int QUICK_DISPLAY_GROUP_NUM = 5;

	/**
	 * 
	 */
	public ForumGroupDAO()
	{
		setType(ForumGroup.class);
	}

	/**
	 * @param groupId
	 *            Group
	 * @return set of subgroups
	 */
	@SuppressWarnings("unchecked")
	public List<ForumGroup> getSubGroups(final long groupId)
	{
		return getSession().createCriteria(ForumGroup.class).add(Restrictions.eq("parent.id", groupId)).list();
	}

	/**
	 * @param groupId
	 *            Group
	 * @return set of subgroups
	 */
	@SuppressWarnings("unchecked")
	public List<ForumGroup> getQuickDisplaySubGroups(final long groupId)
	{
		return getSession().createCriteria(ForumGroup.class).add(Restrictions.eq("parent.id", groupId))
				.setMaxResults(QUICK_DISPLAY_GROUP_NUM).list();
	}

	/**
	 * @param name
	 *            group name
	 * @return forum group with the given name
	 */
	public ForumGroup getByName(final String name)
	{
		return (ForumGroup) getSession().createCriteria(ForumGroup.class).add(Restrictions.eq("name", name))
				.uniqueResult();
	}
}

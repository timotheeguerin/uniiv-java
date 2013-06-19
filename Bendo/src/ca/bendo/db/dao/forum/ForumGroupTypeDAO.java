/**
 * 
 */
package ca.bendo.db.dao.forum;

import java.util.List;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.forum.ForumGroupType;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ForumGroupTypeDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class ForumGroupTypeDAO extends HibernateDAO<ForumGroupType>
{
	/**
	 * 
	 */
	public ForumGroupTypeDAO()
	{
		setType(ForumGroupType.class);
	}

	/**
	 * 
	 * @param firstResult
	 *            First result
	 * @param maxResults
	 *            Max result
	 * @return list of forum result
	 */
	@SuppressWarnings("unchecked")
	public List<ForumGroupType> list(final int firstResult, final int maxResults)
	{
		return getSession().createCriteria(ForumGroupType.class).setFirstResult(firstResult).setMaxResults(maxResults)
				.list();
	}

	/**
	 * @param query
	 *            Query
	 * @param firstResult
	 *            First result
	 * @param maxResults
	 *            Max result
	 * @return list of forum result
	 */
	@SuppressWarnings("unchecked")
	public List<ForumGroupType> search(final String query, final int firstResult, final int maxResults)
	{
		return search("name", query, firstResult, maxResults);
	}

	/**
	 * @param query
	 *            to restrict
	 * @return the number of entity
	 */
	public long searchCount(final String query)
	{
		return searchCount("name", query);
	}
}

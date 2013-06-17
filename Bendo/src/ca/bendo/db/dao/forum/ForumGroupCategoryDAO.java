/**
 * 
 */
package ca.bendo.db.dao.forum;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.forum.ForumGroupCategory;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ForumGroupCategoryDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class ForumGroupCategoryDAO extends HibernateDAO<ForumGroupCategory>
{
	/**
	 * 
	 */
	public ForumGroupCategoryDAO()
	{
		setType(ForumGroupCategory.class);
	}
}

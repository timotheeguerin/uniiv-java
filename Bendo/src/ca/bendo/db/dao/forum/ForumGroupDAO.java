/**
 * 
 */
package ca.bendo.db.dao.forum;

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
	 * 
	 */
	public ForumGroupDAO()
	{
		setType(ForumGroup.class);
	}
}

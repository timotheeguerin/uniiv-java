/**
 * 
 */
package ca.bendo.db.dao.forum;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.forum.ForumReply;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ForumReplyDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class ForumReplyDAO extends HibernateDAO<ForumReply>
{
	/**
	 * 
	 */
	public ForumReplyDAO()
	{
		setType(ForumReply.class);
	}
}

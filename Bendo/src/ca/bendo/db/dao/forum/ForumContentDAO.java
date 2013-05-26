/**
 * 
 */
package ca.bendo.db.dao.forum;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.forum.ForumContent;

/**
 * @author Timoth�e Gu�rin
 * @version Bendo
 * 
 *          <b>ForumContentDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class ForumContentDAO extends HibernateDAO<ForumContent>
{
	/**
	 * 
	 */
	public ForumContentDAO()
	{
		setType(ForumContent.class);
	}
}

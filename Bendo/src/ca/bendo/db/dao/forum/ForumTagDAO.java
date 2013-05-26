/**
 * 
 */
package ca.bendo.db.dao.forum;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.forum.ForumTag;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ForumTagDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class ForumTagDAO extends HibernateDAO<ForumTag>
{
	/**
	 * 
	 */
	public ForumTagDAO()
	{
		setType(ForumTag.class);
	}
}

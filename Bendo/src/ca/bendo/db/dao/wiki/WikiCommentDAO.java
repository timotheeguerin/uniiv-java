/**
 * 
 */
package ca.bendo.db.dao.wiki;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.wiki.WikiComment;

/**
 * @author toby
 * @version Bendo
 * 
 *          <b>WikiDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class WikiCommentDAO extends HibernateDAO<WikiComment>
{
	/**
	 * 
	 */
	public WikiCommentDAO()
	{
		setType(WikiComment.class);
	}
}

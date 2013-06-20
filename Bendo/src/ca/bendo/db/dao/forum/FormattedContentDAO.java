/**
 * 
 */
package ca.bendo.db.dao.forum;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.forum.FormattedContent;

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
public class FormattedContentDAO extends HibernateDAO<FormattedContent>
{
	/**
	 * 
	 */
	public FormattedContentDAO()
	{
		setType(FormattedContent.class);
	}
}

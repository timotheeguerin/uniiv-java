/**
 * 
 */
package ca.bendo.db.dao.wiki;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.wiki.WikiRevision;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>WikiRevsionDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class WikiRevisionDAO extends HibernateDAO<WikiRevision>
{
	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.bendo.db.dao.HibernateDAO#init()
	 */
	@Override
	protected void init()
	{
		setType(WikiRevision.class);
	}
}

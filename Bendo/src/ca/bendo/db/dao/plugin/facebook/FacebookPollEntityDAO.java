/**
 * 
 */
package ca.bendo.db.dao.plugin.facebook;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.plugin.facebook.FacebookPollEntity;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>FacebookPollEntityManager</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class FacebookPollEntityDAO extends HibernateDAO<FacebookPollEntity>
{
	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.bendo.db.dao.HibernateDAO#init()
	 */
	@Override
	protected void init()
	{
		setType(FacebookPollEntity.class);
	}
}
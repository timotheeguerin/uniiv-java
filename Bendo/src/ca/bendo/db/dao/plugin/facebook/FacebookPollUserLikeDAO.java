/**
 * 
 */
package ca.bendo.db.dao.plugin.facebook;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.plugin.facebook.FacebookPollUserLike;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>FacebookPollUserLike</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class FacebookPollUserLikeDAO extends HibernateDAO<FacebookPollUserLike>
{
	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.bendo.db.dao.HibernateDAO#init()
	 */
	@Override
	protected void init()
	{
		setType(FacebookPollUserLike.class);
	}
}

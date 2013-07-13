/**
 * 
 */
package ca.bendo.db.dao.plugin.facebook;

import org.hibernate.criterion.Restrictions;
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

	/**
	 * 
	 * @param entityId
	 *            Entity id
	 * @param userId
	 *            User id
	 * @return object
	 */
	public FacebookPollUserLike getByEntityAndUser(final long entityId, final long userId)
	{

		return (FacebookPollUserLike) createCriteria().add(Restrictions.eq("entity.id", entityId))
				.add(Restrictions.eq("user.id", userId)).uniqueResult();
	}
}

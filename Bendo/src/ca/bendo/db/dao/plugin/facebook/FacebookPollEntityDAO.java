/**
 * 
 */
package ca.bendo.db.dao.plugin.facebook;

import java.util.List;

import org.hibernate.criterion.Restrictions;
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

	/**
	 * @param pollId
	 *            Poll id
	 * @return list
	 */
	@SuppressWarnings("unchecked")
	public List<FacebookPollEntity> listFromPoll(final long pollId)
	{
		return (List<FacebookPollEntity>) createCriteria().add(Restrictions.eq("poll.id", pollId)).list();
	}
}
/**
 * 
 */
package ca.bendo.db.dao.user;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.user.UserResetPassword;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UserResetPasswordDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class UserResetPasswordDAO extends HibernateDAO<UserResetPassword>
{

	/**
	 * 
	 */
	public UserResetPasswordDAO()
	{
		setType(UserResetPassword.class);
	}

	/**
	 * 
	 * @param id
	 *            id
	 * @param string
	 *            key
	 * @return if the password can be reset
	 */
	public UserResetPassword isValid(final long id, final String string)
	{
		Criterion restriction = Restrictions.and(Restrictions.eq("id", id), Restrictions.eq("key", string),
				Restrictions.ge("dateExpired", new Date()));
		return (UserResetPassword) getSession().createCriteria(UserResetPassword.class).add(restriction)
				.uniqueResult();
	}

	/**
	 * 
	 */
	public void cleanExpiredKey()
	{
		@SuppressWarnings("unchecked")
		List<UserResetPassword> list = (List<UserResetPassword>) getSession().createCriteria(UserResetPassword.class)
				.add(Restrictions.le("dateExpired", new Date()));
		for (UserResetPassword entity : list)
		{
			getSession().delete(entity);
		}
	}
}

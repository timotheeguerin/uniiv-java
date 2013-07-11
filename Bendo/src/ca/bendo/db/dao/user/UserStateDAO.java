/**
 * 
 */
package ca.bendo.db.dao.user;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.user.UserState;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UserSateDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */

@Repository
public class UserStateDAO extends HibernateDAO<UserState>
{
	/**
	 * Default contructor.
	 */
	public UserStateDAO()
	{
		setType(UserState.class);
	}

	/**
	 * 
	 * @param string
	 *            String
	 * @return the state with the state name given
	 */
	public UserState getByState(final String string)
	{
		return (UserState) getSession().createCriteria(UserState.class).add(Restrictions.eq("state", string))
				.uniqueResult();

	}

}

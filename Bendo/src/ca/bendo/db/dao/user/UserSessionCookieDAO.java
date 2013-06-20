/**
 * 
 */
package ca.bendo.db.dao.user;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.user.UserSessionCookie;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UserSessionCookieDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class UserSessionCookieDAO extends HibernateDAO<UserSessionCookie>
{
	/**
	 * 
	 */
	public UserSessionCookieDAO()
	{
		setType(UserSessionCookie.class);
	}
}

/**
 * 
 */
package ca.bendo.db.dao.user;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.user.UserEmailConfirmation;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UserConfirmationDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class UserEmailConfirmationDAO extends HibernateDAO<UserEmailConfirmation>
{

	/**
	 * 
	 */
	public UserEmailConfirmationDAO()
	{
		setType(UserEmailConfirmation.class);
	}
}

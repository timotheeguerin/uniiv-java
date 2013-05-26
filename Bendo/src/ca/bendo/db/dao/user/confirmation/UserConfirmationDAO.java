/**
 * 
 */
package ca.bendo.db.dao.user.confirmation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.user.confirmation.UserConfirmation;

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
public class UserConfirmationDAO extends HibernateDAO<UserConfirmation>
{

	/**
	 * 
	 */
	public UserConfirmationDAO()
	{
		setType(UserConfirmation.class);
	}
}

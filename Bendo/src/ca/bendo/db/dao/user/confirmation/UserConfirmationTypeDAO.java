/**
 * 
 */
package ca.bendo.db.dao.user.confirmation;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.user.confirmation.UserConfirmationType;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UserConfirmationTypeDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class UserConfirmationTypeDAO extends HibernateDAO<UserConfirmationType>
{

	/**
	 * 
	 */
	public UserConfirmationTypeDAO()
	{
		setType(UserConfirmationType.class);
	}

	/**
	 * @param name
	 *            name of the confirmation
	 * @return get the user confirmation type with the given name
	 */
	public UserConfirmationType getByName(final String name)
	{
		return (UserConfirmationType) getSession().createCriteria(UserConfirmationType.class)
				.add(Restrictions.eq("name", name)).uniqueResult();
	}
}

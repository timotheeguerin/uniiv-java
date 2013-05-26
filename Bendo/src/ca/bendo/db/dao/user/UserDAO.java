/**
 * 
 */
package ca.bendo.db.dao.user;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.user.User;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UserDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class UserDAO extends HibernateDAO<User>
{
	/**
	 * 
	 */
	public UserDAO()
	{
		setType(User.class);
	}

	/**
	 * 
	 * @param email
	 *            Email to check availability
	 * @return if the email adress is available
	 */
	public boolean isEmailAvailable(final String email)
	{
		User user = getByEmail(email);
		return user == null;
	}

	/**
	 * 
	 * @param email
	 *            Email of the user
	 * @return user with the given email
	 */
	public User getByEmail(final String email)
	{
		return (User) getSession().createCriteria(User.class).add(Restrictions.eq("email", email)).uniqueResult();
	}
}

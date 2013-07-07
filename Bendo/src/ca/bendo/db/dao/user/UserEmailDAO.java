/**
 * 
 */
package ca.bendo.db.dao.user;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.user.User;
import ca.bendo.db.entity.user.UserEmail;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UserEmailDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class UserEmailDAO extends HibernateDAO<UserEmail>
{
	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.bendo.db.dao.HibernateDAO#init()
	 */
	@Override
	protected void init()
	{
		setType(UserEmail.class);
	}

	/**
	 * 
	 * @param email
	 *            Email to check availability
	 * @return if the email adress is available
	 */
	public boolean isEmailAvailable(final String email)
	{
		UserEmail user = getByEmail(email);
		return user == null;
	}

	/**
	 * 
	 * @param email
	 *            Email of the user
	 * @return user with the given email
	 */
	public UserEmail getByEmail(final String email)
	{
		return (UserEmail) createCriteria().add(Restrictions.eq("email", email)).uniqueResult();
	}

	/**
	 * @param user
	 *            User
	 * @return list of emails of the given user
	 */
	@SuppressWarnings("unchecked")
	public List<UserEmail> listUserEmails(final User user)
	{
		return (List<UserEmail>) createCriteria().add(Restrictions.eq("user.id", user.getId())).list();
	}

}

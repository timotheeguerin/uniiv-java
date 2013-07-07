/**
 * 
 */
package ca.bendo.controller.handler.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.user.UserDAO;
import ca.bendo.db.dao.user.UserEmailDAO;
import ca.bendo.db.entity.user.User;
import ca.bendo.db.entity.user.UserEmail;
import ca.bendo.form.entity.user.EmailForm;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>EmailService</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class EmailService
{
	/**
	 * 
	 */
	@Autowired
	private UserDAO userDAO;

	/**
	 * 
	 */
	@Autowired
	private UserEmailDAO emailDAO;

	/**
	 * @param user
	 *            user
	 * @return emails
	 */
	public List<UserEmail> getUserEmails(final User user)
	{
		return emailDAO.listUserEmails(user);
	}

	/**
	 * @param user
	 *            user
	 * @param emailForm
	 *            email form
	 */
	public void addEmail(final User user, final EmailForm emailForm)
	{
		UserEmail email = new UserEmail();
		email.setEmail(email.getEmail());
		email.setUser(user);
		email.setValidated(false);

		emailDAO.add(email);

	}
}

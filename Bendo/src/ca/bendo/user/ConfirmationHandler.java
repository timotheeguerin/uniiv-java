/**
 * 
 */
package ca.bendo.user;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.user.UserEmailConfirmationDAO;
import ca.bendo.db.dao.user.UserEmailDAO;
import ca.bendo.db.dao.user.UserPermissionDAO;
import ca.bendo.db.dao.user.UserStateDAO;
import ca.bendo.db.dao.user.confirmation.UserConfirmationDAO;
import ca.bendo.db.dao.user.confirmation.UserConfirmationTypeDAO;
import ca.bendo.db.entity.user.User;
import ca.bendo.db.entity.user.UserEmail;
import ca.bendo.db.entity.user.UserEmailConfirmation;
import ca.bendo.db.entity.user.UserState;
import ca.bendo.db.entity.user.confirmation.UserConfirmation;
import ca.bendo.db.entity.user.confirmation.UserConfirmationType;
import ca.bendo.form.entity.confirmation.CheckConfirmationForm;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ConfirmationHandler</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class ConfirmationHandler
{
	/**
	 * 
	 */
	private static final int CONFIRMATION_KEY_LENGTH = 32;

	/**
	 * 
	 */
	@Autowired
	private UserConfirmationDAO confirmationDAO;

	/**
	 * 
	 */
	@Autowired
	private UserPermissionDAO permissionDAO;

	/**
	 * 
	 */
	@Autowired
	private UserConfirmationTypeDAO confirmationTypeDAO;
	/**
	 * 
	 */
	@Autowired
	private UserEmailConfirmationDAO userEmailConfirmationDAO;

	/**
	 * 
	 */
	@Autowired
	private UserStateDAO userStateDAO;

	/**
	 * 
	 */
	@Autowired
	private UserEmailDAO userEmailDAO;

	/**
	 * 
	 * @param user
	 *            User waiting for the confirmation
	 * @param typeStr
	 *            Type of the confirmation
	 * @return the user confirmation if succesufly created
	 */
	public UserConfirmation createConfirmation(final User user, final String typeStr)
	{

		UserConfirmationType type = confirmationTypeDAO.getByName(typeStr);
		if (type == null)
		{
			return null;
		}

		UserConfirmation confirmation = new UserConfirmation();
		String key = RandomStringUtils.randomAlphanumeric(CONFIRMATION_KEY_LENGTH);
		confirmation.setKey(key);
		confirmation.setUser(user);

		confirmation.setDate(new Date());
		confirmation.setType(type);
		confirmationDAO.add(confirmation);

		return confirmation;
	}

	/**
	 * 
	 * @param userEmail
	 *            User waiting for the confirmation
	 * @return the user confirmation if succesufly created
	 */
	public UserEmailConfirmation createEmailConfirmation(final UserEmail userEmail)
	{

		UserEmailConfirmation confirmation = new UserEmailConfirmation();
		String key = RandomStringUtils.randomAlphanumeric(CONFIRMATION_KEY_LENGTH);
		confirmation.setKey(key);
		confirmation.setUserEmail(userEmail);
		confirmation.setDateCreated(new Date());

		userEmailConfirmationDAO.add(confirmation);

		return confirmation;
	}

	/**
	 * 
	 * @param entity
	 *            Entity
	 * @param request
	 *            Request
	 * @return boolean if the request was successful
	 */
	public boolean handleConfirmation(final CheckConfirmationForm entity, final HttpServletRequest request)
	{

		UserEmailConfirmation confirmation = confirm(entity.getConfirmationId(), entity.getKey());

		if (confirmation != null)
		{
			User user = confirmation.getUserEmail().getUser();
			user.removePermission(permissionDAO.getByName("wait_email_confirmation"));
			user.addPermission(permissionDAO.getByName("user"));
			UserState valid = userStateDAO.getByState("valid");
			user.setState(valid);

			UserEmail userEmail = confirmation.getUserEmail();
			userEmail.setValidated(true);
			userEmailDAO.saveOrUpdate(userEmail);

			confirmationDAO.delete(entity.getConfirmationId());
			return true;
		}
		return false;

	}

	/**
	 * Check if the confirmation with the key given has the given key.
	 * 
	 * @param confirmationId
	 *            Id of the confirmation to compare
	 * @param key
	 *            key of the confirmation
	 * @return confirmation if the key map a confirmation for the user
	 */
	public UserEmailConfirmation confirm(final long confirmationId, final String key)
	{
		UserEmailConfirmation confirmation = userEmailConfirmationDAO.getById(confirmationId);

		if (confirmation != null && confirmation.getKey().equals(key))
		{
			return confirmation;
		} else
		{
			return null;
		}

	}

}

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

import ca.bendo.db.dao.user.UserPermissionDAO;
import ca.bendo.db.dao.user.UserStateDAO;
import ca.bendo.db.dao.user.confirmation.UserConfirmationDAO;
import ca.bendo.db.dao.user.confirmation.UserConfirmationTypeDAO;
import ca.bendo.db.entity.user.User;
import ca.bendo.db.entity.user.UserState;
import ca.bendo.db.entity.user.confirmation.UserConfirmation;
import ca.bendo.db.entity.user.confirmation.UserConfirmationType;
import ca.bendo.form.entity.confirmation.CheckConfirmationEntity;

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
	private UserStateDAO userStateDAO;

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
	 * @param entity
	 *            Entity
	 * @param request
	 *            Request
	 * @return boolean if the request was successful
	 */
	public boolean handleConfirmation(final CheckConfirmationEntity entity, final HttpServletRequest request)
	{

		UserConfirmation confirmation = confirm(entity.getConfirmationId(), entity.getKey());

		if (confirmation != null)
		{
			User user = confirmation.getUser();
			user.removePermission(permissionDAO.getByName("wait_email_confirmation"));
			user.addPermission(permissionDAO.getByName("user"));
			UserState valid = userStateDAO.getByState("valid");
			user.setState(valid);

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
	public UserConfirmation confirm(final long confirmationId, final String key)
	{
		UserConfirmation confirmation = confirmationDAO.getById(confirmationId);

		if (confirmation != null && confirmation.getKey().equals(key))
		{
			return confirmation;
		} else
		{
			return null;
		}

	}

}

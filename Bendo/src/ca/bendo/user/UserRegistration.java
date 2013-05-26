/**
 * 
 */
package ca.bendo.user;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UserRegistration</b>
 *          <p>
 *          </p>
 * 
 * 
 */

@Service
public class UserRegistration
{

	/**
	 * Lenght of the confirmation key.
	 */
	private static final int CONFIRMATION_KEY_LENGTH = 32;
	/**
	 * DAO to connect to the userConfirmation table.
	 */


	/**
	 * Logger.
	 */
	@SuppressWarnings("unused")
	private Logger log = Logger.getLogger(UserRegistration.class);

//	/**
//	 * Register a new User.
//	 * 
//	 * @param request
//	 *            Request oject
//	 * @param signupInformation
//	 *            The new user to register
//	 * @return The full user object
//	 */
//	public final Member registerUser(final HttpServletRequest request, final SignupInformation signupInformation)
//	{
//		Translator translator = (Translator) request.getAttribute("translator");
//
//		try
//		{
//			Member user = null; // userDao.create(signupInformation);
//			String key = RandomStringUtils.randomAlphanumeric(CONFIRMATION_KEY_LENGTH);
//
//			getUserconfirmationsDao().addConfirmation(user, key, 1);
//
//			/* next, get the Template */
//			Template t = Velocity.getTemplate("email/signup_confirmation.vm");
//
//			/* create a context and add data */
//			VelocityContext context = new VelocityContext();
//			context.put("key", key);
//			context.put("user", user);
//			String url = BendoConfig.getBaseUrl() + translator.getLink("wait_confirmation");
//
//			context.put("url", url);
//
//			/* now render the template into a StringWriter */
//			StringWriter writer = new StringWriter();
//			t.merge(context, writer);
//
//			MailHelper mail = new MailHelper();
//			mail.send(user.getEmail().toString(), "Bendo complete ur registration", writer.toString());
//			return user;
//		} catch (Exception e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return null;
//	}
//
//	/**
//	 * Getter.
//	 * 
//	 * @return UserConfirmationDao
//	 */
//	public final UserConfirmationDao getUserconfirmationsDao()
//	{
//		return userconfirmationsDao;
//	}
//
//	/**
//	 * Setter.
//	 * 
//	 * @param userconfirmationsDao
//	 *            Set the userconfirmationsDao
//	 */
//	public final void setUserconfirmationsDao(final UserConfirmationDao userconfirmationsDao)
//	{
//		this.userconfirmationsDao = userconfirmationsDao;
//	}
//
//	/**
//	 * Manage the request send by user to confirm email adress.
//	 * 
//	 * @param request
//	 *            The request send by user
//	 * @return Boolean if the email confirmation is valid
//	 */
//	public final boolean confirmEmail(final HttpServletRequest request)
//	{
//		String userIdStr = request.getParameter("userid");
//		String key = request.getParameter("key");
//		if (userIdStr != null && key != null)
//		{
//			int userId = Integer.parseInt(userIdStr);
//			int confirmationId = userconfirmationsDao.checkConfirmation(userId, key, 1);
//			if (confirmationId == -1)
//			{
//				return false;
//			}
//
//			userconfirmationsDao.deleteConfirmation(confirmationId);
//			// userDao.updateState(userId, UserFactory.getStateByName("valid"));
//			return true;
//		} else
//		{
//			return false;
//		}
//
//	}

}

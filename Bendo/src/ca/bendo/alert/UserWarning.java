/**
 * 
 */
package ca.bendo.alert;

import javax.servlet.http.HttpServletRequest;

import ca.bendo.alert.message.AlertMessageManager;
import ca.bendo.session.UserSession;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UserWarning</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public final class UserWarning
{

	/**
	 * 
	 */
	private UserWarning()
	{
		// 
	}

	/**
	 * 
	 * @param request
	 *            request
	 */
	public static void needValidUser(final HttpServletRequest request)
	{
		UserSession userSession = UserSession.getSession(request);
		if (!userSession.hasPermission("user"))
		{
			if (userSession.hasPermission("wait_email_confirmation"))
			{
				AlertMessageManager.getManager(request).addAlertMessage("alert_war_need_validate_email", request);
			} else
			{
				AlertMessageManager.getManager(request).addAlertMessage("alert_war_need_user_login", request);
			}
		}
	}
}

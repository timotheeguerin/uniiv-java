/**
 * 
 */
package ca.bendo.alert.message;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ca.bendo.db.entity.lang.Language;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>AlertMessageManager</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public final class AlertMessageManager
{
	/**
	 * 
	 */
	private List<AlertMessage> alertMessages = new ArrayList<AlertMessage>();

	/**
	 * 
	 */
	private AlertMessageManager()
	{
		//
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * 
	 * @return object loaded from request or new if doesn't exist
	 */
	public static AlertMessageManager getManager(final HttpServletRequest request)
	{
		AlertMessageManager manager = (AlertMessageManager) request.getAttribute("alertMessageManager");

		if (manager == null)
		{
			manager = new AlertMessageManager();
			request.setAttribute("alertMessageManager", manager);
		}

		return manager;
	}

	/**
	 * 
	 * @param key
	 *            AlertMessage key
	 * @param msg
	 *            AlertMessage message
	 * @param type
	 *            AlertMessage type
	 */
	public void addAlertMessage(final String key, final String msg, final AlertMessageType type)
	{
		alertMessages.add(new AlertMessage(key, msg, type));

	}

	/**
	 * 
	 * @param key
	 *            AlertMessage key
	 * @param request
	 *            request
	 */
	public void addAlertMessage(final String key, final HttpServletRequest request)
	{
		Translator translator = Translator.getTranslator(request);
		Long languageId = Language.loadId(request);
		AlertMessageType type = null;
		if (key.startsWith("alert_err"))
		{
			type = AlertMessageType.Error;
		} else if (key.startsWith("alert_info"))
		{
			type = AlertMessageType.Info;
		} else if (key.startsWith("alert_war"))
		{
			type = AlertMessageType.Warning;
		} else if (key.startsWith("alert_debug"))
		{
			type = AlertMessageType.Debug;
		}
		// Check the key is really an alert msg
		if (type != null)
		{
			String msg = translator.translate(key, languageId);
			addAlertMessage(key, msg, type);
		}
	}

	/**
	 * 
	 * @param alertMessage
	 *            Alert message to add
	 */
	public void addAlertMessage(final AlertMessage alertMessage)
	{
		alertMessages.add(alertMessage);
	}

	/**
	 * @return the alertMessages
	 */
	public List<AlertMessage> getAlertMessages()
	{
		return alertMessages;
	}

	/**
	 * @param alertMessages
	 *            the alertMessages to set
	 */
	public void setAlertMessages(final List<AlertMessage> alertMessages)
	{
		this.alertMessages = alertMessages;
	}

	/**
	 * @return The number of alertMessage
	 */
	public int number()
	{
		return alertMessages.size();
	}
}

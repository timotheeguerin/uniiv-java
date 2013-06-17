/**
 * 
 */
package ca.bendo.taglib.template.alert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import ca.bendo.alert.message.AlertMessage;
import ca.bendo.alert.message.AlertMessageManager;
import ca.bendo.taglib.template.TagTemplate;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>AlertMessageBox</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class AlertMessagesContainer extends TagTemplate
{

	/**
	 * @param translator
	 *            Translator
	 * @param pageContext
	 *            PageContext
	 */
	public AlertMessagesContainer(final Translator translator, final PageContext pageContext)
	{
		super(translator, pageContext);
		// 
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.bendo.taglib.template.TagTemplate#render()
	 */
	@Override
	public StringBuilder render()
	{
		HttpServletRequest request = (HttpServletRequest) getPageContext().getRequest();
		StringBuilder result = new StringBuilder();

		AlertMessageManager alertManager = (AlertMessageManager) request.getAttribute("alertMessageManager");
		if (alertManager == null)
		{
			return result;
		}

		result.append("<div class='alert_messages_box'>");

		for (AlertMessage alertMsg : alertManager.getAlertMessages())
		{
			AlertMessageBox msgBox = new AlertMessageBox(getTranslator(), getPageContext());
			msgBox.setAlertMsg(alertMsg);
			result.append(msgBox.render());
		}

		result.append("</div>");

		return result;
	}

}
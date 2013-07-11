/**
 * 
 */
package ca.bendo.taglib.template.alert;

import javax.servlet.jsp.PageContext;

import ca.bendo.alert.message.AlertMessage;
import ca.bendo.config.BendoConfig;
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
public class AlertMessageBox extends TagTemplate
{

	/**
	 * 
	 */
	private AlertMessage alertMsg;

	/**
	 * @param translator
	 *            Translator
	 * @param pageContext
	 *            PageContext
	 */
	public AlertMessageBox(final Translator translator, final PageContext pageContext)
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
		String key = alertMsg.getKey();
		String msg = alertMsg.getMsg();
		String type = alertMsg.getType().toString();
		String img = url(BendoConfig.getProperty("img." + type));

		StringBuilder result = new StringBuilder();
		result.append("<div class='alertMsgBox " + type + " " + key + "'>");
		result.append("<div class='alertMsgIcon'>");
		result.append("<img class='icon" + type + "'src='" + img + "'/>");
		result.append("</div>");
		result.append("<div class='alertMsgContent'>" + msg + "</div>");
		result.append("<div class='closeAlertMsgBox'>");
		result.append("</div>");
		result.append("</div>");
		return result;
	}

	/**
	 * @return the alertMsg
	 */
	public AlertMessage getAlertMsg()
	{
		return alertMsg;
	}

	/**
	 * @param alertMsg
	 *            the alertMsg to set
	 */
	public void setAlertMsg(final AlertMessage alertMsg)
	{
		this.alertMsg = alertMsg;
	}

}

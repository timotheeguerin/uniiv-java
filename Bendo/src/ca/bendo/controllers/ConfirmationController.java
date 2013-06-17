/**
 * 
 */
package ca.bendo.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.bendo.db.entity.lang.Language;
import ca.bendo.translation.translation.Translator;
import ca.bendo.user.ConfirmationHandler;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ConfirmationController</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Controller
@RequestMapping("/confirmation")
public class ConfirmationController
{
	/**
	 * Logger.
	 */
	@SuppressWarnings("unused")
	private Logger log = Logger.getLogger(ConfirmationController.class);

	/**
	 * User registration object.
	 */
	@Autowired
	private ConfirmationHandler confirmationHandler;

	/**
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return Jsp page
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String signupConfirmation(final HttpServletRequest request, final HttpServletResponse response)
	{
		Translator translator = (Translator) request.getAttribute("translator");
		Long languageId = Language.loadId(request);
		
		if (confirmationHandler.handleConfirmation(request))
		{
			String url = "/";
			String param = "?alertmsg=alert_info_email_confirm_success";
			return "redirect:" + translator.translateUrl(url + param, languageId);
		}

		return "views/wait_email_confirmation";
	}
}

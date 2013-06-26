/**
 * 
 */
package ca.bendo.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.bendo.db.entity.lang.Language;
import ca.bendo.form.handler.user.ForgetPasswordHandler;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ForgetPasswordController</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Controller
public class ForgetPasswordController
{
	/**
 * 
 */
	@Autowired
	private ForgetPasswordHandler forgetPasswordHandler;

	/**
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return Jsp page
	 */
	@RequestMapping(value = "/resetpassword/sendemail", method = RequestMethod.GET)
	public String sendEmail(final HttpServletRequest request, final HttpServletResponse response)
	{
		return sendMailPage(request, response);
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return Jsp page
	 */
	@RequestMapping(value = "/resetpassword/sendemail", method = RequestMethod.POST)
	public String handleSendEmail(final HttpServletRequest request, final HttpServletResponse response)
	{
		long languageId = Language.loadId(request);
		Translator translator = Translator.getTranslator(request);
		if (forgetPasswordHandler.handleSendEmail(request))
		{
			String url = "/";
			String param = "?alertmsg=alert_info_reset_password_email_sent";
			return "redirect:" + translator.translateUrl(url + param, languageId);
		} else
		{
			return sendMailPage(request, response);
		}
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return Jsp page
	 */
	public String sendMailPage(final HttpServletRequest request, final HttpServletResponse response)
	{
		return "views/user/resetpassword_sendmail";
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return Jsp page
	 */
	@RequestMapping(value = "/resetpassword", method = RequestMethod.GET)
	public String chooseNewPassword(final HttpServletRequest request, final HttpServletResponse response)
	{
		return chooseNewPasswordPage(request, response);
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return Jsp page
	 */
	@RequestMapping(value = "/resetpassword", method = RequestMethod.POST)
	public String handleChooseNewPassword(final HttpServletRequest request, final HttpServletResponse response)
	{
		long languageId = Language.loadId(request);
		Translator translator = Translator.getTranslator(request);
		if (forgetPasswordHandler.handleNewPassword(request))
		{
			String url = "/";
			String param = "?alertmsg=alert_info_reset_password_success";
			return "redirect:" + translator.translateUrl(url + param, languageId);
		} else
		{
			return chooseNewPasswordPage(request, response);
		}
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return Jsp page
	 */
	public String chooseNewPasswordPage(final HttpServletRequest request, final HttpServletResponse response)
	{
		String id = request.getParameter("id");
		String key = request.getParameter("key");

		request.setAttribute("id", id);
		request.setAttribute("key", key);
		return "views/user/resetpassword_new";
	}

}

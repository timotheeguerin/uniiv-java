/**
 * 
 */
package ca.bendo.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.bendo.db.entity.lang.Language;
import ca.bendo.form.entity.user.InputEmailForm;
import ca.bendo.form.entity.user.ResetPasswordForm;
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
	 */
	@Autowired
	private Translator translator;

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
		return sendMailPage(request, new InputEmailForm());
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @param inputEmailForm
	 *            Form
	 * @param result
	 *            contains form error
	 * @return Jsp page
	 */
	@RequestMapping(value = "/resetpassword/sendemail", method = RequestMethod.POST)
	public String handleSendEmail(final HttpServletRequest request, @Valid final InputEmailForm inputEmailForm,
			final BindingResult result)
	{
		long languageId = Language.loadId(request);
		if (forgetPasswordHandler.handleSendEmail(request, inputEmailForm))
		{
			String url = "/";
			String param = "?alertmsg=alert_info_reset_password_email_sent";
			return "redirect:" + translator.translateUrl(url + param, languageId);
		} else
		{
			return sendMailPage(request, inputEmailForm);
		}
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @param inputEmailForm
	 *            Form
	 * @return Jsp page
	 */
	public String sendMailPage(final HttpServletRequest request, final InputEmailForm inputEmailForm)
	{
		request.setAttribute("inputEmailForm", inputEmailForm);
		return "views/user/resetpassword_sendmail";
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @param resetPasswordForm
	 *            Form
	 * @param result
	 *            Form errors
	 * @return Jsp page
	 */
	@RequestMapping(value = "/resetpassword", method = RequestMethod.GET)
	public String chooseNewPassword(final HttpServletRequest request,
			@ModelAttribute final ResetPasswordForm resetPasswordForm, final BindingResult result,
			final HttpServletResponse response)
	{
		return chooseNewPasswordPage(request, resetPasswordForm, result);
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @param resetPasswordForm
	 *            Form
	 * @param result
	 *            Form errors
	 * @return Jsp page
	 */
	@RequestMapping(value = "/resetpassword", method = RequestMethod.POST)
	public String handleChooseNewPassword(final HttpServletRequest request,
			@Valid final ResetPasswordForm resetPasswordForm, final BindingResult result)
	{
		if (result.hasErrors())
		{
			return chooseNewPasswordPage(request, resetPasswordForm, result);
		}
		long languageId = Language.loadId(request);
		if (forgetPasswordHandler.handleNewPassword(request, resetPasswordForm))
		{
			String url = "/";
			String param = "?alertmsg=alert_info_reset_password_success";
			return "redirect:" + translator.translateUrl(url + param, languageId);
		} else
		{
			return chooseNewPasswordPage(request, resetPasswordForm, result);
		}
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @param resetPasswordForm
	 *            Form
	 * @param result
	 *            Form errors
	 * 
	 * @return Jsp page
	 */
	public String chooseNewPasswordPage(final HttpServletRequest request, final ResetPasswordForm resetPasswordForm,
			final BindingResult result)
	{

		long languageId = Language.loadId(request);

		if (!forgetPasswordHandler.setupNewPasswordPage(request, resetPasswordForm))
		{
			result.addError(new FieldError("resetPasswordForm", "key", translator.translate("error.resetpassword",
					languageId)));
		}
		request.setAttribute("resetPasswordForm", resetPasswordForm);

		return "views/user/resetpassword_new";
	}

}

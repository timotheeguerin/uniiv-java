/**
 * 
 */
package ca.bendo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.bendo.db.entity.lang.Language;
import ca.bendo.form.entity.user.LoginForm;
import ca.bendo.form.handler.user.LoginHandler;
import ca.bendo.session.UserSession;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>LoginController</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Controller
@RequestMapping("/login")
public class LoginController extends GlobalController
{
	/**
	 * 
	 */
	@Autowired
	private Translator translator;
	/**
	 * Logger.
	 */
	@SuppressWarnings("unused")
	private Logger log = Logger.getLogger(LoginController.class);

	/**
	 * Validator.
	 */
	@Autowired
	private LoginHandler loginHandler;

	/**
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return Jsp page
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(final HttpServletRequest request, final HttpServletResponse response)
	{
		Long languageId = Language.loadId(request);
		UserSession session = UserSession.getSession(request);
		if (session.isLogin())
		{
			return "redirect:" + translator.getLink("home", languageId);
		}

		request.setAttribute("containserr", false);
		return loginPage(request, new LoginForm());
	}

	/**
	 * Get the request after filling inputs and submit of login.
	 * 
	 * @param request
	 *            Request
	 * @param loginForm
	 *            LoginForm
	 * @param result
	 *            contains form errors
	 * @param response
	 *            Response
	 * @return Jsp page
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String loginPost(final HttpServletRequest request, @Valid final LoginForm loginForm,
			final BindingResult result, final HttpServletResponse response)
	{
		Long languageId = Language.loadId(request);
		UserSession session = UserSession.getSession(request);

		if (session.isLogin())
		{

			return "redirect:" + translator.getLink("home", languageId);
		}
		if (result.hasErrors())
		{
			return loginPage(request, loginForm);
		}
		if (loginHandler.handle(request, loginForm, response))
		{
			String referer = request.getHeader("Referer");
			String url = referer;
			String params = "?alertmsg=alert_info_login_success";
			return "redirect:" + url + params;
		} else
		{
			result.addError(new ObjectError("login", translator.translate("error.login", languageId)));
			return loginPage(request, loginForm);
		}
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @param loginForm
	 *            LoginForm
	 * @return Jsp page
	 */
	public String loginPage(final HttpServletRequest request, final LoginForm loginForm)
	{
		request.setAttribute("loginForm", loginForm);
		return "views/login";
	}

}

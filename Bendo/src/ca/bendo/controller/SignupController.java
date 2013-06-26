package ca.bendo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.bendo.controller.interceptor.annotation.Title;
import ca.bendo.db.entity.lang.Language;
import ca.bendo.form.entity.user.SignupForm;
import ca.bendo.form.handler.user.NewUserHandler;
import ca.bendo.head.HeadManager;
import ca.bendo.session.UserSession;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>SignupController</b>
 *          <p>
 *          Handles requests for the application signup page.
 *          </p>
 */
@Controller
@RequestMapping("/signup")
public class SignupController
{

	/**
	 * Logger.
	 */
	@SuppressWarnings("unused")
	private Logger log = Logger.getLogger(SignupController.class);

	/**
	 * Signup form validator object.
	 */
	@Autowired
	private NewUserHandler newUserHandler;

	/**
	 * Get the request from the signup page.
	 * 
	 * @param request
	 *            Request
	 * 
	 * @return Jsp page
	 */
	@Title("signup")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String signup(final HttpServletRequest request)
	{
		// init(request);
		Translator translator = Translator.getTranslator(request);
		Long languageId = Language.loadId(request);
		UserSession session = UserSession.getSession(request);
		if (session.isLogin())
		{
			return "redirect:" + translator.getLink("home", languageId);
		}
		request.setAttribute("containserr", false);
		return signupPage(request, new SignupForm());
	}

	/**
	 * Get the request after filling inputs and submit of signup.
	 * 
	 * @param request
	 *            Request
	 * @param signupForm
	 *            Signup form to be validated
	 * @param result
	 *            form errors
	 * @return Jsp page
	 */
	@Title("signup.handle")
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String signupPost(final HttpServletRequest request, @Valid final SignupForm signupForm,
			final BindingResult result)
	{
		Translator translator = Translator.getTranslator(request);

		Long languageId = Language.loadId(request);
		// If the user is login redirect to home page
		UserSession session = UserSession.getSession(request);
		if (session.isLogin())
		{
			return "redirect:" + translator.getLink("home", languageId);
		}

		if (result.hasErrors())
		{
			return signupPage(request, signupForm);
		}
		// newUserHandler.handle(request, signupForm);

		String url = "/confirmation";
		String param = "?alertmsg=alert_info_signupcomplete";
		return "redirect:" + translator.translateUrl(url + param, languageId);

	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @param signupForm
	 *            Signup form
	 * @return Jsp page
	 */
	public String signupPage(final HttpServletRequest request, final SignupForm signupForm)
	{
		request.setAttribute("signupForm", signupForm);
		request.setAttribute("displaySignupOnLoad", true);
		return "views/signup";
	}

	/**
	 * Check if the email send as parameter is available. For ajax.
	 * 
	 * @param email
	 *            Email to check
	 * @return 1 if the username is available and 0 if not
	 */
	@RequestMapping(value = "/emailavailable", method = RequestMethod.GET)
	@ResponseBody
	public String checkEmailAvailable(@RequestParam("email") final String email)
	{
		if (newUserHandler.isEmailAvailable(email))
		{
			return "1";
		} else
		{
			return "0";
		}
	}

	/**
	 * Confirm the email adress.
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return Jsp page
	 */
	@RequestMapping(value = "/confirmation", method = RequestMethod.GET)
	public String signupConfirmation(final HttpServletRequest request, final HttpServletResponse response)
	{
		Translator translator = Translator.getTranslator(request);
		Long languageId = Language.loadId(request);
		UserSession userSession = (UserSession) request.getAttribute("userSession");
		if (!userSession.hasPermission("wait_email_confirmation"))
		{
			return "redirect:" + translator.getLink("home", languageId);
		}

		request.getAttribute("translator");

		return "views/wait_email_confirmation";
	}

}

package ca.bendo.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.bendo.db.entity.lang.Language;
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
public class SignupController extends BendoController
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
	 * @param response
	 *            Response
	 * @return Jsp page
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String signup(final HttpServletRequest request, final HttpServletResponse response)
	{
		// init(request);
		Translator translator = Translator.getTranslator(request);
		Long languageId = Language.loadId(request);
		if (getUserSession().isLogin())
		{
			return "redirect:" + translator.getLink("home", languageId);
		}
		request.setAttribute("containserr", false);
		return signupPage(request, response);
	}

	/**
	 * Get the request after filling inputs and submit of signup.
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return Jsp page
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String signupPost(final HttpServletRequest request, final HttpServletResponse response)
	{
		Translator translator = Translator.getTranslator(request);

		Long languageId = Language.loadId(request);
		// If the user is login redirect to home page
		if (getUserSession().isLogin())
		{
			return "redirect:" + translator.getLink("home", languageId);
		}

		if (newUserHandler.handle(request))
		{
			String url = "/confirmation";
			String param = "?alertmsg=alert_info_signupcomplete";
			return "redirect:" + translator.translateUrl(url + param, languageId);
		}

		return signupPage(request, response);
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return Jsp page
	 */
	public String signupPage(final HttpServletRequest request, final HttpServletResponse response)
	{

		System.out.println("HomeController: Passing through... signup");
		((HeadManager) request.getAttribute("head")).getTitle().setTitle("Signup");

		request.setAttribute("displaySignupOnLoad", true);
		return "views/signup";
	}

	/**
	 * Check if the email send as parameter is available. For ajax.
	 * 
	 * @param email
	 *            Email to check
	 * @return Boolean
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

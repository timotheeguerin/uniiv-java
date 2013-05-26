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
import ca.bendo.form.handler.user.LoginHandler;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timoth�e Gu�rin
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
public class LoginController extends BendoController
{

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
	public final String login(final HttpServletRequest request, final HttpServletResponse response)
	{
		Translator translator = Translator.getTranslator(request);
		Long languageId = Language.load(request);
		if (getUserSession().isLogin())
		{
			return "redirect:" + translator.getLink("home", languageId);
		}

		request.setAttribute("containserr", false);
		return loginPage(request, response);
	}

	/**
	 * Get the request after filling inputs and submit of login.
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return Jsp page
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public final String loginPost(final HttpServletRequest request, final HttpServletResponse response)
	{
		Translator translator = Translator.getTranslator(request);
		Long languageId = Language.load(request);
		if (getUserSession().isLogin())
		{

			return "redirect:" + translator.getLink("home", languageId);
		}

		if (loginHandler.handle(request))
		{
			String referer = request.getHeader("Referer");
			String url = referer;
			String params = "?alertmsg=alert_info_login_success";
			return "redirect:" + url + params;
		} else
		{
			return loginPage(request, response);
		}
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Reponse
	 * @return Jsp page
	 */
	public final String loginPage(final HttpServletRequest request, final HttpServletResponse response)
	{
		Translator trans = (Translator) request.getAttribute("translator");
		
		return "views/login";
	}

}

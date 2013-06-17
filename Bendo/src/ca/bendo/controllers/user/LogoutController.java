/**
 * 
 */
package ca.bendo.controllers.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.bendo.db.entity.lang.Language;
import ca.bendo.session.UserSession;
import ca.bendo.translation.translation.Translator;
import ca.bendo.utils.url.UrlFactory;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>LogoutController</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Controller
public class LogoutController
{

	/**
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return Jsp page
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String login(final HttpServletRequest request, final HttpServletResponse response)
	{
		UserSession userSession = UserSession.getSession(request);
		Long languageId = Language.loadId(request);
		if (!userSession.isLogin())
		{
			return "redirect:" + Translator.getTranslator(request).getLink("home", languageId);
		}
		userSession.logout();

		String referer = request.getHeader("Referer");
		String url = referer;
		String params = "alertmsg=alert_info_logout_success";

		return "redirect:" + UrlFactory.mergeUrl(url, params);
	}
}

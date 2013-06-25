/**
 * 
 */
package ca.bendo.controllers.user;

import java.net.CookieManager;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.CookieGenerator;

import ca.bendo.db.entity.lang.Language;
import ca.bendo.db.entity.user.UserSessionCookie;
import ca.bendo.session.UserSession;
import ca.bendo.translation.translation.Translator;
import ca.bendo.user.element.HashedPassword;
import ca.bendo.utils.security.Crypter;
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

		CookieGenerator userIdGenerator = new CookieGenerator();
		userIdGenerator.setCookieName("user.id");
		userIdGenerator.setCookiePath("/");
		userIdGenerator.removeCookie(response);

		CookieGenerator keyGenerator = new CookieGenerator();
		keyGenerator.setCookieName("user.key");
		keyGenerator.setCookiePath("/");
		keyGenerator.removeCookie(response);

		String referer = request.getHeader("Referer");
		String url = referer;
		String params = "alertmsg=alert_info_logout_success";

		return "redirect:" + UrlFactory.mergeUrl(url, params);
	}
}

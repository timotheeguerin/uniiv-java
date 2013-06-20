/**
 * 
 */
package ca.bendo.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ca.bendo.db.entity.lang.Language;
import ca.bendo.exception.NotAllowedException;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>sd</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Controller
public class GlobalController
{
	/**
	 * 
	 */
	@Autowired
	private Translator translator;

	/**
	 * @param request
	 *            HttpRequest
	 * @param e
	 *            exception
	 * @return view
	 */
	@ExceptionHandler(NotAllowedException.class)
	public String handleNotAllowedException(final HttpServletRequest request, final NotAllowedException e)
	{
		String redirectUrl = e.getRedirectUrl();
		if (redirectUrl == null)
		{
			return "views/errors/error403";
		}
		long languageId = Language.loadId(request);
		return translator.translateUrl("redirect:" + redirectUrl, languageId);
	}
}

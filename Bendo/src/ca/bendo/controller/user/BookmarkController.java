/**
 * 
 */
package ca.bendo.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.bendo.controller.handler.user.BookmarkHandler;
import ca.bendo.controller.interceptor.annotation.Secured;
import ca.bendo.session.UserSession;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>BookmarkController</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Controller
public class BookmarkController
{

	/**
	 * 
	 */
	@Autowired
	private BookmarkHandler handler;

	/**
	 * @param request
	 *            Request
	 * @param uniersityId
	 *            University Id
	 * @return body
	 */
	@Secured("user")
	@RequestMapping(value = "/university/{universityId}/bookmark", method = RequestMethod.GET)
	@ResponseBody
	public String bookmarkUniversity(final HttpServletRequest request,
			@PathVariable("universityId") final long uniersityId)
	{
		UserSession userSession = UserSession.getSession(request);

		if (handler.bookmarkUniversity(userSession.getUser(), uniersityId))
		{
			return "1";
		} else
		{
			return "0";
		}
	}

	/**
	 * @param request
	 *            Request
	 * @param uniersityId
	 *            University Id
	 * @return body
	 */
	@Secured("user")
	@RequestMapping(value = "/university/{universityId}/unbookmark", method = RequestMethod.GET)
	@ResponseBody
	public String unBookmarkUniversity(final HttpServletRequest request,
			@PathVariable("universityId") final long uniersityId)
	{
		UserSession userSession = UserSession.getSession(request);

		if (handler.unBookmarkUniversity(userSession.getUser(), uniersityId))
		{
			return "1";
		} else
		{
			return "0";
		}
	}

	/**
	 * @param request
	 *            Request
	 * @param uniersityId
	 *            Wiki Id
	 * @return body
	 */
	@Secured("user")
	@RequestMapping(value = "/wiki/{wikiId}/bookmark", method = RequestMethod.GET)
	@ResponseBody
	public String bookmarkWiki(final HttpServletRequest request, @PathVariable("wikiId") final long uniersityId)
	{
		UserSession userSession = UserSession.getSession(request);

		if (handler.bookmarkWiki(userSession.getUser(), uniersityId))
		{
			return "1";
		} else
		{
			return "0";
		}
	}

	/**
	 * @param request
	 *            Request
	 * @param uniersityId
	 *            Wiki Id
	 * @return body
	 */
	@Secured("user")
	@RequestMapping(value = "/wiki/{wikiId}/unbookmark", method = RequestMethod.GET)
	@ResponseBody
	public String unBookmarkWiki(final HttpServletRequest request, @PathVariable("wikiId") final long uniersityId)
	{
		UserSession userSession = UserSession.getSession(request);

		if (handler.unBookmarkWiki(userSession.getUser(), uniersityId))
		{
			return "1";
		} else
		{
			return "0";
		}
	}

}

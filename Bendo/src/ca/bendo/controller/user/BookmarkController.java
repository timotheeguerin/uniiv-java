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

import ca.bendo.controller.handler.user.BookmarkService;
import ca.bendo.controller.interceptor.annotation.Secured;
import ca.bendo.db.entity.user.User;
import ca.bendo.session.UserSession;

/**
 * @author Timothée Guérin + toby
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
	private BookmarkService service;

	/**
	 * @param request
	 *            Request
	 * @param universityId
	 *            University Id
	 * @return body
	 */
	@Secured("user")
	@RequestMapping(value = "/university/{universityId}/bookmark", method = RequestMethod.GET)
	@ResponseBody
	public String bookmarkUniversity(final HttpServletRequest request,
			@PathVariable("universityId") final long universityId)
	{
		User user = UserSession.getSession(request).getUser();
		if (service.toogleBookmarkUniversity(user, universityId))
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
	 * @param wikiId
	 *            Wiki Id
	 * @return body
	 */
	@Secured("user")
	@RequestMapping(value = "/wiki/{wikiId}/bookmark", method = RequestMethod.GET)
	@ResponseBody
	public String bookmarkWiki(final HttpServletRequest request, @PathVariable("wikiId") final long wikiId)
	{
		User user = UserSession.getSession(request).getUser();
		if (service.toogleBookmarkWikiPage(user, wikiId))
		{
			return "1";
		} else
		{
			return "0";
		}
	}
}

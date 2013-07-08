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
import ca.bendo.db.dao.user.bookmark.UserUniversityBookmarkDAO;
import ca.bendo.db.dao.user.bookmark.UserWikiBookmarkDAO;
import ca.bendo.db.entity.user.User;
import ca.bendo.db.entity.user.bookmark.UserUniversityBookmark;
import ca.bendo.db.entity.user.bookmark.UserWikiBookmark;
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
	private BookmarkHandler handler;
	
	@Autowired
	private UserUniversityBookmarkDAO userUniversityBookmarkDAO;
	
	@Autowired
	private UserWikiBookmarkDAO userWikiBookmarkDAO;

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
	public String bookmarkUniversity(final HttpServletRequest request, @PathVariable("universityId") final long universityId)
	{
		User user = UserSession.getSession(request).getUser();
		UserUniversityBookmark bookmark = userUniversityBookmarkDAO.getUserBookmark(user.getId(), universityId);
		if(bookmark == null)
		{
			handler.bookmarkUniversity(user, universityId);
			return "0";
		}
		else
		{
			handler.unBookmarkUniversity(user, universityId);
			return "1";
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
	public String bookmarkWiki(final HttpServletRequest request, @PathVariable("wikiId") final long wikiId)
	{
		User user = UserSession.getSession(request).getUser();
		UserWikiBookmark bookmark = userWikiBookmarkDAO.getUserBookmark(user.getId(), wikiId);
		if(bookmark == null)
		{
			handler.bookmarkWiki(user, wikiId);
			return "0";
		}
		else
		{
			handler.unBookmarkWiki(user, wikiId);
			return "1";
		}
	}
}

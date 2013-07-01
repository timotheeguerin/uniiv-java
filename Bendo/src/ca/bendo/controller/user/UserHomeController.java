/**
 * 
 */
package ca.bendo.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.bendo.controller.interceptor.annotation.Secured;
import ca.bendo.db.dao.user.UserDAO;
import ca.bendo.db.dao.user.bookmark.UserUniversityBookmarkDAO;
import ca.bendo.db.dao.user.bookmark.UserWikiBookmarkDAO;
import ca.bendo.db.entity.user.User;
import ca.bendo.session.UserSession;

/**
 * @author toby
 * 
 *         <b>UserHomeController</b>
 *         <p>
 *         user home page
 *         </p>
 * 
 * 
 */
@Controller
@Transactional
public class UserHomeController
{

	/**
	 * 
	 */
	@Autowired
	private UserDAO userDAO;

	/**
	 * 
	 */
	@Autowired
	private UserWikiBookmarkDAO wikiBookmarkDAO;

	/**
	 * 
	 */
	@Autowired
	private UserUniversityBookmarkDAO universityBookmarkDAO;

	/**
	 * 
	 * @param request
	 *            Request
	 * @return jsp page
	 */
	@Secured("user")
	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public String welcome(final HttpServletRequest request)
	{
		User user = UserSession.getSession(request).getUser();
		user.getBookmark().setWikiBookmarks(wikiBookmarkDAO.getUserBookmarks(user.getId()));
		user.getBookmark().setUniversityBookmarks(universityBookmarkDAO.getUserBookmarks(user.getId()));
		request.setAttribute("user", user);
		return "views/user/index";
	}
}

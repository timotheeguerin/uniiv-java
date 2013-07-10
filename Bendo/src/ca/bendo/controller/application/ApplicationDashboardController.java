/**
 * 
 */
package ca.bendo.controller.application;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.bendo.controller.interceptor.annotation.Secured;
import ca.bendo.db.dao.user.UserDAO;
import ca.bendo.db.dao.user.bookmark.UserUniversityBookmarkDAO;
import ca.bendo.db.entity.lang.Language;
import ca.bendo.db.entity.user.User;
import ca.bendo.session.UserSession;

/**
 * @author toby
 * 
 *         <b>ForumGroupController</b>
 *         <p>
 *         </p>
 * 
 * 
 */
@Controller
@Transactional
public class ApplicationDashboardController
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
	private UserUniversityBookmarkDAO universityBookmarkDAO;

	/**
	 * @param id
	 *            Id
	 * @param request
	 *            request Request
	 * @return jsp page
	 */
	@Secured("user")
	@RequestMapping(value = "/application", method = RequestMethod.GET)
	public String show(final HttpServletRequest request)
	{
		User user = UserSession.getSession(request).getUser();
		long languageId = Language.loadId(request);
		userDAO.enableTranslation(languageId);
		user.getBookmark().setUniversityBookmarks(universityBookmarkDAO.getUserBookmarks(user.getId()));
		request.setAttribute("user", user);
		return "views/application/applicationDashboard";
	}
}

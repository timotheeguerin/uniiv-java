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

import ca.bendo.db.dao.user.UserDAO;

/**
 * @author toby
 * 
 *         <b>UserHomeController</b>
 *         <p>
 *         	user home page
 *         </p>
 * 
 * 
 */
@Controller
@Transactional
public class UserHomeController
{

	@Autowired
	private UserDAO userDAO;

	/**
	 * 
	 * @param request
	 *            Request
	 * @return jsp page
	 */
	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public String welcome(final HttpServletRequest request)
	{
		return "views/user/index";
	}
	
	/**
	 * 
	 * @param request
	 *            Request
	 * @return jsp page
	 */
	@RequestMapping(value = "/user/unis", method = RequestMethod.GET)
	public String watchedUnis(final HttpServletRequest request)
	{
		return "views/user/watch/usersUniversities";
	}
	
	/**
	 * 
	 * @param request
	 *            Request
	 * @return jsp page
	 */
	@RequestMapping(value = "/user/wikis", method = RequestMethod.GET)
	public String watchedWikis(final HttpServletRequest request)
	{
		return "views/user/watch/usersWikis";
	}
	
	/**
	 * 
	 * @param request
	 *            Request
	 * @return jsp page
	 */
	@RequestMapping(value = "/user/myquestions", method = RequestMethod.GET)
	public String userAskedQuestions(final HttpServletRequest request)
	{
		return "views/user/questions/userAsked";
	}
	
	/**
	 * 
	 * @param request
	 *            Request
	 * @return jsp page
	 */
	@RequestMapping(value = "/user/myanswers", method = RequestMethod.GET)
	public String userAnsweredQuestions(final HttpServletRequest request)
	{
		return "views/user/questions/userAnswered";
	}

}

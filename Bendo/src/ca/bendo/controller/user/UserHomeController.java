/**
 * 
 */
package ca.bendo.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.bendo.db.dao.user.UserDAO;
import ca.bendo.db.entity.university.University;
import ca.bendo.db.entity.wiki.Wiki;

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
		List<University> unis;
		//unis = userDAO.getWatchedUnis();
		//request.setAttribute("unis", unis);
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
		List<Wiki> unis;
		//wikis = userDAO.getWatchedUnis();
		//request.setAttribute("wikis", wikis);
		return "views/user/watch/usersWikis";
	}
	
	/**
	 * 
	 * @param request
	 *            Request
	 * @return jsp page
	 */
	@RequestMapping(value = "/user/questions", method = RequestMethod.GET)
	public String watchedQs(final HttpServletRequest request)
	{
		//List<Question> questionsA;
		//questionsA = userDAO.getQuestionsA();
		//request.setAttribute("questionsA", questionsA);
		//List<Ansers> answers;
		//answers = userDAO.getAnswers();
		//request.setAttribute("answers", answers);
		return "views/user/watch/usersQuestions";
	}

}

/**
 * 
 */
package ca.bendo.controllers.forum;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ca.bendo.alert.UserWarning;
import ca.bendo.form.handler.forum.ForumQuestionHandler;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ForumQuestionController</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Controller
public class ForumQuestionController
{
	/**
	 * 
	 */
	@Autowired
	private ForumQuestionHandler questionHandler;

	/**
	 * 
	 * @param request
	 *            Request
	 * @param groupId
	 *            groupId
	 * @return jsp page
	 */
	@RequestMapping(value = "/forum/group/{groupId}/question/new", method = RequestMethod.GET)
	public String newQuestion(final HttpServletRequest request, @PathVariable(value = "groupId") final long groupId)
	{
		return newQuestionPage(request, groupId);
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @param groupId
	 *            groupId
	 * @return jsp page
	 */
	@RequestMapping(value = "/forum/group/{groupId}/question/new", method = RequestMethod.POST)
	public String handleNewQuestion(final HttpServletRequest request,
			@PathVariable(value = "groupId") final long groupId)
	{
//		if (questionHandler.handleNewQuestion(request, groupId))
//		{
//			return "redirect:";
//		} else
//		{
			return newQuestionPage(request, groupId);
//		}
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @param groupId
	 *            groupId
	 * @return jsp page
	 */
	public String newQuestionPage(final HttpServletRequest request, final long groupId)
	{
		UserWarning.needValidUser(request);
		if (questionHandler.setupNewQuestionPage(request, groupId))
		{
			return "views/forum/newQuestion";
		} else
		{
			return "views/errors/error404";
		}
	}

}

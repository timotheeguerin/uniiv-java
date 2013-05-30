/**
 * 
 */
package ca.bendo.controllers.forum;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.bendo.handler.forum.ForumGroupHandler;

/**
 * @author Timothée Guérin
 * 
 *         <b>ForumGroupController</b>
 *         <p>
 *         </p>
 * 
 * 
 */
@Controller
public class ForumGroupController
{
	/**
	 * 
	 */
	@Autowired
	private ForumGroupHandler forumGroupHandler;

	/**
	 * 
	 * @param request
	 *            Request
	 * @param groupId
	 *            groupId
	 * @return jsp page
	 */
	@RequestMapping(value = "/forum/group/{groupId}/", method = RequestMethod.GET)
	public String listQuestionInGroup(final HttpServletRequest request,
			@PathVariable(value = "groupId") final long groupId)
	{
		if (forumGroupHandler.listQuestionInGroup(request, groupId))
		{
			return "views/forum/questionlist";

		} else
		{
			return "views/errors/error404";
		}
	}
}

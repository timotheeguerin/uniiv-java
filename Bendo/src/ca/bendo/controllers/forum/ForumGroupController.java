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

import ca.bendo.exception.NotAllowedException;
import ca.bendo.handler.forum.ForumGroupHandler;
import ca.bendo.user.security.annotation.Secured;

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
	public String groupHomePage(final HttpServletRequest request, @PathVariable(value = "groupId") final long groupId)
	{
		if (forumGroupHandler.setupGroupPage(request, groupId))
		{
			return "views/forum/grouphome";

		} else
		{
			return "views/errors/error404";
		}
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @param groupId
	 *            groupId
	 * @return jsp page
	 */
	@RequestMapping(value = "/forum/group/{groupId}/questions", method = RequestMethod.GET)
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

	/**
	 * 
	 * @param request
	 *            Request
	 * @param groupId
	 *            groupId
	 * @return jsp page
	 */
	@RequestMapping(value = "/forum/group/{groupId}/subgroups", method = RequestMethod.GET)
	public String displaySubGroupPage(final HttpServletRequest request,
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

	/**
	 * Display only the first subgroups of the given group. Link to the the
	 * whole list should be in the jsp.
	 * 
	 * @param request
	 *            Request
	 * @param groupId
	 *            groupId
	 * @return jsp page
	 */
	@RequestMapping(value = "/forum/group/{groupId}/subgroups/fast", method = RequestMethod.GET)
	public String fastDisplaySubGroups(final HttpServletRequest request,
			@PathVariable(value = "groupId") final long groupId)
	{
		if (forumGroupHandler.setupQuickDisplaySubgroupList(request, groupId))
		{
			return "views/forum/quickDisplayGroupList";

		} else
		{
			return "views/errors/error404";
		}
	}
}

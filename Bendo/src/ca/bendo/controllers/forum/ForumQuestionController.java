/**
 * 
 */
package ca.bendo.controllers.forum;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.bendo.alert.UserWarning;
import ca.bendo.form.entity.forum.ForumQuestionForm;
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
		return newQuestionPage(request, new ForumQuestionForm(), groupId);
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @param groupId
	 *            groupId
	 * @param questionForm
	 *            Question form entity
	 * @param result
	 *            contain error of the form
	 * @return jsp page
	 */
	@RequestMapping(value = "/forum/group/{groupId}/question/new", method = RequestMethod.POST)
	public String handleNewQuestion(final HttpServletRequest request, @Valid final ForumQuestionForm questionForm,
			final BindingResult result, @PathVariable(value = "groupId") final long groupId)
	{
		if (result.hasErrors())
		{
			return newQuestionPage(request, questionForm, groupId);
		} else
		{
			questionHandler.handleNewQuestion(request, questionForm);
			return "redirect:";
		}
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @param questionForm
	 *            question Form
	 * @param groupId
	 *            Group Id
	 * @return jsp page
	 */
	public String newQuestionPage(final HttpServletRequest request, final ForumQuestionForm questionForm,
			final long groupId)
	{
		UserWarning.needValidUser(request);

		if (questionHandler.setupNewQuestionPage(request, groupId))
		{
			request.setAttribute("forumQuestionForm", questionForm);
			return "views/forum/newQuestion";
		} else
		{
			return "views/errors/error404";
		}
	}

}

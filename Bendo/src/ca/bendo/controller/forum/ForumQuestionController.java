/**
 * 
 */
package ca.bendo.controller.forum;

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
	 *            HttpRequest
	 * @param questionId
	 *            Id of the question to display
	 * @return jsp page
	 */
	@RequestMapping(value = "forum/question/{questionId}", method = RequestMethod.GET)
	public String displayQuestion(final HttpServletRequest request,
			@PathVariable(value = "questionId") final long questionId)
	{
		if (questionHandler.setupDisplayQuestion(request, questionId))
		{
			return "views/forum/displayQuestion";
		} else
		{
			return "views/errors/erro404";
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
			request.setAttribute("newQuestionForm", questionForm);
			return "views/forum/questionInput";
		} else
		{
			return "views/errors/error404";
		}
	}

	/**
	 * 
	 * @param request
	 *            HttpRequest
	 * @param questionId
	 *            Id of the question to display
	 * @param questionForm
	 *            question Form
	 * @param result
	 *            contain error of the form
	 * @return jsp page
	 */
	@RequestMapping(value = "forum/question/{questionId}/edit", method = RequestMethod.POST)
	public String handleEditQuestion(final HttpServletRequest request, final ForumQuestionForm questionForm,
			final BindingResult result, @PathVariable(value = "questionId") final long questionId)
	{
		if (result.hasErrors())
		{
			questionHandler.setupEditQuestion(request, questionForm);
			return "views/forum/questionInput";
		} else
		{
			questionHandler.handleEditQuestion(request, questionId, questionForm);
			return "redirect:";
		}
	}

	/**
	 * 
	 * @param request
	 *            HttpRequest
	 * @param questionId
	 *            Id of the question to display
	 * @return jsp page
	 */
	@RequestMapping(value = "forum/question/{questionId}/edit", method = RequestMethod.GET)
	public String editQuestion(final HttpServletRequest request,
			@PathVariable(value = "questionId") final long questionId)
	{
		if (questionHandler.loadEditQuestion(request, questionId))
		{
			return "views/forum/questionInput";
		} else
		{
			return "views/errors/error404";
		}
	}

}

/**
 * 
 */
package ca.bendo.controller.forum;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
	@RequestMapping(value = "/question/{questionId}", method = RequestMethod.GET)
	public String show(final HttpServletRequest request,
			@PathVariable(value = "questionId") final long questionId)
	{
		if (questionHandler.setupDisplayQuestion(request, questionId))
		{
			return "views/question/show";
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
	@RequestMapping(value = "/question/new", method = RequestMethod.GET)
	public String add(final HttpServletRequest request)
	{
		return newQuestionPage(request, new ForumQuestionForm());
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
	@RequestMapping(value = "/question/new", method = RequestMethod.POST)
	public String handleNewQuestion(final HttpServletRequest request, @Valid final ForumQuestionForm questionForm,
			final BindingResult result)
	{
		if (result.hasErrors())
		{
			return newQuestionPage(request, questionForm);
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
	public String newQuestionPage(final HttpServletRequest request, final ForumQuestionForm questionForm)
	{
		UserWarning.needValidUser(request);
		request.setAttribute("questionForm", questionForm);
		return "views/question/input";
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
	@RequestMapping(value = "question/{questionId}/edit", method = RequestMethod.POST)
	public String handleEditQuestion(final HttpServletRequest request, final ForumQuestionForm questionForm,
			final BindingResult result, @PathVariable(value = "questionId") final long questionId)
	{
		if (result.hasErrors())
		{
			questionHandler.setupEditQuestion(request, questionForm);
			return "views/question/input";
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
	@RequestMapping(value = "question/{questionId}/edit", method = RequestMethod.GET)
	public String editQuestion(final HttpServletRequest request,
			@PathVariable(value = "questionId") final long questionId)
	{
		if (questionHandler.loadEditQuestion(request, questionId))
		{
			return "views/question/input";
		} else
		{
			return "views/errors/error404";
		}
	}
	
	@RequestMapping(value="question/list", method = RequestMethod.GET)
	public String list(final HttpServletRequest request)
	{
		request.setAttribute("questions", questionHandler.list());
		return "views/question/list";
	}

}

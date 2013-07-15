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
import ca.bendo.controller.GlobalController;
import ca.bendo.db.entity.forum.ForumQuestion;
import ca.bendo.form.entity.forum.ForumQuestionForm;
import ca.bendo.form.handler.forum.ForumQuestionHandler;
import ca.bendo.translation.translation.Translator;

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
public class ForumQuestionController extends GlobalController
{
	/**
	 * 
	 */
	@Autowired
	private Translator translator;
	/**
	 * 
	 */
	@Autowired
	private ForumQuestionHandler questionHandler;

	/**
	 * 
	 * @param request
	 *            Request
	 * @return jsp page
	 */
	@RequestMapping(value = "/questions", method = RequestMethod.GET)
	public String index(final HttpServletRequest request)
	{
		return "views/questions/index";
	}

	/**
	 * 
	 * @param request
	 *            HttpRequest
	 * @param questionId
	 *            Id of the question to display
	 * @return jsp page
	 */
	@RequestMapping(value = "/questions/{questionId}", method = RequestMethod.GET)
	public String show(final HttpServletRequest request, @PathVariable(value = "questionId") final long questionId)
	{
		if (questionHandler.setupDisplayQuestion(request, questionId))
		{
			return "views/questions/show";
		} else
		{
			return "views/errors/erro404";
		}
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @return jsp page
	 */
	@RequestMapping(value = "/questions/new", method = RequestMethod.GET)
	public String add(final HttpServletRequest request)
	{
		return newQuestionPage(request, new ForumQuestionForm());
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @param questionForm
	 *            Question form entity
	 * @param result
	 *            contain error of the form
	 * @return jsp page
	 */
	@RequestMapping(value = "/questions/new", method = RequestMethod.POST)
	public String handleNewQuestion(final HttpServletRequest request, @Valid final ForumQuestionForm questionForm,
			final BindingResult result)
	{
		if (result.hasErrors())
		{
			return newQuestionPage(request, questionForm);
		} else
		{

			ForumQuestion question = questionHandler.handleNewQuestion(request, questionForm);
			return "redirect:" + translator.translateUrl("/question/" + question.getId());
		}
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @param questionForm
	 *            question Form
	 * @return jsp page
	 */
	public String newQuestionPage(final HttpServletRequest request, final ForumQuestionForm questionForm)
	{
		UserWarning.needValidUser(request);
		request.setAttribute("questionForm", questionForm);
		return "views/questions/input";
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
	@RequestMapping(value = "/questions/{questionId}/edit", method = RequestMethod.POST)
	public String handleEditQuestion(final HttpServletRequest request, final ForumQuestionForm questionForm,
			final BindingResult result, @PathVariable(value = "questionId") final long questionId)
	{
		if (result.hasErrors())
		{
			questionHandler.setupEditQuestion(request, questionForm);
			return "views/question/input";
		} else
		{
			long id = questionHandler.handleEditQuestion(request, questionId, questionForm);
			return "redirect:/questions/" + id;
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

	@RequestMapping(value = "/questions/{questionId}/edit", method = RequestMethod.GET)
	public String editQuestion(final HttpServletRequest request,
			@PathVariable(value = "questionId") final long questionId)
	{
		if (questionHandler.loadEditQuestion(request, questionId))
		{
			return "views/questions/input";
		} else
		{
			return "views/errors/error404";
		}
	}

	/**
	 * 
	 * @param request
	 *            HttpRequest
	 * @return jsp page
	 */
	@RequestMapping(value = "/questions/list", method = RequestMethod.GET)
	public String list(final HttpServletRequest request)
	{
		request.setAttribute("questions", questionHandler.list());
		return "views/questions/list";
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @param questionId
	 *            Question id
	 * @return jsp page
	 */
	// @Secured("admin") //TODO owner
	@RequestMapping(value = "questions/{questionId}/delete", method = RequestMethod.GET)
	public String delete(final HttpServletRequest request, @PathVariable(value = "questionId") final long questionId)
	{
		if (questionHandler.deleteQuestion(questionId))
		{
			return "redirect:/questions/list";
		} else
		{
			return "redirect:/questions/" + questionId;
		}
	}

}

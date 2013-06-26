/**
 * 
 */
package ca.bendo.controller.forum;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.bendo.form.entity.forum.ForumReplyForm;
import ca.bendo.form.handler.forum.ForumReplyHandler;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ForumReplyController</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Controller
public class ForumReplyController
{




	/**
	 * 
	 */
	@Test
	public void manufacturerIsNull()
	{

	}

	/**
	 * 
	 */
	@Autowired
	private ForumReplyHandler handler;

	/**
	 * 
	 * @param request
	 *            Request
	 * @param result
	 *            Result
	 * @param questionId
	 *            Question Id
	 * @param replyEntity
	 *            Form Entity
	 * @return return
	 */
	@RequestMapping(value = "/forum/question/{questionId}/reply/new", method = RequestMethod.POST)
	public String handleReply(final HttpServletRequest request,
			@ModelAttribute("replyEntity") @Valid final ForumReplyForm replyEntity, final BindingResult result,
			@PathVariable(value = "questionId") final long questionId)
	{

		System.out.println("E: " + replyEntity.getContent());
		System.out.println("QUESTION REPLY");

//		Set<ConstraintViolation<ForumReplyEntity>> constraintViolations = validator.validate(replyEntity);
//
//		System.out.println(constraintViolations.iterator().next().getMessage());

		// If the form has error
		if (result.hasErrors())
		{
			return replyPage(request, questionId);
		}
		System.out.println("HANDLE REPLY");
		// handler.handleNewReply(request, replyEntity, questionId);
		return "redirect:/forum/question/{questionId}";
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @param questionId
	 *            Question Id
	 * @return return
	 */
	@RequestMapping(value = "/forum/question/{questionId}/reply/new", method = RequestMethod.GET)
	public String replyPage(final HttpServletRequest request, @PathVariable(value = "questionId") final long questionId)
	{
		return setupView(request, new ForumReplyForm(), questionId);
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @param questionId
	 *            Question Id
	 * @param replyEntity
	 *            model
	 * @return return
	 */
	public String setupView(final HttpServletRequest request, final ForumReplyForm replyEntity, final long questionId)
	{
		request.setAttribute("replyEntity", replyEntity);
		return "views/forum/newReply";
	}
}

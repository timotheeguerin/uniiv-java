/**
 * 
 */
package ca.bendo.handler.forum;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.forum.ForumGroupDAO;
import ca.bendo.db.dao.forum.ForumQuestionDAO;
import ca.bendo.db.entity.forum.ForumGroup;
import ca.bendo.db.entity.forum.ForumQuestion;
import ca.bendo.form.FieldValidator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ForumGroupHandler</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class ForumGroupHandler
{
	/**
	 * 
	 */
	private static final int DEFAULT_AMOUNT = 20;

	/**
	 * 
	 */
	@Autowired
	private ForumGroupDAO groupDAO;

	/**
	 * 
	 */
	@Autowired
	private ForumQuestionDAO questionDAO;

	/**
	 * 
	 * @param request
	 *            Request
	 * @param groupId
	 *            GroupId
	 * @return boolean if request was successful
	 */
	public boolean listQuestionInGroup(final HttpServletRequest request, final long groupId)
	{
		int startAt = 0;
		int amount = DEFAULT_AMOUNT;
		QuestionOrder order = QuestionOrder.RECENT;

		String startAtStr = request.getParameter("question_start_at");
		String questionAmountStr = request.getParameter("question_amount");
		String orderStr = request.getParameter("question_order");

		if (FieldValidator.isInt(startAtStr))
		{
			startAt = Integer.parseInt(startAtStr);
		}
		if (FieldValidator.isInt(questionAmountStr))
		{
			startAt = Integer.parseInt(questionAmountStr);
		}
		if (FieldValidator.isInt(startAtStr))
		{
			startAt = Integer.parseInt(startAtStr);
		}
		if (orderStr != null && QuestionOrder.valueOf(orderStr) != null)
		{
			order = QuestionOrder.valueOf(orderStr);
		}

		return listQuestionInGroup(request, groupId, startAt, amount, order);
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @param groupId
	 *            GroupId
	 * @param startAt
	 *            Starting at
	 * @param amount
	 *            Amount of question to display at once
	 * @param order
	 *            Question order
	 * @return boolean if request was successful
	 */
	public boolean listQuestionInGroup(final HttpServletRequest request, final long groupId, final int startAt,
			final int amount, final QuestionOrder order)
	{
		ForumGroup group = groupDAO.getById(groupId);
		if (group == null)
		{
			return false;
		}

		List<ForumQuestion> questions = questionDAO.listQuestionsInGroup(groupId, startAt, amount, order);
		request.setAttribute("questions", questions);
		request.setAttribute("group", group);
		return true;
	}
}

/**
 * 
 */
package ca.bendo.form.handler.forum;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.forum.ForumContentDAO;
import ca.bendo.db.dao.forum.ForumQuestionDAO;
import ca.bendo.db.entity.forum.ForumContent;
import ca.bendo.db.entity.forum.ForumQuestion;
import ca.bendo.db.entity.forum.ForumReply;
import ca.bendo.db.entity.user.User;
import ca.bendo.form.entity.forum.ForumReplyForm;
import ca.bendo.session.UserSession;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>QuestionReplyHandler</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class ForumReplyHandler
{
	/**
	 * 
	 */
	@Autowired
	private ForumContentDAO contentDAO;

	/**
	 * 
	 */
	@Autowired
	private ForumQuestionDAO questionDAO;

	/**
	 * 
	 * @param request
	 *            Request
	 * @param questionId
	 *            Question id
	 * @param replyEntity
	 *            ReplyEntity
	 * @return boolean if reply was handle successfully
	 */
	public boolean handleNewReply(final HttpServletRequest request, final ForumReplyForm replyEntity,
			final long questionId)
	{
		UserSession session = UserSession.getSession(request);
		User user = session.getUser();
		if (user == null)
		{
			return false;
		}
		ForumQuestion question = questionDAO.getById(questionId);
		if (question == null)
		{
			return false;
		}
		createReply(replyEntity, question, user);

		return true;
	}

	/**
	 * 
	 * @param replyEntity
	 *            Reply entity
	 * @param question
	 *            Question
	 * @param user
	 *            User
	 */
	public void createReply(final ForumReplyForm replyEntity, final ForumQuestion question, final User user)
	{
		ForumReply reply = new ForumReply();
		reply.setUser(user);
		reply.setTimeCreated(new Date());
		reply.setQuestion(question);

		ForumContent content = new ForumContent();
		content.setContent(replyEntity.getContent());
		content.processContent();
		contentDAO.add(content);

		reply.setContent(content);

	}

}

/**
 * 
 */
package ca.bendo.form.handler.forum;

import java.security.acl.Group;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.forum.ForumContentDAO;
import ca.bendo.db.dao.forum.ForumGroupDAO;
import ca.bendo.db.dao.forum.ForumQuestionDAO;
import ca.bendo.db.entity.forum.ForumContent;
import ca.bendo.db.entity.forum.ForumGroup;
import ca.bendo.db.entity.forum.ForumQuestion;
import ca.bendo.db.entity.forum.ForumTag;
import ca.bendo.db.entity.user.User;
import ca.bendo.form.entity.forum.ForumQuestionForm;
import ca.bendo.session.UserSession;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ForumQuestionHandler</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class ForumQuestionHandler
{
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
	 */
	@Autowired
	private ForumContentDAO contentDAO;

	/**
	 * @param request
	 *            Request
	 * @param questionForm
	 *            Question form
	 */
	public void handleNewQuestion(final HttpServletRequest request, final ForumQuestionForm questionForm)
	{

	}

	/**
	 * @param request
	 *            Request
	 * @param questionForm
	 *            Question form
	 * @param groupId
	 *            GroupId
	 */
	public void handleNewQuestion(final HttpServletRequest request, final ForumQuestionForm questionForm,
			final long groupId)
	{
		ForumGroup group = groupDAO.getById(groupId);
		if (group == null)
		{
			handleNewQuestion(request, questionForm);
		}
		handleNewQuestion(request, questionForm, group.getGeneratedTags());
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @param questionForm
	 *            Question form
	 * @param presetTags
	 *            Tags list containg the hidden tags
	 * @return boolean if the question was successful asked
	 */
	public boolean handleNewQuestion(final HttpServletRequest request, final ForumQuestionForm questionForm,
			final List<ForumTag> presetTags)
	{
		UserSession session = UserSession.getSession(request);
		User user = session.getUser();
		if (user == null)
		{
			return false;
		}
		
		return createQuestion(questionForm.getTitle(), questionForm.getContent(), presetTags, user);
	}

	/**
	 * 
	 * @param title
	 *            Question title
	 * @param presetTags
	 *            List of hidden tags to add
	 * @param user
	 *            User who created the question
	 * @param contentStr
	 *            Question content
	 * @return boolean if question created suceesfully
	 */
	public boolean createQuestion(final String title, final String contentStr, final List<ForumTag> presetTags,
			final User user)
	{

		ForumQuestion question = new ForumQuestion();
		question.setDateCreated(new Date());
		question.setTitle(title);
		question.setUser(user);
		question.addAllTags(presetTags);

		// Setup content
		ForumContent content = new ForumContent();
		content.setContent(contentStr);
		content.processContent();
		contentDAO.add(content);

		question.setContent(content);
		questionDAO.add(question);
		return true;
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @param groupId
	 *            Group id
	 * @return boolean if the question was successful asked
	 */
	public boolean setupNewQuestionPage(final HttpServletRequest request, final long groupId)
	{
		ForumGroup group = groupDAO.getById(groupId);
		if (group == null)
		{
			return false;
		}
		request.setAttribute("group", group);
		return true;
	}

}

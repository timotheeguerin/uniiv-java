/**
 * 
 */
package ca.bendo.form.handler.forum;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.forum.ForumContentDAO;
import ca.bendo.db.dao.forum.ForumGroupDAO;
import ca.bendo.db.dao.forum.ForumQuestionDAO;
import ca.bendo.db.dao.forum.ForumTagDAO;
import ca.bendo.db.entity.forum.FormattedContent;
import ca.bendo.db.entity.forum.ForumGroup;
import ca.bendo.db.entity.forum.ForumQuestion;
import ca.bendo.db.entity.forum.Tag;
import ca.bendo.db.entity.user.User;
import ca.bendo.exception.NotAllowedException;
import ca.bendo.form.entity.forum.ForumQuestionForm;
import ca.bendo.session.UserSession;
import ca.bendo.user.UserUtils;

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
	 * 
	 */
	@Autowired
	private ForumTagDAO tagDAO;

	/**
	 * @param request
	 *            Request
	 * @param questionForm
	 *            Question form
	 */
	public void handleNewQuestion(final HttpServletRequest request, final ForumQuestionForm questionForm)
	{
		handleNewQuestion(request, questionForm, new ArrayList<Tag>());
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
			final List<Tag> presetTags)
	{
		UserSession session = UserSession.getSession(request);
		User user = session.getUser();
		if (user == null)
		{
			return false;
		}

		return createQuestion(questionForm, presetTags, user);
	}

	/**
	 * 
	 * @param questionForm
	 *            Question form
	 * @param presetTags
	 *            List of hidden tags to add
	 * @param user
	 *            User who created the question
	 * @return boolean if question created suceesfully
	 */
	public boolean createQuestion(final ForumQuestionForm questionForm, final List<Tag> presetTags, final User user)
	{

		ForumQuestion question = new ForumQuestion();
		question.setDateCreated(new Date());
		question.setTitle(questionForm.getTitle());
		question.setUser(user);
		if (presetTags != null)
		{
			question.addAllTags(presetTags);
		}
		// Setup user tags
		List<Tag> userTags = tagDAO.getTags(questionForm.getTags());
		question.addAllTags(userTags);

		// Setup content
		FormattedContent content = new FormattedContent();
		content.setContent(questionForm.getContent());
		content.processContent();
		contentDAO.add(content);

		question.setContent(content);
		questionDAO.saveOrUpdate(question);
		System.out.println("Question added");
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
		// if (group == null)
		// {
		// return false;
		// }
		request.setAttribute("group", group);
		return true;
	}

	/**
	 * @param request
	 *            HttpRequest
	 * @param questionId
	 *            Id of the question to display
	 * @return boolean if the question with the given id does not exist
	 */
	public boolean setupDisplayQuestion(final HttpServletRequest request, final long questionId)
	{
		ForumQuestion question = questionDAO.getById(questionId);
		if (question == null)
		{
			return false;
		}

		request.setAttribute("question", question);
		return true;
	}

	/**
	 * @param request
	 *            HttpServletRequest
	 * @param questionId
	 *            Question Id
	 * @return boolean if the question with the given id exist
	 */
	public boolean loadEditQuestion(final HttpServletRequest request, final long questionId)
	{
		ForumQuestion question = questionDAO.getById(questionId);
		if (question == null)
		{
			return false;
		}	
		UserSession session = UserSession.getSession(request);
		User user = session.getUser();
		if (user == null || !UserUtils.canUserEditQuestion(user, question))
		{
			throw new NotAllowedException();
		}
		ForumQuestionForm questionForm = new ForumQuestionForm(question);
		setupEditQuestion(request, questionForm);
		return true;
	}

	/**
	 * @param request
	 *            HttpServletRequest
	 * @param questionForm
	 *            Question form
	 */
	public void setupEditQuestion(final HttpServletRequest request, final ForumQuestionForm questionForm)
	{
		
		request.setAttribute("questionForm", questionForm);
	}

	/**
	 * @param request
	 *            HttpServletRequest
	 * @param questionId
	 *            Question Id
	 * @param questionForm
	 *            QuestionForm from the user
	 * @return boolean if the question with the given id exist
	 */
	public boolean handleEditQuestion(final HttpServletRequest request, final long questionId,
			final ForumQuestionForm questionForm)
	{
		ForumQuestion question = questionDAO.getById(questionId);
		if (question == null)
		{
			return false;
		}

		UserSession session = UserSession.getSession(request);
		User user = session.getUser();
		if (user == null || !UserUtils.canUserEditQuestion(user, question))
		{
			throw new NotAllowedException();
		}

		// TODO check if user is authorised to edit

		question.setTitle(questionForm.getTitle());
		question.getContent().setContent(questionForm.getContent());
		List<Tag> tags = tagDAO.getTags(questionForm.getTags());
		question.setTags(tags);
		questionDAO.saveOrUpdate(question);

		return true;
	}

}

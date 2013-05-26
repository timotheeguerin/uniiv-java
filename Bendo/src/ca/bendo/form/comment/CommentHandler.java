/**
 * 
 */
package ca.bendo.form.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.comment.CommentDAO;
import ca.bendo.db.dao.lang.LanguageDAO;
import ca.bendo.db.entity.comment.Comment;
import ca.bendo.db.entity.lang.Language;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>Comment</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class CommentHandler
{
	/**
	 * 
	 */
	@Autowired
	private LanguageDAO languageDAO;
	/**
	 * 
	 */
	@Autowired
	private CommentDAO commentDAO;

	/**
	 * 
	 * @param commentStr
	 *            Comment
	 * @param languageId
	 *            Id of the Language of the comment
	 * @return if the comment could be added
	 */
	public Comment newComment(final String commentStr, final long languageId)
	{
		Language language = languageDAO.getById(languageId);
		if (language == null)
		{
			return null;
		}
		Comment comment = new Comment();
		comment.setContent(commentStr);
		comment.setLanguage(language);

		commentDAO.add(comment);
		return comment;
	}
}

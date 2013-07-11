/**
 * 
 */
package ca.bendo.db.dao.comment;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.comment.Comment;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>CommentDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class CommentDAO extends HibernateDAO<Comment>
{

	/**
	 * 
	 */
	public CommentDAO()
	{
		setType(Comment.class);
	}

	/**
	 * @return list all comment
	 */
	@SuppressWarnings("unchecked")
	public List<Comment> listComment()
	{
		return getSession().createCriteria(Comment.class).list();
	}

}

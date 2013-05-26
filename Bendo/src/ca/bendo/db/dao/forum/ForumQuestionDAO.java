/**
 * 
 */
package ca.bendo.db.dao.forum;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.forum.ForumQuestion;
import ca.bendo.handler.forum.QuestionOrder;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ForumQuestionDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class ForumQuestionDAO extends HibernateDAO<ForumQuestion>
{
	/**
	 * 
	 */
	public ForumQuestionDAO()
	{
		setType(ForumQuestion.class);
	}

	/**
	 * 
	 * @param groupId
	 *            groupId
	 * @param startAt
	 *            Starting at
	 * @param amount
	 *            amount
	 * @param order
	 *            order
	 * @return list of question
	 */
	public List<ForumQuestion> listQuestionsInGroup(final long groupId, int startAt, int amount, QuestionOrder order)
	{
		return getSession().createCriteria(ForumQuestion.class).add(Restrictions.eq("group.id", groupId))
				.setFirstResult(startAt).setMaxResults(amount).addOrder(order.getOrder()).list();
	}
}
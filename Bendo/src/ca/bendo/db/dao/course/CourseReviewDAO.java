/**
 * 
 */
package ca.bendo.db.dao.course;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.course.CourseReview;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>CourseReviewReviewDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class CourseReviewDAO extends HibernateDAO<CourseReview>
{
	/**
	 * 
	 */
	public CourseReviewDAO()
	{
		setType(CourseReview.class);

	}
	/**
	 * @param courseId
	 *            Course Id
	 * @return CourseReviews in the university given
	 */
	public List<CourseReview> getCourseReview(final long courseId)
	{
		Filter filter = getSession().enableFilter("languageId");
		filter.setParameter("param", getLanguageId());

		@SuppressWarnings("unchecked")
		List<CourseReview> profs = getSession().createCriteria(CourseReview.class)
				.add(Restrictions.eq("course.id", courseId)).list();
		return profs;
	}
	
	/**
	 * @param amount
	 *            return a list with a maximum of amount review
	 * 
	 * @param courseId
	 *            Course Id
	 * @return CourseReviews in the university given
	 */
	public List<CourseReview> listLastCourseReview(final long courseId, final int amount)
	{
		return listLastCourseReview(courseId, 0, amount);
	}

	/**
	 * @param start
	 *            start with the nth review
	 * @param amount
	 *            return a list with a maximum of amount review
	 * 
	 * @param courseId
	 *            Course Id
	 * @return CourseReviews in the university given
	 */
	public List<CourseReview> listLastCourseReview(final long courseId, final int start, final int amount)
	{
		Filter filter = getSession().enableFilter("languageId");
		filter.setParameter("param", getLanguageId());

		@SuppressWarnings("unchecked")
		List<CourseReview> profs = getSession().createCriteria(CourseReview.class)
				.add(Restrictions.eq("course.id", courseId)).addOrder(Order.desc("date")).setFirstResult(start)
				.setMaxResults(amount).list();
		return profs;
	}

}

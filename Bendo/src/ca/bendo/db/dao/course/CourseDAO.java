/**
 * 
 */
package ca.bendo.db.dao.course;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.course.Course;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>CourseDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class CourseDAO extends HibernateDAO<Course>
{
	/**
	 * 
	 */
	public CourseDAO()
	{
		setType(Course.class);
	}

	/**
	 * @param universityId
	 *            University Id
	 * @return Courses in the university given
	 */
	public List<Course> listCourseInUniversity(final long universityId)
	{

		Filter filter = getSession().enableFilter("languageId");
		filter.setParameter("param", getLanguageId());

		@SuppressWarnings("unchecked")
		List<Course> courses = getSession().createCriteria(Course.class)
				.add(Restrictions.eq("university.id", universityId)).list();
		return courses;
	}

	/**
	 * @param name
	 *            name
	 * @return list of university satifying the request
	 */
	@SuppressWarnings("unchecked")
	public List<Course> listCourseLike(final String name)
	{
		String like = "%" + name + "%";
		Filter filter = getSession().enableFilter("languageId");
		filter.setParameter("param", getLanguageId());
		Criterion restriction = Restrictions.or(Restrictions.like("name", like), Restrictions.like("code", like));
		return (List<Course>) getSession().createCriteria(Course.class).add(restriction).addOrder(Order.asc("name"))
				.list();

	}

	/**
	 * @param name
	 *            name
	 * @param maxResults
	 *            Maximum number of result
	 * @return list of university satifying the request
	 */
	@SuppressWarnings("unchecked")
	public List<Course> listCourseLikeMaxResults(final String name, final int maxResults)
	{
		String like = "%" + name + "%";
		Filter filter = getSession().enableFilter("languageId");
		filter.setParameter("param", getLanguageId());
		Criterion restriction = Restrictions.or(Restrictions.like("name", like), Restrictions.like("code", like));
		return (List<Course>) getSession().createCriteria(Course.class).add(restriction).addOrder(Order.asc("name"))
				.setMaxResults(maxResults).list();
	}

	/**
	 * @param name
	 *            name
	 * @param firstResult
	 *            First result
	 * @param maxResults
	 *            Maximum number of result
	 * @return list of university satifying the request
	 */
	@SuppressWarnings("unchecked")
	public List<Course> listCourseLikeMaxResults(final String name, final int firstResult, final int maxResults)
	{
		String like = "%" + name + "%";
		Filter filter = getSession().enableFilter("languageId");
		filter.setParameter("param", getLanguageId());
		Criterion restriction = Restrictions.or(Restrictions.like("name", like), Restrictions.like("code", like));
		return (List<Course>) getSession().createCriteria(Course.class).add(restriction).addOrder(Order.asc("name"))
				.setFirstResult(firstResult).setMaxResults(maxResults).list();
	}

}

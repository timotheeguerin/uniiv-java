/**
 * 
 */
package ca.bendo.db.dao.course;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.course.CourseRating;
import ca.bendo.db.entity.course.CourseRatingAverage;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>CourseRatingDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class CourseRatingDAO extends HibernateDAO<CourseRating>
{
	/**
	 * 
	 */
	public CourseRatingDAO()
	{
		setType(CourseRating.class);
	}

	/**
	 * 
	 * @param courseId
	 *            prof id
	 * @return ratings
	 */
	public CourseRatingAverage getCourseRatingsMean(final long courseId)
	{
		Filter filter = getSession().enableFilter("languageId");
		filter.setParameter("param", getLanguageId());

		@SuppressWarnings("unchecked")
		List<CourseRating> ratings = getSession()
				.createCriteria(CourseRating.class)
				.createAlias("review", "review")
				.createAlias("type", "type")
				.createAlias("review.course", "course")
				.add(Restrictions.eq("course.id", courseId))
				.setProjection(
						Projections.projectionList().add(Projections.avg("value"), "value")
								.add(Projections.groupProperty("type"), "type"))
				.setResultTransformer(Transformers.aliasToBean(CourseRating.class)).list();

		CourseRatingAverage average = new CourseRatingAverage();
		average.setRatings(ratings);
		return average;
	}

	/**
	 * 
	 * @param courseId
	 *            prof id
	 * @return ratings
	 */
	public double getCourseAverage(final long courseId)
	{
		Filter filter = getSession().enableFilter("languageId");
		filter.setParameter("param", getLanguageId());

		double average = (Double) getSession().createCriteria(CourseRating.class).createAlias("review", "review")
				.createAlias("type", "type").createAlias("review.course", "course")
				.add(Restrictions.eq("course.id", courseId))
				.setProjection(Projections.projectionList().add(Projections.avg("value")))
				.setResultTransformer(Transformers.aliasToBean(CourseRating.class)).uniqueResult();

		return average;
	}

}

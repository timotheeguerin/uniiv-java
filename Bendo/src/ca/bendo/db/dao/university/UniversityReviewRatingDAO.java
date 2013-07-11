/**
 * 
 */
package ca.bendo.db.dao.university;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.university.UniversityReviewRating;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UniversityReviewRatingDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class UniversityReviewRatingDAO extends HibernateDAO<UniversityReviewRating>
{
	/**
	 * 
	 */
	public UniversityReviewRatingDAO()
	{
		setType(UniversityReviewRating.class);
	}

	/**
	 * Return the average of the given rating for the given university.
	 * 
	 * @param universityId
	 *            universityId
	 * @param ratingId
	 *            rating id
	 * @return ratings
	 */
	public double getUniversityRatingAverage(final long universityId, final long ratingId)
	{

		Criterion restriction = Restrictions.and(Restrictions.eq("university.id", universityId),
				Restrictions.eq("type.id", ratingId));
		Double average = (Double) getSession().createCriteria(UniversityReviewRating.class)
				.createAlias("review", "review").createAlias("type", "type")
				.createAlias("review.university", "university").add(restriction)
				.setProjection(Projections.projectionList().add(Projections.avg("value"))).uniqueResult();

		if (average == null)
		{
			return 0;
		} else
		{
			return average;
		}
	}
}

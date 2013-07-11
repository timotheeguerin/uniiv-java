/**
 * 
 */
package ca.bendo.db.dao.professor;

import java.util.List;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.professor.ProfessorRating;
import ca.bendo.db.entity.professor.ProfessorRatingAverage;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ProfessorRatingDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class ProfessorRatingDAO extends HibernateDAO<ProfessorRating>
{
	/**
	 * 
	 */
	public ProfessorRatingDAO()
	{
		setType(ProfessorRating.class);
	}

	/**
	 * @return list all rating
	 */
	@SuppressWarnings("unchecked")
	public List<ProfessorRating> listProfessorRating()
	{
		return getSession().createCriteria(ProfessorRating.class).list();
	}

	/**
	 * 
	 * @param professorId
	 *            prof id
	 * @return ratings
	 */
	public ProfessorRatingAverage getProfessorRatingsMean(final long professorId)
	{
		@SuppressWarnings("unchecked")
		List<ProfessorRating> ratings = getSession()
				.createCriteria(ProfessorRating.class)
				.createAlias("review", "review")
				.createAlias("type", "type")
				.createAlias("review.professor", "professor")
				.add(Restrictions.eq("professor.id", professorId))
				.setProjection(
						Projections.projectionList().add(Projections.avg("value"), "value")
								.add(Projections.groupProperty("type"), "type"))
				.setResultTransformer(Transformers.aliasToBean(ProfessorRating.class)).list();

		ProfessorRatingAverage average = new ProfessorRatingAverage();
		average.setRatings(ratings);
		return average;
	}

	/**
	 * Return the avrage of all the ratings of a prof.
	 * 
	 * @param professorId
	 *            prof id
	 * @return ratings
	 */
	public double getProfessorAverage(final long professorId)
	{

		Double average = (Double) getSession().createCriteria(ProfessorRating.class).createAlias("review", "review")
				.createAlias("type", "type").createAlias("review.professor", "professor")
				.add(Restrictions.eq("professor.id", professorId))
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

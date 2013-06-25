/**
 * 
 */
package ca.bendo.db.dao.university;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.university.University;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UniversityDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */

@Repository
@Transactional
public class UniversityDAO extends HibernateDAO<University>
{
	/**
	 * 
	 */
	public UniversityDAO()
	{
		setType(University.class);
	}

	/**
	 * @return a list of all universities
	 */
	@SuppressWarnings("unchecked")
	public List<University> listUniversities()
	{
		Filter filter = getSession().enableFilter("languageId");
		filter.setParameter("param", getLanguageId());
		return (List<University>) getSession().createCriteria(University.class).addOrder(Order.asc("name")).list();
	}

	/**
	 * @param query
	 *            Query
	 * @return list of university satifying the request
	 */
	@SuppressWarnings("unchecked")
	public List<University> search(final UniversityQuery query)
	{
		Filter filter = getSession().enableFilter("languageId");
		filter.setParameter("param", getLanguageId());

		Criteria criteria = getSession().createCriteria(University.class);
		query.getRestrictions(criteria);
		return (List<University>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		// return (List<Integer>)
		// criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

	}

	/**
	 * @param query
	 *            Query
	 * @return list of university satifying the request
	 */
	@SuppressWarnings("unchecked")
	public List<Long> search2(final UniversityQuery query)
	{
		Filter filter = getSession().enableFilter("languageId");
		filter.setParameter("param", getLanguageId());

		Criteria criteria = getSession().createCriteria(University.class);
		query.getRestrictions(criteria);
		return (List<Long>) criteria.setProjection(Projections.property("id"))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		// return (List<Integer>)
		// criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

	}

	/**
	 * @param query
	 *            Query
	 * @return list of university satifying the request
	 */
	@SuppressWarnings("unchecked")
	public List<Long> restrictWithLocation(final UniversityQuery query)
	{
		Filter filter = getSession().enableFilter("languageId");
		filter.setParameter("param", getLanguageId());

		Criteria criteria = getSession().createCriteria(University.class);
		query.setupLocation(criteria);
		return (List<Long>) criteria.setProjection(Projections.property("id"))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		// return (List<Integer>)
		// criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}

	/**
	 * @param programs
	 *            Query
	 * @return list of university satifying the request
	 */
	@SuppressWarnings("unchecked")
	public List<Long> restrictWithPrograms(final List<Long> uniIds, final UniversityQuery query)
	{
		Filter filter = getSession().enableFilter("languageId");
		filter.setParameter("param", getLanguageId());

		Criteria criteria = getSession().createCriteria(University.class);
		query.getProgramRestrictions(criteria);
		return (List<Long>) criteria.add(Restrictions.in("id", uniIds)).setProjection(Projections.property("id"))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		// return (List<Integer>)
		// criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}

	/**
	 * @param universityName
	 *            university name
	 * @return list of university satifying the request
	 */
	@SuppressWarnings("unchecked")
	public List<University> listUniversityLike(final String universityName)
	{
		String like = "%" + universityName + "%";
		Filter filter = getSession().enableFilter("languageId");
		filter.setParameter("param", getLanguageId());
		return (List<University>) getSession().createCriteria(University.class).add(Restrictions.like("name", like))
				.addOrder(Order.asc("name")).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

	}

	/**
	 * 
	 * @param universityName
	 *            university name
	 * @param maxResults
	 *            Maximum number of result
	 * @return list of university satifying the request
	 */
	@SuppressWarnings("unchecked")
	public List<University> listUniversityLikeMaxResults(final String universityName, final int maxResults)
	{
		String like = "%" + universityName + "%";
		Filter filter = getSession().enableFilter("languageId");
		filter.setParameter("param", getLanguageId());
		return (List<University>) getSession().createCriteria(University.class).add(Restrictions.like("name", like))
				.addOrder(Order.asc("name")).setMaxResults(maxResults)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

	}

	/**
	 * 
	 * @param universityName
	 *            university name
	 * @param firstResult
	 *            First result to display
	 * @param maxResults
	 *            Maximum number of result
	 * @return list of university satifying the request
	 */
	@SuppressWarnings("unchecked")
	public List<University> listUniversityLikeFromMaxResults(final String universityName, final int firstResult,
			final int maxResults)
	{
		String like = "%" + universityName + "%";
		Filter filter = getSession().enableFilter("languageId");
		filter.setParameter("param", getLanguageId());
		return (List<University>) getSession().createCriteria(University.class).add(Restrictions.like("name", like))
				.addOrder(Order.asc("name")).setFirstResult(firstResult).setMaxResults(maxResults)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

	}
}

/**
 * 
 */
package ca.bendo.db.dao.professor;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.professor.Professor;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ProfessorDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class ProfessorDAO extends HibernateDAO<Professor>
{
	/**
	 * 
	 */
	public ProfessorDAO()
	{
		setType(Professor.class);
	}

	/**
	 * @return list all professor
	 */
	@SuppressWarnings("unchecked")
	public List<Professor> listProfessor()
	{
		return getSession().createCriteria(Professor.class).list();
	}

	/**
	 * @param name
	 *            name
	 * @return list of university satifying the request
	 */
	@SuppressWarnings("unchecked")
	public List<Professor> listProfessorLike(final String name)
	{
		Criterion restriction = getProfLikeCriterion(name);
		return (List<Professor>) getSession().createCriteria(Professor.class).add(restriction)
				.addOrder(Order.asc("firstName")).addOrder(Order.asc("lastName"))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

	}

	/**
	 * 
	 * @param name
	 *            Name
	 * @return criterion
	 */
	public Criterion getProfLikeCriterion(final String name)
	{
		System.out.println("PROF LIKE: " + name);
		Criterion restriction = null;
		String[] words = name.split("\\s+");
		for (String word : words)
		{
			System.out.println("WORD: " + word);
			String like = "%" + word + "%";
			Criterion criterion = Restrictions.or(Restrictions.like("firstName", like),
					Restrictions.like("lastName", like));
			if (restriction == null)
			{
				restriction = criterion;
			} else
			{
				restriction = Restrictions.and(restriction, criterion);
			}
		}
		return restriction;
	}

	/**
	 * @param name
	 *            name
	 * @param maxResults
	 *            Maximum number of results
	 * @return list of university satifying the request
	 */
	@SuppressWarnings("unchecked")
	public List<Professor> listProfessorLikeMaxResults(final String name, final int maxResults)
	{
		Criterion restriction = getProfLikeCriterion(name);
		return (List<Professor>) getSession().createCriteria(Professor.class).add(restriction)
				.addOrder(Order.asc("firstName")).addOrder(Order.asc("lastName")).setMaxResults(maxResults)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

	}

	/**
	 * @param name
	 *            name
	 * @param firstResult
	 *            First result
	 * @param maxResults
	 *            Maximum number of results
	 * @return list of university satifying the request
	 */
	@SuppressWarnings("unchecked")
	public List<Professor> listProfessorLikeFromMaxResults(final String name, final int firstResult,
			final int maxResults)
	{
		Criterion restriction = getProfLikeCriterion(name);
		return (List<Professor>) getSession().createCriteria(Professor.class).add(restriction)
				.addOrder(Order.asc("firstName")).addOrder(Order.asc("lastName")).setFirstResult(firstResult)
				.setMaxResults(maxResults).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

	}
}

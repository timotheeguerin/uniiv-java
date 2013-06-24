/**
 * 
 */
package ca.bendo.db.dao.rating;

import java.util.Collection;
import java.util.List;

import org.hibernate.Filter;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.rating.UniversityRating;
import ca.bendo.db.entity.rating.UniversityRatingMethod;
import ca.bendo.db.entity.rating.UniversityRatingMethodElement;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>SoftRatingType</b>
 *          <p>
 *          </p>
 * 
 * 
 */

@Repository
public class SoftRatingDAO extends HibernateDAO<UniversityRating>
{
	/**
	 * 
	 */
	public SoftRatingDAO()
	{
		setType(UniversityRating.class);
	}

	
	/**
	 * @param set
	 *            ids of the ratings to get
	 * @return All soft ratings with the ids given
	 */
	@SuppressWarnings("unchecked")
	public List<UniversityRating> listSoftRatingsWithIds(final Collection<Integer> set)
	{
		Filter filter = getSession().enableFilter("languageId");
		filter.setParameter("param", getLanguageId());
		return (List<UniversityRating>) getSession().createCriteria(UniversityRating.class)
				.add(Restrictions.in("id", set)).list();
	}

	/**
	 * 
	 * @return All soft rating type.
	 */
	@SuppressWarnings("unchecked")
	public List<UniversityRatingMethod> listTypes()
	{
		Filter filter = getSession().enableFilter("languageId");
		filter.setParameter("param", getLanguageId());
		return (List<UniversityRatingMethod>) getSession().createCriteria(UniversityRatingMethod.class).list();
	}

	/**
	 * 
	 * @return All soft rating type.
	 */
	@SuppressWarnings("unchecked")
	public List<UniversityRating> listForReview()
	{
		Filter filter = getSession().enableFilter("languageId");
		filter.setParameter("param", getLanguageId());
		return (List<UniversityRating>) getSession().createCriteria(UniversityRating.class)
				.createAlias("form", "form").add(Restrictions.eq("form.name", "university")).list();
	}

	/**
	 * 
	 * @return All soft rating type.
	 */
	@SuppressWarnings("unchecked")
	public List<UniversityRatingMethodElement> listAllElements()
	{
		Filter filter = getSession().enableFilter("languageId");
		filter.setParameter("param", getLanguageId());
		return (List<UniversityRatingMethodElement>) getSession().createCriteria(UniversityRatingMethodElement.class)
				.list();
	}
}

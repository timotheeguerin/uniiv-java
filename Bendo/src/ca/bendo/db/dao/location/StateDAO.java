/**
 * 
 */
package ca.bendo.db.dao.location;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.location.State;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>StateDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class StateDAO extends HibernateDAO<State>
{
	/**
	 * 
	 */
	public StateDAO()
	{
		setType(State.class);
	}

	/**
	 * @return a list of countries
	 */
	@SuppressWarnings("unchecked")
	public List<State> listStates()
	{
		Filter filter = getSession().enableFilter("languageId");
		filter.setParameter("param", getLanguageId());
		return (List<State>) getSession().createCriteria(State.class).list();
	}

	/**
	 * @param idCanada
	 *            Country Id
	 * @return States in the country
	 */
	public List<State> getStateInCountry(final long idCanada)
	{
		Filter filter = getSession().enableFilter("languageId");
		filter.setParameter("param", getLanguageId());

		@SuppressWarnings("unchecked")
		List<State> states = getSession().createCriteria(State.class).add(Restrictions.eq("country.id", idCanada))
				.list();
		return states;
	}

}

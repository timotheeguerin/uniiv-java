/**
 * 
 */
package ca.bendo.db.dao.location;

import java.util.List;

import org.hibernate.Filter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.location.Country;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>CountryDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class CountryDAO extends HibernateDAO<Country>
{
	/**
	 * 
	 */
	public CountryDAO()
	{
		setType(Country.class);
	}

	/**
	 * @return a list of countries
	 */
	@SuppressWarnings("unchecked")
	public final List<Country> listCountries()
	{
		System.out.println("fhieshfi: " + getLanguageId());
		Filter filter = getSession().enableFilter("languageId");
		filter.setParameter("param", getLanguageId());
		return (List<Country>) getSession().createCriteria(Country.class).list();
	}

}

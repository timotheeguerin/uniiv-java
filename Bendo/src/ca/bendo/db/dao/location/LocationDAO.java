/**
 * 
 */
package ca.bendo.db.dao.location;

import java.util.List;

import org.hibernate.Filter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.location.Location;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>LocationDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class LocationDAO extends HibernateDAO<Location>
{
	/**
	 * 
	 */
	public LocationDAO()
	{
		setType(Location.class);
	}

	/**
	 * @return a list of locations
	 */
	@SuppressWarnings("unchecked")
	public List<Location> listLocations()
	{
		Filter filter = getSession().enableFilter("languageId");
		filter.setParameter("param", getLanguageId());
		return (List<Location>) getSession().createCriteria(Location.class).list();
	}

}

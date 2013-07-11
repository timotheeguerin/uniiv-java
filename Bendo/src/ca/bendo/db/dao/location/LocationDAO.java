/**
 * 
 */
package ca.bendo.db.dao.location;

import java.util.List;

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
		return (List<Location>) getSession().createCriteria(Location.class).list();
	}

}

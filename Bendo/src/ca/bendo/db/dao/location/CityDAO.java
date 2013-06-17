/**
 * 
 */
package ca.bendo.db.dao.location;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.location.City;

/**
 * @author Timoth�e Gu�rin
 * @version Bendo
 * 
 *          <b>CityDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class CityDAO extends HibernateDAO<City>
{
	/**
	 * 
	 */
	public CityDAO()
	{
		setType(City.class);
	}
}

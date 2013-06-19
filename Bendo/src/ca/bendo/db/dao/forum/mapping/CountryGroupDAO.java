/**
 * 
 */
package ca.bendo.db.dao.forum.mapping;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.forum.mapping.CountryGroup;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>CityGroupDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class CountryGroupDAO extends HibernateDAO<CountryGroup>
{
	/**
	 * 
	 */
	public CountryGroupDAO()
	{
		setType(CountryGroup.class);
	}
}
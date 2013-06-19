/**
 * 
 */
package ca.bendo.db.dao.forum.mapping;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.forum.mapping.CityGroup;

/**
 * @author Timoth�e Gu�rin
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
public class CityGroupDAO extends HibernateDAO<CityGroup>
{
	/**
	 * 
	 */
	public CityGroupDAO()
	{
		setType(CityGroup.class);
	}
}

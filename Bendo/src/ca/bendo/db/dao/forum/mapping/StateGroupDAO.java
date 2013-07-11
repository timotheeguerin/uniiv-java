/**
 * 
 */
package ca.bendo.db.dao.forum.mapping;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.forum.mapping.StateGroup;

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
public class StateGroupDAO extends HibernateDAO<StateGroup>
{
	/**
	 * 
	 */
	public StateGroupDAO()
	{
		setType(StateGroup.class);
	}
}

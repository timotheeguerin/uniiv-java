/**
 * 
 */
package ca.bendo.db.dao.forum.mapping;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.forum.mapping.UniversityGroup;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UniversityGroupDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */

@Repository
@Transactional
public class UniversityGroupDAO extends HibernateDAO<UniversityGroup>
{
	/**
 * 
 */
	public UniversityGroupDAO()
	{
		setType(UniversityGroup.class);
	}
}

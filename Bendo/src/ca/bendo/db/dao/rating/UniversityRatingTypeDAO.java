/**
 * 
 */
package ca.bendo.db.dao.rating;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.rating.UniversityRatingMethod;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UniversityRatingTypeDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class UniversityRatingTypeDAO extends HibernateDAO<UniversityRatingMethod>
{
	/**
	 * 
	 */
	public UniversityRatingTypeDAO()
	{
		setType(UniversityRatingMethod.class);
	}
}

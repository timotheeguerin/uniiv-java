/**
 * 
 */
package ca.bendo.db.dao.course;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.course.CourseRatingType;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>CourseRatingTypeDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class CourseRatingTypeDAO extends HibernateDAO<CourseRatingType>
{
	/**
	 * 
	 */
	public CourseRatingTypeDAO()
	{
		setType(CourseRatingType.class);
	}

}

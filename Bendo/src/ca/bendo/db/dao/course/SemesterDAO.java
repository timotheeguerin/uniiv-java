/**
 * 
 */
package ca.bendo.db.dao.course;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.course.Semester;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>SemesterDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class SemesterDAO extends HibernateDAO<Semester>
{
	/**
	 * 
	 */
	public SemesterDAO()
	{
		setType(Semester.class);
	}

	/**
	 * 
	 * @param name
	 *            Name
	 * @return semester with the given name
	 */
	public Semester getByName(final String name)
	{
		return (Semester) getSession().createCriteria(Semester.class).add(Restrictions.eq("name", name));
	}
}

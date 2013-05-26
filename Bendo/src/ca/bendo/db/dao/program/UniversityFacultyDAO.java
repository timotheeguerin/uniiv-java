/**
 * 
 */
package ca.bendo.db.dao.program;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.program.UniversityFaculty;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UniversityFacultyDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class UniversityFacultyDAO extends HibernateDAO<UniversityFaculty>
{
	/**
	 * 
	 */
	public UniversityFacultyDAO()
	{
		setType(UniversityFaculty.class);
	}
}

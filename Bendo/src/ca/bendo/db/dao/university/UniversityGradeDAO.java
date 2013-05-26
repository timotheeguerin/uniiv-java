/**
 * 
 */
package ca.bendo.db.dao.university;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.rating.UniversityGrade;

/**
 * @author Timoth�e Gu�rin
 * @version Bendo
 * 
 *          <b>UniversityGradeDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class UniversityGradeDAO extends HibernateDAO<UniversityGrade>
{
	/**
	 * 
	 */
	public UniversityGradeDAO()
	{
		setType(UniversityGrade.class);
	}
}

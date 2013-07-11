/**
 * 
 */
package ca.bendo.db.dao.university;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.rating.UniversityGrade;
import ca.bendo.db.entity.rating.UniversityRating;

/**
 * @author Timothée Guérin
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

	/**
	 * @param universityId
	 *            Id of the university
	 * @return softratings of the university
	 */
	@SuppressWarnings("unchecked")
	public List<UniversityGrade> listUniversityGrades(final long universityId)
	{

		return (List<UniversityGrade>) getSession().createCriteria(UniversityRating.class)
				.add(Restrictions.eq("university.id", universityId)).list();
	}

}

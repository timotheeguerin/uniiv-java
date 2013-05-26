/**
 * 
 */
package ca.bendo.db.dao.course;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.course.CourseProfessor;
import ca.bendo.db.entity.course.CourseProfessorPeriod;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>CourseProfessorPeriodDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class CourseProfessorPeriodDAO extends HibernateDAO<CourseProfessorPeriod>
{
	/**
	 * 
	 */
	public CourseProfessorPeriodDAO()
	{
		setType(CourseProfessorPeriod.class);
	}

	/**
	 * @param courseProfessor
	 *            CourseProfessor object
	 * @param semesterId
	 *            Semester id
	 * @param year
	 *            Year
	 * @return boolean if the period already exist
	 */
	public boolean periodExist(final CourseProfessor courseProfessor, final long semesterId, final int year)
	{
		Criterion restriction = Restrictions.and(
				Restrictions.eq("professor.id", courseProfessor.getProfessor().getId()),
				Restrictions.eq("course.id", courseProfessor.getCourse().getId()),
				Restrictions.eq("semester.id", semesterId), Restrictions.eq("period.year", year));
		CourseProfessor result = (CourseProfessor) getSession().createCriteria(CourseProfessor.class)
				.createAlias("periods", "period").createAlias("period.semester", "semester").add(restriction)
				.uniqueResult();
		return result != null;
	}
}

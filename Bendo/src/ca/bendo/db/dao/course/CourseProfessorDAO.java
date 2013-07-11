/**
 * 
 */
package ca.bendo.db.dao.course;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.course.CourseProfessor;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>CourseProfessorDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class CourseProfessorDAO extends HibernateDAO<CourseProfessor>
{
	/**
	 * 
	 */
	public CourseProfessorDAO()
	{
		setType(CourseProfessor.class);
	}

	/**
	 * @param courseId
	 *            Course id
	 * @param professorId
	 *            Professor id
	 * @return the course professor for the given ids
	 */
	public CourseProfessor getByProfessorAndCourse(final long courseId, final long professorId)
	{
		Criterion restriction = Restrictions.and(Restrictions.eq("course.id", courseId),
				Restrictions.eq("professor.id", professorId));
		return (CourseProfessor) getSession().createCriteria(CourseProfessor.class).add(restriction).uniqueResult();
	}

	/**
	 * @param courseId
	 *            Course id
	 * @return course
	 */
	@SuppressWarnings("unchecked")
	public List<CourseProfessor> listCourseProfessor(final long courseId)
	{
		Criterion restriction = Restrictions.eq("course.id", courseId);
		return (List<CourseProfessor>) getSession().createCriteria(CourseProfessor.class).add(restriction).list();
	}

	/**
	 * @param professorId
	 *            professor id
	 * @return course
	 */
	@SuppressWarnings("unchecked")
	public List<CourseProfessor> listProfessorCourse(final long professorId)
	{
		Criterion restriction = Restrictions.eq("professor.id", professorId);
		return (List<CourseProfessor>) getSession().createCriteria(CourseProfessor.class).add(restriction).list();
	}
}

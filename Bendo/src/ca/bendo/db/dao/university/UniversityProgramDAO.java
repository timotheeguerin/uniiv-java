/**
 * 
 */
package ca.bendo.db.dao.university;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.program.Program;
import ca.bendo.db.entity.program.UniversityProgram;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UniversityProgramDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class UniversityProgramDAO extends HibernateDAO<UniversityProgram>
{
	/**
	 * 
	 */
	public UniversityProgramDAO()
	{
		setType(UniversityProgram.class);
	}

	/**
	 * 
	 * @param universityId
	 *            Id of the university
	 * @return list of programs
	 */
	@SuppressWarnings("unchecked")
	public List<Program> listUniversityPrograms(final long universityId)
	{

		return (List<Program>) getSession().createCriteria(UniversityProgram.class)
				.add(Restrictions.eq("university.id", universityId))
				.setResultTransformer(Transformers.aliasToBean(Program.class)).list();
	}
}

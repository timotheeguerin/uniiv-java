/**
 * 
 */
package ca.bendo.db.dao.program;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.program.UniversityProgram;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ProgramTestDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Transactional
@Repository
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
	 * @return the list of all programs
	 */
	@SuppressWarnings("unchecked")
	public List<UniversityProgram> listPrograms()
	{
		Filter filter = getSession().enableFilter("languageId");
		filter.setParameter("param", getLanguageId());
		return (List<UniversityProgram>) getSession().createCriteria(UniversityProgram.class)
				.addOrder(Order.asc("translation")).list();
	}

}

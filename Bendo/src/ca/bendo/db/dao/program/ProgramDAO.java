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
import ca.bendo.db.entity.program.Program;

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
public class ProgramDAO extends HibernateDAO<Program>
{
	/**
	 * 
	 */
	public ProgramDAO()
	{
		setType(Program.class);
	}

	/**
	 * 
	 * @return the list of all programs
	 */
	@SuppressWarnings("unchecked")
	public List<Program> listPrograms()
	{
		
		return (List<Program>) getSession().createCriteria(Program.class)
				.addOrder(Order.asc("translation")).list();
	}

}

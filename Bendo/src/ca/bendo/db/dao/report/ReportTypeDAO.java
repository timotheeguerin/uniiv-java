/**
 * 
 */
package ca.bendo.db.dao.report;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.report.ReportType;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ReportTypeDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class ReportTypeDAO extends HibernateDAO<ReportType>
{
	/**
	 * 
	 */
	public ReportTypeDAO()
	{
		setType(ReportType.class);
	}

	/**
	 * @param <T>
	 *            class type
	 * @param clazz
	 *            Class
	 * @return reporttype for the given class
	 */
	public <T> ReportType getByClass(final Class<T> clazz)
	{
		return (ReportType) getSession().createCriteria(ReportType.class)
				.add(Restrictions.eq("name", clazz.getSimpleName())).uniqueResult();
	}
}

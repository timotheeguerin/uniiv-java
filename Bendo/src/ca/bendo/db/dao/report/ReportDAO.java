/**
 * 
 */
package ca.bendo.db.dao.report;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.report.Report;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ReportDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class ReportDAO extends HibernateDAO<Report>
{
	/**
	 * 
	 */
	public ReportDAO()
	{
		setType(Report.class);
	}
}

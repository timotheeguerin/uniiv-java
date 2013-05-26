/**
 * 
 */
package ca.bendo.db.dao.report;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.report.ReportComment;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ReportComment</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class ReportCommentDAO extends HibernateDAO<ReportComment>
{
	/**
	 * 
	 */
	public ReportCommentDAO()
	{
		setType(ReportComment.class);
	}
}
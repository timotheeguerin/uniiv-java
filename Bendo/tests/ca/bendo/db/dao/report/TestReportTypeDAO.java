/**
 * 
 */
package ca.bendo.db.dao.report;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.entity.professor.Professor;
import ca.bendo.db.entity.report.ReportType;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TestReportTypeDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Transactional
public class TestReportTypeDAO
{
	/**
	 * 
	 */
	@Autowired
	private ReportTypeDAO reportTypeDAO;

	/**
	 *
	 */
	@Test
	public void testGetByClass()
	{
		reportTypeDAO.enableTranslation(1L);
		ReportType type = reportTypeDAO.getByClass(Professor.class);
		assertTrue(type != null);
		System.out.printf("%-4d %s", type.getId(), type.getName());
	}
}

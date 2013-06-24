/**
 * 
 */
package ca.bendo.db.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.program.ProgramDAO;
import ca.bendo.db.entity.program.Program;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>Test</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@TestExecutionListeners({ TransactionalTestExecutionListener.class })
public class DTest
{

	/**
	 * 
	 */
	@Autowired
	private ProgramDAO dao;

	/**
	 * 
	 */
	@Test
	public void test()
	{
		System.out.println("test");
		List<Program> pl = dao.listPrograms();
		System.out.println("test");
		for (Program p : pl)
		{
			System.out.println("P: " + p.getName());
		}
	}

	/**
	 * @return the dao
	 */
	public ProgramDAO getDao()
	{
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(final ProgramDAO dao)
	{
		this.dao = dao;
	}
}

/**
 * 
 */
package ca.bendo.db.dao.fees;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.entity.fees.UniversityFees;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TestUniFeesDAO</b>
 *          <p>
 *          </p>
 * 
 * @see UniFeesDAO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Transactional
public class TestUniFeesDAO
{
	/**
	 * 
	 */
	@Autowired
	private UniFeesDAO uniFeesDAO;

	/**
	 * Test the listUniversityFees function.
	 * 
	 * @see UniFeesDAO#listUniversityFees()
	 */
	@Test
	public void testListUniversityFees()
	{
		List<UniversityFees> l = uniFeesDAO.listUniversityFees();
		assertTrue(l != null);
		System.out.println("------------------------------------------");
		System.out.println("Tuition Types: ");
		for (UniversityFees fees : l)
		{
			System.out.printf("%-4s", fees.getId());
			assertTrue(fees.getOtherFees() != null);
			System.out.printf("%s\n", fees.toString());
		}

	}

	/**
	 * Test the getUniversityFeess function.
	 * 
	 * @see UniFeesDAO#getUniversityFees(int)
	 */
	@Test
	public void getUniversityFees()
	{

		UniversityFees fees = uniFeesDAO.getById(1L);
		assertTrue(fees != null);
		System.out.println("------------------------------------------");
		System.out.println("University fee 1: ");
		System.out.printf("%-4s", fees.getId());
		assertTrue(fees.getOtherFees() != null);
		System.out.printf("%s\n", fees.toString());

	}

	/**
	 * @return the uniFeesDAO
	 */
	public final UniFeesDAO getUniFeesDAO()
	{
		return uniFeesDAO;
	}

	/**
	 * @param uniFeesDAO
	 *            the uniFeesDAO to set
	 */
	public final void setUniFeesDAO(final UniFeesDAO uniFeesDAO)
	{
		this.uniFeesDAO = uniFeesDAO;
	}
}

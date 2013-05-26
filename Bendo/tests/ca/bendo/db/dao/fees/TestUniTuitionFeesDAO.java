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

import ca.bendo.db.entity.fees.UniversityTuitionFees;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TestUniTuitionFeesDAO</b>
 *          <p>
 *          </p>
 * 
 * @see UniTuitionFeesDAO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Transactional
public class TestUniTuitionFeesDAO
{

	/**
	 * 
	 */
	@Autowired
	private UniTuitionFeesDAO tuitionFeesDAO;

	/**
	 * Test the listTuitionFees method.
	 * 
	 * @see UniTuitionFeesDAO#listTuitionFees()
	 */
	@Test
	public void testListTuitionFees()
	{

		List<UniversityTuitionFees> l = tuitionFeesDAO.listTuitionFees();
		assertTrue(l != null);
		System.out.println("------------------------------------------");
		System.out.println("Tuition Types: ");
		for (UniversityTuitionFees fees : l)
		{
			System.out.printf("%-4s", fees.getId());
			System.out.printf("%-8s %s\n", fees.getValue(), fees.getFees().getId());
		}
	}
	

	/**
	 * Test the listTuitionFees method.
	 * 
	 * @see UniTuitionFeesDAO#listTuitionFees()
	 */
	@Test
	public void testListTuitionFeesForFees()
	{

		List<UniversityTuitionFees> l = tuitionFeesDAO.listTuitionFeesForFees(1);
		assertTrue(l != null);
		System.out.println("------------------------------------------");
		System.out.println("Tuition Types: ");
		for (UniversityTuitionFees fees : l)
		{
			System.out.printf("%-4s", fees.getId());
			System.out.printf("%-8s %s\n", fees.getValue(), fees.getFees().getId());
		}
	}

}

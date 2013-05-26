/**
 * 
 */
package ca.bendo.university;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TestUniversityRatingsCalculator</b>
 *          <p>
 *          </p>
 * 
 * @see UniversityRatingsCalculator
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Transactional
public class TestUniversityRatingsCalculator
{

	/**
	 * 
	 */
	@Autowired
	private UniversityRatingsCalculator calculator;

	/**
	 * * @see UniversityRatingsCalculator#updateAllRatings()
	 */
	@Test
	public void testUpdateAllRatings()
	{
		calculator.updateRatings(1L);
	}
}

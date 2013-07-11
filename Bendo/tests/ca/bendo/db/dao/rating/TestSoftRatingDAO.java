/**
 * 
 */
package ca.bendo.db.dao.rating;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.entity.rating.UniversityRating;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>SoftRatingTest</b>
 *          <p>
 *          </p>
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Transactional
public class TestSoftRatingDAO
{

	/**
		 * 
		 */
	@Autowired
	private SoftRatingDAO softRatingDAO;

	/**
	 * Test the listUniversities method.
	 * 
	 * @see SoftRatingDAO#testListSoftRating()
	 */
	@Test
	public void testListSoftRating()
	{
		List<UniversityRating> ratings = softRatingDAO.list();
		assertTrue(ratings != null && ratings.size() > 0);

		for (UniversityRating rating : ratings)
		{
			System.out.printf("%-4s %-10s %s\n", rating.getId(), rating.getName(), rating.toString());
		}

	}

	/**
	 * Test the listUniversities method.
	 * 
	 * @see SoftRatingDAO#testListSoftRatingWithIds(List)
	 */
	@Test
	public void testListSoftRatingWithIds()
	{

		List<UniversityRating> ratings = softRatingDAO.list();
		assertTrue(ratings != null && ratings.size() > 0);

		List<Integer> ids = new ArrayList<Integer>();
		for (UniversityRating rating : ratings)
		{
			Random r = new Random();
			int val = r.nextInt(2);
			if (val == 0)
			{
				ids.add((int) rating.getId());
			}
		}

		List<UniversityRating> ratingsWithIds = softRatingDAO.listSoftRatingsWithIds(ids);
		System.out.println("-------------------------------------------");
		System.out.println("Ratings with ids(" + ids.size() + "): ");

		for (UniversityRating rating : ratingsWithIds)
		{
			System.out.printf("%-4s %-10s %s\n", rating.getId(), rating.getName(), rating.toString());
			assertTrue(ids.contains(rating.getId()));
		}

		assertTrue(ratingsWithIds != null && ratingsWithIds.size() == ids.size());
	}
}

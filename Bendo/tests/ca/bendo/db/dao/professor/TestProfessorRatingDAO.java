/**
 * 
 */
package ca.bendo.db.dao.professor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.entity.professor.ProfessorRating;
import ca.bendo.db.entity.professor.ProfessorRatingAverage;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TestProfessorRatingDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Transactional
public class TestProfessorRatingDAO
{
	/**
	 * 
	 */
	@Autowired
	private ProfessorRatingDAO professorRatingDAO;

	/**
	 * 
	 */
	@Test
	public void testGetRatingAvg()
	{
		ProfessorRatingAverage values = professorRatingDAO.getProfessorRatingsMean(1L);

		for (ProfessorRating val : values.getRatings())
		{
			System.out.println(val.getValue());
		}
	}
}

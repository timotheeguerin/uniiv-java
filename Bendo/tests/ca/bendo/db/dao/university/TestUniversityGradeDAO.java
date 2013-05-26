/**
 * 
 */
package ca.bendo.db.dao.university;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.rating.SoftRatingDAO;
import ca.bendo.db.entity.rating.UniversityGrade;
import ca.bendo.db.entity.rating.UniversityRating;
import ca.bendo.db.entity.university.University;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TestUniversityGradeDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Transactional
public class TestUniversityGradeDAO
{
	/**
	 * 
	 */
	@Autowired
	private UniversityGradeDAO universityGradeDAO;

	/**
	 * 
	 */
	@Autowired
	private UniversityDAO universityDAO;

	/**
	 * 
	 */
	@Autowired
	private SoftRatingDAO ratingDAO;

	/**
	 * Test the listUniversities method.
	 * 
	 * @see UniversityGradeDAO#list()
	 */
	@Test
	public void testList()
	{
		universityGradeDAO.setLanguageId(1);
		List<UniversityGrade> grades = universityGradeDAO.list();
		assertTrue(grades != null && grades.size() > 0);

		for (UniversityGrade grade : grades)
		{
			assertTrue(grade.getSoftRating() != null);
			System.out.printf("%-4s %-40s  %s\n", grade.getId(), grade.getSoftRating().getName(), grade
					.getUniversity().getName());
		}

	}

	/**
	 * Test the listUniversities method.
	 * 
	 * @see UniversityGradeDAO#list()
	 */
	@Test
	public void testAdd()
	{
		universityGradeDAO.setLanguageId(1);
		University university = universityDAO.getById(1L);
		UniversityRating rating = ratingDAO.getById(1L);
		UniversityGrade grade = new UniversityGrade();
		grade.setSoftRating(rating);
		grade.setValue(1);
		grade.setUniversity(university);

		universityGradeDAO.add(grade);
	}
}

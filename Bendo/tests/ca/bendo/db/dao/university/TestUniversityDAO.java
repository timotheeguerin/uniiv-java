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

import ca.bendo.db.entity.university.University;
import ca.bendo.search.handler.parser.LocationParser;
import ca.bendo.search.handler.parser.ProgramParser;
import ca.bendo.search.handler.parser.SoftRatingParser;

/**
 * @author Timoth�e Gu�rin
 * @version Bendo
 * 
 *          <b>TestUniversityDAO</b>
 *          <p>
 *          </p>
 * 
 *          Test the UniversityDAO class
 * @see UniversityDAO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Transactional
public class TestUniversityDAO
{

	/**
	 * 
	 */
	@Autowired
	private UniversityDAO universityDAO;

	/**
	 * Test the listUniversities method.
	 * 
	 * @see UniversityDAO#listUniversities()
	 */
	@Test
	public void testListUniversities()
	{
		// universityDAO.setLanguageId(1);
		// List<University> universities = universityDAO.listUniversities();
		// assertTrue(universities != null && universities.size() > 0);
		//
		// for (University university : universities)
		// {
		// assertTrue(university.getLocation() != null);
		// System.out.printf("%-4s %-40s %-50s %s\n", university.getId(),
		// university.getName(),
		// university.getWebsite(), university.getLocation());
		// }

	}

	/**
	 * Test the search method.
	 * 
	 * @see UniversityDAO#filter(List)
	 */
	@Test
	public void testSearch()
	{
		LocationParser parser = new LocationParser();
		parser.parse("54");

		ProgramParser progParser = new ProgramParser();
		progParser.parse("1,2");

		SoftRatingParser ratingParser = new SoftRatingParser();
		ratingParser.parse("1:23,2:23,3:24");

		UniversityQuery query = new UniversityQuery();
		query.setCountries(parser.getCountries());
		query.setFaculties(progParser.getFaculties());
		query.setPrograms(progParser.getPrograms());
		query.setSoftRatings(ratingParser.getSoftRatings());

		long start = System.currentTimeMillis();

		List<University> universities = universityDAO.filter(query);

		long end = System.currentTimeMillis();
		long time = end - start;

		System.out.println("------------------------------------------------------");
		System.out.println("Search ");
		for (University university : universities)
		{
			System.out.printf("%-4s %-40s %s\n", university.getId(), university.getName(), university.getWebsite());
			System.out.printf("%-4s\n", university);
			assertTrue(university.getLocation() != null);

		}

		System.out.println("Time : " + time);
	}
	
	
	/**
	 * Test the search method.
	 * 
	 * @see UniversityDAO#listUniversityLike(String)
	 */
	@Test
	public void testListUniversityLike()
	{
		// List<University> universities =
		// universityDAO.listUniversityLike("%mcg%");
		//
		// System.out.println("------------------------------------------------------");
		// System.out.println("List university like ");
		// for (University university : universities)
		// {
		// System.out.printf("%-4s %-40s %s\n", university.getId(),
		// university.getName(), university.getWebsite());
		// assertTrue(university.getLocation() != null);
		// }
	}
}

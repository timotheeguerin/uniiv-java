/**
 * 
 */
package ca.bendo.db.dao.professor;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.university.UniversityDAO;
import ca.bendo.db.entity.professor.Professor;
import ca.bendo.db.entity.professor.ProfessorUniversity;
import ca.bendo.db.entity.university.University;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TestProfessorUniversityDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Transactional
public class TestProfessorUniversityDAO
{
	/**
	 * 
	 */
	@Autowired
	private ProfessorUniversityDAO professorUniversityDAO;

	/**
	 * 
	 */
	@Autowired
	private UniversityDAO universityDAO;

	/**
	 * 
	 */
	@Autowired
	private ProfessorDAO professorDAO;

	/**
	 * 
	 */
	@Test
	public void testGetRatingAvg()
	{
		List<ProfessorUniversity> profs = professorUniversityDAO.listProfessorAtUniversity(1L);

		for (ProfessorUniversity prof : profs)
		{
			System.out.println(prof.getProfessor().getFirstName());
		}
	}

	/**
	 * 
	 */
	@Test
	public void testAdd()
	{
		ProfessorUniversity profUni = new ProfessorUniversity();
		Professor professor = professorDAO.getById(1L);
		University university = universityDAO.getById(1L);
		profUni.setProfessor(professor);
		profUni.setUniversity(university);
		professorUniversityDAO.add(profUni);
	}
}

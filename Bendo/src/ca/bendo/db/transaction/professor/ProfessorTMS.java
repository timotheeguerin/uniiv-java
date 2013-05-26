/**
 * 
 */
package ca.bendo.db.transaction.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.professor.ProfessorDAO;
import ca.bendo.db.entity.professor.Professor;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ProfessorTMS</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class ProfessorTMS
{
	/**
	 * 
	 */
	@Autowired
	private ProfessorDAO professorDAO;


	/**
	 * 
	 * @param professor
	 *            professor to save
	 */
	public void addProfessor(final Professor professor)
	{
		professorDAO.add(professor);
	}

	/**
	 * 
	 * @param professor
	 *            professor to save
	 */
	public void updateProfessor(final Professor professor)
	{
		professorDAO.update(professor);
	}
}

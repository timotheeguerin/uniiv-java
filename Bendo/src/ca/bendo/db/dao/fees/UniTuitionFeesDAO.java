/**
 * 
 */
package ca.bendo.db.dao.fees;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.fees.UniversityTuitionFees;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UniTuitionFeesDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class UniTuitionFeesDAO extends HibernateDAO<UniversityTuitionFees>
{

	/**
	 * 
	 */
	public UniTuitionFeesDAO()
	{
		setType(UniversityTuitionFees.class);
	}

	/**
	 * @return a list of currencies
	 */
	@SuppressWarnings("unchecked")
	public List<UniversityTuitionFees> listTuitionFees()
	{
		return (List<UniversityTuitionFees>) getSession().createCriteria(UniversityTuitionFees.class).list();
	}

	/**
	 * @param idFees
	 *            Id fees
	 * @return soijf
	 */
	@SuppressWarnings("unchecked")
	public List<UniversityTuitionFees> listTuitionFeesForFees(final long idFees)
	{

		return (List<UniversityTuitionFees>) getSession().createCriteria(UniversityTuitionFees.class)
				.add(Restrictions.eq("fees.id", idFees)).list();
	}
}

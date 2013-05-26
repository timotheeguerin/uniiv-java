/**
 * 
 */
package ca.bendo.db.dao.fees;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.fees.Currency;
import ca.bendo.db.entity.fees.UniversityFees;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UniPrice</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class UniFeesDAO extends HibernateDAO<UniversityFees>
{
	/**
	 * 
	 */
	public UniFeesDAO()
	{
		setType(UniversityFees.class);
	}

	/**
	 * @return a list of currencies
	 */
	@SuppressWarnings("unchecked")
	public final List<Currency> listCurrencies()
	{
		return (List<Currency>) getSession().createCriteria(Currency.class).list();
	}

	/**
	 * @return a list of universities fees
	 */
	@SuppressWarnings("unchecked")
	public final List<UniversityFees> listUniversityFees()
	{
		return (List<UniversityFees>) getSession().createCriteria(UniversityFees.class).list();
	}

}

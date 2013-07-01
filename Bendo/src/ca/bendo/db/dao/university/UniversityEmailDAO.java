/**
 * 
 */
package ca.bendo.db.dao.university;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.university.University;
import ca.bendo.db.entity.university.UniversityEmail;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UniversityEmailDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class UniversityEmailDAO extends HibernateDAO<UniversityEmail>
{
	/**
	 * 
	 */
	protected void init()
	{
		setType(UniversityEmail.class);
	}

	/**
	 * 
	 * @param email
	 *            Email address
	 * @return university having the domain of given email
	 */
	public University getUniversityFromEmail(final String email)
	{
		String[] array = email.split("@", 2);
		if (array.length != 2)
		{
			return null;
		}
		String emailDomain = array[1];
		return getUniversityFromEmailDomain(emailDomain);
	}

	/**
	 * 
	 * @param emailDomain
	 *            Domain of the email( ex: mail.mcgill.ca)
	 * @return university having the given email domain
	 */
	public University getUniversityFromEmailDomain(final String emailDomain)
	{
		return (University) createCriteria().add(Restrictions.eq("emailDomain", emailDomain)).uniqueResult();
	}
}

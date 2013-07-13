/**
 * 
 */
package ca.bendo.db.dao.user;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.user.UserPermission;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UserPermissionDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class UserPermissionDAO extends HibernateDAO<UserPermission>
{

	/**
	 * Default contructor.
	 */
	public UserPermissionDAO()
	{
		setType(UserPermission.class);
	}

	/**
	 * 
	 * @param name
	 *            name
	 * @return permission with the given name
	 */
	public UserPermission getByName(final String name)
	{
		return (UserPermission) getSession().createCriteria(UserPermission.class)
				.add(Restrictions.eq("permission", name)).uniqueResult();
	}
}

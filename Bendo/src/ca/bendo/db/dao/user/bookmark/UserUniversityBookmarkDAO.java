/**
 * 
 */
package ca.bendo.db.dao.user.bookmark;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.user.bookmark.UserUniversityBookmark;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UserUniversityBookmarkDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class UserUniversityBookmarkDAO extends HibernateDAO<UserUniversityBookmark>
{
	/**
	 * 
	 */
	public UserUniversityBookmarkDAO()
	{
		setType(UserUniversityBookmark.class);
	}

	/**
	 * @param userId
	 *            User ID
	 * @return univeristy bookmarks of the given user
	 */
	@SuppressWarnings("unchecked")
	public List<UserUniversityBookmark> getUserBookmarks(final long userId)
	{
		return (List<UserUniversityBookmark>) createCriteria().add(Restrictions.eq("userId", userId))
				.createAlias("university", "university").addOrder(Order.asc("university.name")).list();
	}
}

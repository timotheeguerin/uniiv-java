/**
 * 
 */
package ca.bendo.db.dao.user.bookmark;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.user.bookmark.UserUniversityBookmark;
import ca.bendo.db.entity.user.bookmark.UserWikiBookmark;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UserWikiBookmarkDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */

@Repository
@Transactional
public class UserWikiBookmarkDAO extends HibernateDAO<UserWikiBookmark>
{
	/**
	 * 
	 */
	public UserWikiBookmarkDAO()
	{
		setType(UserWikiBookmark.class);
	}

	/**
	 * @param userId
	 *            User id
	 * @return wiki bookmarks
	 */
	@SuppressWarnings("unchecked")
	public List<UserWikiBookmark> getUserBookmarks(final long userId)
	{
		return (List<UserWikiBookmark>) createCriteria().add(Restrictions.eq("userId", userId))
				.createAlias("wiki", "wiki").addOrder(Order.asc("wiki.title")).list();
	}

	/**
	 * @param userId
	 *            User Id
	 * @param wikiID
	 *            wikiId
	 * @return bookmark
	 */
	public UserWikiBookmark getUserBookmark(final long userId, final long wikiID)
	{

		return (UserWikiBookmark) createCriteria().add(Restrictions.eq("userId", userId))
				.add(Restrictions.eq("wiki.id", wikiID)).createAlias("university", "university")
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}
}

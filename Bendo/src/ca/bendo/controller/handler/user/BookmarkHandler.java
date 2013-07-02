/**
 * 
 */
package ca.bendo.controller.handler.user;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.university.UniversityDAO;
import ca.bendo.db.dao.user.bookmark.UserUniversityBookmarkDAO;
import ca.bendo.db.dao.user.bookmark.UserWikiBookmarkDAO;
import ca.bendo.db.dao.wiki.WikiDAO;
import ca.bendo.db.entity.university.University;
import ca.bendo.db.entity.user.User;
import ca.bendo.db.entity.user.bookmark.UserBookmarkCenter;
import ca.bendo.db.entity.user.bookmark.UserUniversityBookmark;
import ca.bendo.db.entity.user.bookmark.UserWikiBookmark;
import ca.bendo.db.entity.wiki.Wiki;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>BookmarkHandler</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class BookmarkHandler
{

	/**
	 * 
	 */
	@Autowired
	private UserWikiBookmarkDAO wikiBookmarkDAO;

	/**
	 * 
	 */
	@Autowired
	private UserUniversityBookmarkDAO universityBookmarkDAO;

	/**
	 * 
	 */
	@Autowired
	private UniversityDAO universityDAO;

	/**
	 * 
	 */
	@Autowired
	private WikiDAO wikiDAO;

	/**
	 * @param user
	 *            user
	 * @param universityId
	 *            UniversityId
	 * @return boolean
	 */
	public boolean bookmarkUniversity(final User user, final long universityId)
	{
		University university = universityDAO.getById(universityId);
		if (university == null)
		{
			return false;
		}

		UserUniversityBookmark existing = universityBookmarkDAO.getUserBookmark(user.getId(), universityId);
		if (existing != null)
		{
			return true;
		}

		UserUniversityBookmark bookmark = new UserUniversityBookmark();
		bookmark.setUniversity(university);
		bookmark.setUserId(user.getId());
		bookmark.setDateCreated(new Date());
		universityBookmarkDAO.add(bookmark);

		return true;
	}

	/**
	 * @param user
	 *            user
	 * @param universityId
	 *            UniversityId
	 * @return boolean
	 */
	public boolean unBookmarkUniversity(final User user, final long universityId)
	{
		University university = universityDAO.getById(universityId);
		if (university == null)
		{
			return false;
		}

		UserUniversityBookmark bookmark = universityBookmarkDAO.getUserBookmark(user.getId(), universityId);
		if (bookmark == null)
		{
			return true;
		}

		universityBookmarkDAO.delete(bookmark);

		return true;
	}

	/**
	 * @param user
	 *            user
	 * @param wikiId
	 *            UniversityId
	 * @return boolean
	 */
	public boolean bookmarkWiki(final User user, final long wikiId)
	{
		Wiki wiki = wikiDAO.getById(wikiId);
		if (wiki == null)
		{
			return false;
		}

		UserWikiBookmark existing = wikiBookmarkDAO.getUserBookmark(user.getId(), wikiId);
		if (existing != null)
		{
			return true;
		}

		UserWikiBookmark bookmark = new UserWikiBookmark();
		bookmark.setWiki(wiki);
		bookmark.setUserId(user.getId());
		bookmark.setDateCreated(new Date());
		wikiBookmarkDAO.add(bookmark);

		return true;
	}

	/**
	 * @param user
	 *            user
	 * @param wikiId
	 *            UniversityId
	 * @return boolean
	 */
	public boolean unBookmarkWiki(final User user, final long wikiId)
	{
		Wiki wiki = wikiDAO.getById(wikiId);
		if (wiki == null)
		{
			return false;
		}

		UserWikiBookmark bookmark = wikiBookmarkDAO.getUserBookmark(user.getId(), wikiId);
		if (bookmark == null)
		{
			return true;
		}

		wikiBookmarkDAO.delete(bookmark);

		return true;
	}
}

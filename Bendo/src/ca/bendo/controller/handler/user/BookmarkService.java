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
import ca.bendo.db.dao.wiki.WikiPageDAO;
import ca.bendo.db.entity.university.University;
import ca.bendo.db.entity.user.User;
import ca.bendo.db.entity.user.bookmark.UserUniversityBookmark;
import ca.bendo.db.entity.user.bookmark.UserWikiBookmark;
import ca.bendo.db.entity.wiki.WikiPage;

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
public class BookmarkService
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
	private WikiPageDAO wikiDAO;

	/**
	 * @param user
	 *            user
	 * @param universityId
	 *            UniversityId
	 * @return boolean
	 */
	public boolean toogleBookmarkUniversity(final User user, final long universityId)
	{
		University university = universityDAO.getById(universityId);
		if (university == null)
		{
			return false;
		}

		UserUniversityBookmark existing = universityBookmarkDAO.getUserBookmark(user.getId(), universityId);
		if (existing == null)
		{
			bookmarkUniversity(user, university);
		} else
		{
			unBookmarkUniversity(existing);
		}
		return true;
	}

	/**
	 * @param user
	 *            user
	 * @param university
	 *            UniversityId
	 * @return boolean
	 */
	public boolean bookmarkUniversity(final User user, final University university)
	{

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
	 * @param university
	 *            UniversityId
	 */
	public void unBookmarkUniversity(final User user, final University university)
	{

		UserUniversityBookmark bookmark = universityBookmarkDAO.getUserBookmark(user.getId(), university.getId());
		if (bookmark != null)
		{
			unBookmarkUniversity(bookmark);
		}
	}

	/**
	 * @param bookmark
	 *            Markmark
	 */
	public void unBookmarkUniversity(final UserUniversityBookmark bookmark)
	{
		universityBookmarkDAO.delete(bookmark);
	}

	/**
	 * @param user
	 *            user
	 * @param wikiId
	 *            wiki Id
	 * @return boolean
	 */
	public boolean toogleBookmarkWikiPage(final User user, final long wikiId)
	{
		WikiPage wiki = wikiDAO.getById(wikiId);
		if (wiki == null)
		{
			return false;
		}

		UserWikiBookmark existing = wikiBookmarkDAO.getUserBookmark(user.getId(), wikiId);
		if (existing == null)
		{
			bookmarkWikiPage(user, wiki);
		} else
		{
			unBookmarkWikiPage(existing);
		}
		return true;
	}

	/**
	 * @param user
	 *            user
	 * @param wiki
	 *            Wiki page
	 * @return boolean
	 */
	public boolean bookmarkWikiPage(final User user, final WikiPage wiki)
	{

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
	 * @param wiki
	 *            Wiki
	 * @return boolean
	 */
	public boolean unBookmarkWikiPage(final User user, final WikiPage wiki)
	{
		UserWikiBookmark bookmark = wikiBookmarkDAO.getUserBookmark(user.getId(), wiki.getId());
		if (bookmark == null)
		{
			return true;
		}

		wikiBookmarkDAO.delete(bookmark);

		return true;
	}

	/**
	 * @param bookmark
	 *            Markmark
	 */
	public void unBookmarkWikiPage(final UserWikiBookmark bookmark)
	{
		wikiBookmarkDAO.delete(bookmark);
	}

}

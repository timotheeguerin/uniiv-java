/**
 * 
 */
package ca.bendo.db.entity.user.bookmark;

import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.OneToMany;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UserBookmark</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Embeddable
public class UserBookmarkCenter
{
	/**
	 * 
	 */
	@OneToMany(mappedBy = "userId")
	private List<UserUniversityBookmark> universityBookmarks;

	/**
	 * 
	 */
	@OneToMany(mappedBy = "userId")
	private List<UserWikiBookmark> wikiBookmarks;

	/**
	 * @return the universityBookmarks
	 */
	public List<UserUniversityBookmark> getUniversityBookmarks()
	{
		return universityBookmarks;
	}

	/**
	 * @param universityBookmarks
	 *            the universityBookmarks to set
	 */
	public void setUniversityBookmarks(final List<UserUniversityBookmark> universityBookmarks)
	{
		this.universityBookmarks = universityBookmarks;
	}

	/**
	 * @return the wikiBookmarks
	 */
	public List<UserWikiBookmark> getWikiBookmarks()
	{
		return wikiBookmarks;
	}

	/**
	 * @param wikiBookmarks
	 *            the wikiBookmarks to set
	 */
	public void setWikiBookmarks(final List<UserWikiBookmark> wikiBookmarks)
	{
		this.wikiBookmarks = wikiBookmarks;
	}

}

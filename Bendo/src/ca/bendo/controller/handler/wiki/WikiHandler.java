/**
 * 
 */
package ca.bendo.controller.handler.wiki;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.forum.FormattedContentDAO;
import ca.bendo.db.dao.forum.TagDAO;
import ca.bendo.db.dao.wiki.WikiPageDAO;
import ca.bendo.db.dao.wiki.WikiRevisionDAO;
import ca.bendo.db.entity.forum.FormattedContent;
import ca.bendo.db.entity.forum.Tag;
import ca.bendo.db.entity.user.User;
import ca.bendo.db.entity.wiki.WikiPage;
import ca.bendo.db.entity.wiki.WikiRevision;
import ca.bendo.form.entity.wiki.WikiPageForm;
import ca.bendo.session.UserSession;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>WikiHandler</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class WikiHandler
{
	
	/**
	 * 
	 */
	@Autowired
	private WikiPageDAO wikiDAO;

	/**
	 * 
	 */
	@Autowired
	private FormattedContentDAO contentDAO;

	/**
	 * 
	 */
	@Autowired
	private WikiRevisionDAO revisionDAO;

	/**
	 * 
	 */
	@Autowired
	private TagDAO tagDAO;

	/**
	 * 
	 * @param request
	 *            Request
	 * @param form
	 *            Frq
	 * @return if the creation is succesful
	 */
	public WikiPage createNewWiki(final HttpServletRequest request, final WikiPageForm form)
	{
		User user = UserSession.getSession(request).getUser();

		FormattedContent content = new FormattedContent(form.getContent());
		contentDAO.add(content);

		WikiPage wiki = new WikiPage();
		wiki.setTitle(request.getParameter("title"));
		wiki.setUser(user.getId());

		WikiRevision revision = new WikiRevision(user, content, form.getComment(), wiki);

		wiki.setDateCreated(revision.getDateCreated());
		wiki.setDateEdited(revision.getDateCreated());
		wiki.setLastRevision(revision);

		wiki.setValitated(false);

		List<Tag> tags = tagDAO.getTags(form.getTags());
		wiki.setTags(tags);
		wikiDAO.add(wiki);
		revisionDAO.add(revision);

		return wiki;
	}

	/**
	 * @param wikiId
	 *            Wiki id
	 * @param request
	 *            Request
	 * @param form
	 *            Frq
	 * @return if the creation is succesful
	 */
	public WikiPage editWiki(final HttpServletRequest request, final long wikiId, final WikiPageForm form)
	{
		User user = UserSession.getSession(request).getUser();

		FormattedContent content = new FormattedContent(form.getContent());
		contentDAO.add(content);

		WikiPage wiki = new WikiPage();
		wiki.setTitle(request.getParameter("title"));
		wiki.setUser(user.getId());

		wiki.createRevision(user, form.getComment(), content);

		List<Tag> tags = tagDAO.getTags(form.getTags());
		wiki.setTags(tags);
		wikiDAO.saveOrUpdate(wiki);

		return wiki;
	}

	/**
	 * @param wikiId
	 *            Wiki id
	 * @return form setup with the given wiki
	 */
	public WikiPageForm loadWikiForm(final long wikiId)
	{
		WikiPage page = wikiDAO.getById(wikiId);
		if (page == null)
		{
			return null;
		}

		return new WikiPageForm(page);
	}

	/**
	 * @param wikiId
	 *            Wiki id
	 * @return if the deletion was succesful
	 */
	public boolean delete(final long wikiId)
	{
		return wikiDAO.delete(wikiId);
	}
}

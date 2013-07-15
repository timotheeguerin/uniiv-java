/**
 * 
 */
package ca.bendo.controller.handler.wiki;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.wiki.WikiPageDAO;
import ca.bendo.db.dao.wiki.WikiRevisionDAO;
import ca.bendo.db.entity.wiki.WikiPage;
import ca.bendo.db.entity.wiki.WikiRevision;
import ca.bendo.utils.DifferenceUtils;

/**
 * @author Timoth�e Gu�rin
 * @version Bendo
 * 
 *          <b>WikiRevisionHandler</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class WikiRevisionService
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
	private WikiRevisionDAO revisionDAO;

	/**
	 * 
	 * @param wikiId
	 *            Wiki page id
	 * @return list of the revision for the given wiki page
	 */
	public List<WikiRevision> listRevision(final long wikiId)
	{
		return revisionDAO.listWikiRevsions(wikiId, Order.asc("dateCreated"));
	}

	/**
	 * Calculate the difference between the given revision and its parent
	 * revision.
	 * 
	 * @param wikiId
	 *            Id of the wiki
	 * @param revisionId
	 *            id of the revision
	 * @return html format of the difference
	 */
	public String getDiffrence(final long wikiId, final long revisionId)
	{
		WikiPage page = wikiDAO.getById(wikiId);
		if (page == null)
		{
			return "";
		}

		WikiRevision revision = revisionDAO.getById(revisionId);
		if (revision == null)
		{
			return "";
		}

		String original = "";
		String change = revision.getContent().getContent();
		if (revision.getParent() != null)
		{
			original = revision.getParent().getContent().getContent();
		}

		String diff = DifferenceUtils.difference(original, change);
		return diff;
	}
}

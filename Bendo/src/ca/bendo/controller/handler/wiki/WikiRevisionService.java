/**
 * 
 */
package ca.bendo.controller.handler.wiki;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.wiki.WikiPageDAO;
import ca.bendo.db.dao.wiki.WikiRevisionDAO;
import ca.bendo.db.entity.wiki.WikiRevision;
import ca.bendo.utils.DifferenceUtils;

/**
 * @author Timothée Guérin
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
	 * 
	 * @return
	 */
	public String getDiffrence(final long wikiId, final long revisionId)
	{
		// WikiPage page = wikiDAO.getById(wikiId);
		// if (page == null)
		// {
		// return "";
		// }
		//
		// WikiRevision revision = revisionDAO.getById(revisionId);
		// if (revision == null)
		// {
		// return "";
		// }
		//
		// String original = "";
		// if (revision.getParent() != null)
		// {
		// original = revision.getParent().getContent().getContent();
		// }

		String original = fileToStr("D:/dev/test/file_old.txt");
		String revision = fileToStr("D:/dev/test/file_new.txt");

		String diff = DifferenceUtils.difference(original, revision);
		System.out.println(diff);
		return diff;
	}

	private String fileToStr(final String filename)
	{
		StringBuilder result = new StringBuilder();
		String line = "";
		try
		{
			BufferedReader in = new BufferedReader(new FileReader(filename));
			while ((line = in.readLine()) != null)
			{
				result.append(line).append("\n");
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return result.toString();
	}
}

/**
 * 
 */
package ca.bendo.controller.handler.wiki;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.wiki.WikiRevisionDAO;
import ca.bendo.db.entity.wiki.WikiRevision;

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
	private WikiRevisionDAO revisionDAO;

	/**
	 * 
	 * @param wikiId
	 * @return
	 */
	public List<WikiRevision> listRevisionByDate(final long wikiId)
	{
		return revisionDAO.list();

	}

}

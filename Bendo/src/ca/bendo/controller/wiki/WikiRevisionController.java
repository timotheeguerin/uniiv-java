/**
 * 
 */
package ca.bendo.controller.wiki;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.bendo.controller.handler.wiki.WikiRevisionService;
import ca.bendo.db.entity.wiki.WikiRevision;

/**
 * @author Timoth�e Gu�rin
 * @version Bendo
 * 
 *          <b>RevisionController</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Controller
public class WikiRevisionController
{
	/**
	 * 
	 */
	@Autowired
	private WikiRevisionService service;

	/**
	 * 
	 * @param request
	 *            Request
	 * @param wikiId
	 *            Wiki id
	 * @return jsp page
	 */
	@RequestMapping(value = "/wiki/{wikiId}/history", method = RequestMethod.GET)
	public String listWikiRevisions(final HttpServletRequest request, @PathVariable("wikiId") final long wikiId)
	{
		List<WikiRevision> revisions = service.listRevisionByDate(wikiId);
		request.setAttribute("revisions", revisions);
		return "views/wiki/wiki_revisions";
	}
}

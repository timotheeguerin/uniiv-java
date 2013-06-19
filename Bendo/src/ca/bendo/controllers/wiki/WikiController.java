/**
 * 
 */
package ca.bendo.controllers.wiki;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.bendo.db.dao.wiki.WikiDAO;
import ca.bendo.db.entity.wiki.Wiki;

/**
 * @author toby
 * 
 *         <b>ForumGroupController</b>
 *         <p>
 *         </p>
 * 
 * 
 */
@Controller
@Transactional
public class WikiController
{
	
	@Autowired
	private WikiDAO wikiDAO;

	/**
	 * 
	 * @param request
	 *            Request
	 * @return jsp page
	 */
	@RequestMapping(value = "/wiki/list", method = RequestMethod.GET)
	public String list(final HttpServletRequest request)
	{
		request.setAttribute("wikis", wikiDAO.listSort());
		return "views/wiki/list";
	}
	
	/**
	 * 
	 * @param request
	 *            Request
	 * @return jsp page
	 */
	@RequestMapping(value = "/wiki/show/{id}", method = RequestMethod.GET)
	public String list(@PathVariable(value = "id") long id, final HttpServletRequest request)
	{
		request.setAttribute("wiki", wikiDAO.getById(id));
		return "views/wiki/show";
	}
	
	
}

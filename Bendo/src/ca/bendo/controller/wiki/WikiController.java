/**
 * 
 */
package ca.bendo.controller.wiki;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.bendo.controller.handler.wiki.WikiHandler;
import ca.bendo.controller.interceptor.annotation.Title;
import ca.bendo.db.dao.user.bookmark.UserWikiBookmarkDAO;
import ca.bendo.db.dao.wiki.WikiPageDAO;
import ca.bendo.db.entity.user.User;
import ca.bendo.db.entity.wiki.WikiPage;
import ca.bendo.form.entity.wiki.WikiPageEditForm;
import ca.bendo.form.entity.wiki.WikiPageForm;
import ca.bendo.session.UserSession;

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
	/**
	 * 
	 */
	@Autowired
	private WikiHandler handler;
	
	/**
	 * 
	 */
	@Autowired
	private UserWikiBookmarkDAO userWikiBookmarkDAO;
	
	/**
	 * 
	 */
	@Autowired
	private WikiPageDAO wikiDAO;

	/**
	 * 
	 * @param request
	 *            Request
	 * @return jsp page
	 */
	@RequestMapping(value = "/wiki", method = RequestMethod.GET)
	public String list(final HttpServletRequest request)
	{
		request.setAttribute("wikis", wikiDAO.listSort());
		return "views/wiki/list";
	}

	/**
	 * @param id
	 *            Id
	 * @param request
	 *            request Request
	 * @return jsp page
	 */
	@Transactional
	@RequestMapping(value = "/wiki/{id}", method = RequestMethod.GET)
	public String show(@PathVariable(value = "id") final long id, final HttpServletRequest request)
	{
		request.setAttribute("wiki", wikiDAO.getById(id));
		if(UserSession.getSession(request).isLogin())
		{
			User user = UserSession.getSession(request).getUser();
			boolean bookmarked = false;
			if(userWikiBookmarkDAO.getUserBookmark(user.getId(), id) != null)
			{
				bookmarked = true;
			}
			request.setAttribute("watched", bookmarked);
		}
		return "views/wiki/show";
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @return jsp page
	 */
	// @Secured("wiki.create")
	@RequestMapping(value = "/wiki/new", method = RequestMethod.GET)
	public String add(final HttpServletRequest request)
	{
		return setupNewWikiPage(request, new WikiPageForm());

	}

	/**
	 * @param form
	 *            Form
	 * @param result
	 *            result
	 * @param request
	 *            Request
	 * @return jsp page
	 */
	// TODO validate title
	// @Secured("wiki.create")
	@Title("wiki_new_title")
	@RequestMapping(value = "/wiki/new", method = RequestMethod.POST)
	public String handleNewWiki(final HttpServletRequest request, @Valid final WikiPageForm form,
			final BindingResult result)
	{
		if (result.hasErrors())
		{
			return setupNewWikiPage(request, form);
		} else
		{
			WikiPage page = handler.createNewWiki(request, form);
			return "redirect:/wiki/" + page.getId();
		}

	}

	/**
	 * @param request
	 *            Request
	 * @param form
	 *            Form
	 * @return page
	 */
	public String setupNewWikiPage(final HttpServletRequest request, final WikiPageForm form)
	{
		request.setAttribute("wikiPageForm", form);
		return "views/wiki/add";
	}

	/**
	 * @param wikiId
	 *            id
	 * @param request
	 *            Request
	 * @return jsp page
	 */
	// @Secured("wiki.edit")
	@RequestMapping(value = "/wiki/{id}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable(value = "id") final long wikiId, final HttpServletRequest request)
	{
		return setupEditWikiPage(request, handler.loadWikiForm(wikiId));

	}

	/**
	 * @param form
	 *            form
	 * @param wikiId
	 *            Wiki ID
	 * @param request
	 *            Request
	 * @param result
	 *            form errors
	 * @return jsp page
	 * 
	 */
	// TODO validate title
	// @Secured("wiki.edit")
	@RequestMapping(value = "/wiki/{wikiId}/edit", method = RequestMethod.POST)
	public String handleEdit(@PathVariable(value = "wikiId") final long wikiId, final HttpServletRequest request,
			@Valid final WikiPageEditForm form, final BindingResult result)
	{
		if (result.hasErrors())
		{
			return setupEditWikiPage(request, form);
		} else
		{
			WikiPage page = handler.editWiki(request, wikiId, form);
			return "redirect:/wiki/" + page.getId();
		}

	}

	/**
	 * @param request
	 *            Request
	 * @param form
	 *            Form
	 * @return page
	 */
	public String setupEditWikiPage(final HttpServletRequest request, final WikiPageEditForm form)
	{
		if (form == null)
		{
			return "views/errors/error404";
		}
		request.setAttribute("wikiPageEditForm", form);
		return "views/wiki/edit";
	}

	/**
	 * @param wikiId
	 *            Wiki ID
	 * @param request
	 *            Request
	 * @return jsp page
	 */
	// @Secured("wiki.delete")
	@RequestMapping(value = "/wiki/{wikiId}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable(value = "wikiId") final long wikiId, final HttpServletRequest request)
	{
		if (handler.delete(wikiId))
		{
			return "redirect:/wiki";
		} else
		{
			return "redirect:/wiki";
		}
	}
}

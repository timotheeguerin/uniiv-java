/**
 * 
 */
package ca.bendo.controller.wiki;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.bendo.db.dao.forum.FormattedContentDAO;
import ca.bendo.db.dao.wiki.WikiDAO;
import ca.bendo.db.entity.forum.FormattedContent;
import ca.bendo.db.entity.wiki.Wiki;
import ca.bendo.form.entity.forum.ForumQuestionForm;

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

	@Autowired
	private FormattedContentDAO contentDAO;

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
	public String show(@PathVariable(value = "id") long id, final HttpServletRequest request)
	{
		request.setAttribute("wiki", wikiDAO.getById(id));
		return "views/wiki/show";
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @return jsp page
	 */
	// @Secured("wiki.create")
	@RequestMapping(value = "/wiki/add", method = RequestMethod.GET)
	public String add(final HttpServletRequest request)
	{
		ForumQuestionForm replyEntity = new ForumQuestionForm();
		request.setAttribute("replyEntity", replyEntity);
		return "views/wiki/add";
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @return jsp page
	 */
	// TODO validate title
	// @Secured("wiki.create")
	@RequestMapping(value = "/wiki/add", method = RequestMethod.POST)
	public String addPost(final HttpServletRequest request, @Valid final ForumQuestionForm frq,
			final BindingResult result)
	{
		FormattedContent content = new FormattedContent();
		content.setContent(frq.getContent());
		content.processContent();
		Wiki wiki = new Wiki();
		wiki.setDateCreated(new Date());
		wiki.setTitle(request.getParameter("title"));
		wiki.setContent(content);
		contentDAO.add(content);
		wikiDAO.add(wiki);
		// request.setAttribute("title", wiki.getTitle());
		// request.setAttribute("content", frq.getContent().toString());
		return "redirect:./show/" + wiki.getId();
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @return jsp page
	 */
	// @Secured("wiki.edit")
	@RequestMapping(value = "/wiki/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable(value = "id") long id, final HttpServletRequest request)
	{
		Wiki wiki = wikiDAO.getById(id);
		ForumQuestionForm replyEntity = new ForumQuestionForm();
		replyEntity.setContent(wiki.getContent().getContent());
		String title = wiki.getTitle();
		request.setAttribute("replyEntity", replyEntity);
		request.setAttribute("title", title);
		return "views/wiki/edit";
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @return jsp page
	 */
	// TODO validate title
	// @Secured("wiki.edit")
	@RequestMapping(value = "/wiki/edit/{id}", method = RequestMethod.POST)
	public String editPost(@PathVariable(value = "id") final long id, final HttpServletRequest request,
			@Valid final ForumQuestionForm frq, final BindingResult result)
	{
		Wiki wiki = wikiDAO.getById(id);
		FormattedContent content = wiki.getContent();
		content.setContent(frq.getContent());
		content.processContent();
		wiki.setDateEdited(new Date());
		wiki.setTitle(request.getParameter("title"));
		wiki.setContent(content);
		contentDAO.saveOrUpdate(content);
		wikiDAO.saveOrUpdate(wiki);
		return "redirect:../show/" + wiki.getId();
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @return jsp page
	 */
	// @Secured("wiki.delete")
	@RequestMapping(value = "/wiki/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable(value = "id") long id, final HttpServletRequest request)
	{
		wikiDAO.delete(id);
		return "redirect:../list";
	}
}

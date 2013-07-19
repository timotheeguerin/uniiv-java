/**
 * 
 */
package ca.bendo.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.bendo.db.dao.user.UserDAO;

/**
 * @author Timothée Guérin
 * @version Uniiv
 * 
 *          <b>RepositoryManagerContoller</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Controller
public class RepositoryManagerContoller
{
	@Autowired
	private RepositoryManagerHandler handler;

	@Autowired
	private ApplicationContext context;

	/**
	 * @param request
	 *            Request
	 * @param action
	 *            action
	 * @return jsp page
	 */
	@RequestMapping(value = "/admin/test/{action}", method = RequestMethod.GET)
	public final String action(final HttpServletRequest request, @PathVariable("action") final String action)
	{
		if (action.equalsIgnoreCase("list"))
		{
			handler.list(request, context.getBean(UserDAO.class));
			return "views/admin/list";
		} else if (action.equalsIgnoreCase("new"))
		{
			handler.add(request, context.getBean(UserDAO.class));
			return "views/admin/new";
		}
		return "";	

	}
}

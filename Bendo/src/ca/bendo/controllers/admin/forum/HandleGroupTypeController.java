/**
 * 
 */
package ca.bendo.controllers.admin.forum;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.bendo.db.dao.forum.ForumGroupTypeDAO;
import ca.bendo.db.entity.forum.ForumGroupType;
import ca.bendo.form.entity.TableForm;
import ca.bendo.user.security.annotation.Secured;
import ca.bendo.views.table.FilterForm;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>HandleGroupTypeController</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Controller
public class HandleGroupTypeController
{
	/**
	 * 
	 */
	@Autowired
	private ForumGroupTypeDAO groupTypeDAO;

	/**
	 * 
	 * @param request
	 *            Request
	 * @return Jsp page
	 */
	@RequestMapping(value = "/admin/forum/groupType", method = RequestMethod.GET)
	public String displayGroupTypeList(final HttpServletRequest request)
	{
		TableForm form = new TableForm();
		form.load(request);
		List<ForumGroupType> forumGroupTypes = groupTypeDAO.search(form.getQuery(), form.getFirstResult(),
				form.getResultPerPage());
		request.setAttribute("forumGroupTypes", forumGroupTypes);
		int pageNum = (int) groupTypeDAO.searchCount(form.getQuery()) / form.getResultPerPage() + 1;
		request.setAttribute("tableUtils", new FilterForm(form.getPage(), pageNum, form.getQuery()));
		return "views/admin/forum/groupTypeList";
	}
	


}

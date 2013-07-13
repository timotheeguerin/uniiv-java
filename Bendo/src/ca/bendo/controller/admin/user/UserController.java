/**
 * 
 */
package ca.bendo.controller.admin.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.bendo.controller.interceptor.annotation.Secured;
import ca.bendo.db.dao.user.UserDAO;
import ca.bendo.db.dao.user.UserPermissionDAO;
import ca.bendo.db.entity.user.User;
import ca.bendo.db.entity.user.UserPermission;
import ca.bendo.form.entity.admin.users.PermissionsForm;

/**
 * @author toby
 * @version Bendo 

 * <b>UserController</b>
 * <p></p>
 *
 * 


 */
@Controller
public class UserController
{
	/**
	 * 
	 */
	@Autowired
	private UserDAO userDAO;
	
	/**
	 * 
	 */
	@Autowired
	private UserPermissionDAO userPermissionDAO;
	
	/**
	 * 
	 * @param request
	 *            Request
	 * @return Jsp page
	 */
	@Secured("admin")
	@RequestMapping(value = "/admin/users", method = RequestMethod.GET)
	public String index(final HttpServletRequest request)
	{
		return "views/admin/users/index";
	}
	
	/**
	 * 
	 * @param request
	 *            Request
	 * @return Jsp page
	 */
	@Secured("admin")
	@RequestMapping(value = "/admin/users/list", method = RequestMethod.GET)
	@Transactional
	public String list(final HttpServletRequest request)
	{
		request.setAttribute("users", userDAO.list());
		return "views/admin/users/list";
	}
	
	/**
	 * 
	 * @param request
	 *            Request
	 * @return Jsp page
	 */
	@Secured("admin")
	@RequestMapping(value = "/admin/users/show/{userId}", method = RequestMethod.GET)
	@Transactional
	public String show(@PathVariable(value = "userId") final long id, final HttpServletRequest request)
	{
		User user = userDAO.getById(id);
		if(user == null) return "redirect:/404";
		PermissionsForm form = new PermissionsForm();
		for(UserPermission perm: user.getPermissions())
		{
			form.getPermissions().add(perm.getId());
		}
		request.setAttribute("permissionsForm", form);
		request.setAttribute("permissions", userPermissionDAO.list());
		request.setAttribute("user", user);
		return "views/admin/users/show";
	}
	
	/**
	 * 
	 * @param request
	 *            Request
	 * @return Jsp page
	 */
	@Secured("admin")
	@RequestMapping(value = "/admin/users/show/{userId}", method = RequestMethod.POST)
	@Transactional
	public String update(@PathVariable(value = "userId") final long id, final HttpServletRequest request, final PermissionsForm form)
	{
		User user = userDAO.getById(id);
		List<UserPermission> newperms = new ArrayList<UserPermission>();
		for(long permlong: form.getPermissions())
		{
			UserPermission tperm = userPermissionDAO.getById(permlong);
			if(tperm == null) continue;
			newperms.add(tperm);
		}
		user.setPermissions(newperms);
		return "redirect:../list";
	}
	
	
}

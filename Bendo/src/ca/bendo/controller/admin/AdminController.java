/**
 * 
 */
package ca.bendo.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.bendo.controller.interceptor.annotation.Secured;

/**
 * @author toby
 * @version Bendo 

 * <b>Admin</b>
 * <p></p>
 *
 * 


 */
@Controller
public class AdminController
{
	/**
	 * 
	 * @param request
	 *            Request
	 * @return Jsp page
	 */
	@Secured("admin")
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String index(final HttpServletRequest request)
	{
		return "views/admin/index";
	}
}

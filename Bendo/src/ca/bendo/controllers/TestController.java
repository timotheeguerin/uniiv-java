/**
 * 
 */
package ca.bendo.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.bendo.head.HeadManager;
import ca.bendo.translation.translation.Translator;

/**
 * @author vava04
 * @version Bendo
 * 
 *          <b>TestController</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Controller
public class TestController
{
	/**
	 * Method handling main page.
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return JSP page
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public final String home(final HttpServletRequest request, final HttpServletResponse response)
	{
		((HeadManager) request.getAttribute("head")).getTitle().setTitle("Signup");

		Translator trans = (Translator) request.getAttribute("translator");

		String page = request.getParameter("page");

		return "views/" + page;
	}

}

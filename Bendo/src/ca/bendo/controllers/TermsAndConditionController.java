/**
 * 
 */
package ca.bendo.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TermsAndConditionController</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Controller
public class TermsAndConditionController
{
	/**
	 * Method handling terms and conditions page.
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return JSP page
	 */
	@RequestMapping(value = "/conditions", method = RequestMethod.GET)
	public String home(final HttpServletRequest request, final HttpServletResponse response)
	{
		return "views/termsconditions";
	}

}

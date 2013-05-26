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

 * <b>DiscoverController</b>
 * <p></p>
 *
 * 


 */
@Controller
public class DiscoverController
{
	/**
	 * Method handling discover page.
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return JSP page
	 */
	@RequestMapping(value = "/discover", method = RequestMethod.GET)
	public final String home(final HttpServletRequest request, final HttpServletResponse response)
	{
		return "views/search/discover";
	}

}

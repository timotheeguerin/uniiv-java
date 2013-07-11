package ca.bendo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.bendo.search.FilterSystemLoader;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController
{

	/**
	 * 
	 */
	@Autowired
	private FilterSystemLoader filterSystemLoader;

	/**
	 *
	 */
	private Logger log = Logger.getLogger(HomeController.class);

	/**
	 * Method handling main page.
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return JSP page
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(final HttpServletRequest request, final HttpServletResponse response)
	{
		request.getAttribute("translator");
		request.setAttribute("contentMargin", false);

		return "views/home";
	}

}
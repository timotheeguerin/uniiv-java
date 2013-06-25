package ca.bendo.controllers;

import java.util.Properties;

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
		System.out.println("HomeController: Passing through...");

		request.getAttribute("translator");
		request.setAttribute("contentMargin", false);

		Properties p = new Properties();
		p.setProperty("test1", "test1value");
		p.setProperty("test2", "test2value");

		request.setAttribute("testp", p);
		return "views/home";
	}

	/**
	 * Method handling main page.
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return JSP page
	 */
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public String homePST(final HttpServletRequest request, final HttpServletResponse response)
	{
		System.out.println("HomeController: Passing through...");

		log.debug("AUTH: " + request.getHeader("Authorization"));

		return "views/home";
	}

}
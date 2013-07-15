/**
 * 
 */
package ca.bendo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author toby
 * @version Bendo 

 * <b>SitemapController</b>
 * <p></p>
 *
 * 


 */
@Controller
public class SitemapController
{
	@RequestMapping(value="/sitemap/", method=RequestMethod.GET)
	public String index(final HttpServletRequest request)
	{
		return "views/sitemap";
	}
}

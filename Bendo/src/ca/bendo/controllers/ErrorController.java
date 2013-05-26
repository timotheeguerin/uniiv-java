/**
 * 
 */
package ca.bendo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ErrorController</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@RequestMapping({ "", "/" })
@Controller
public class ErrorController
{

	/**
	 * 
	 * @param errorId
	 *            error id
	 * @param model
	 *            model
	 * @return jsp page
	 */
	@RequestMapping("error/{errorId}")
	public String errorPage(@PathVariable final Integer errorId, final Model model)
	{
		model.addAttribute("errorId", errorId);
		
		return "views/errors/error" + errorId;
	}
}
